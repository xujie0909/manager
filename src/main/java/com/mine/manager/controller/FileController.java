package com.mine.manager.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.mine.manager.common.Response;
import com.mine.manager.entity.TransDetail;
import com.mine.manager.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author xujie
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Autowired
    private BillService billService;

    private static HashMap<Integer, String> alipayRowHead = new HashMap<>();

    static {
        alipayRowHead.put(0, "交易号");
        alipayRowHead.put(1, "商家订单号");
        alipayRowHead.put(2, "交易创建时间");
        alipayRowHead.put(3, "付款时间");
        alipayRowHead.put(4, "最近修改时间");
        alipayRowHead.put(5, "交易来源地");
        alipayRowHead.put(6, "类型");
        alipayRowHead.put(7, "交易对方");
        alipayRowHead.put(8, "商品名称");
        alipayRowHead.put(9, "金额（元）");
        alipayRowHead.put(10, "收/支");
        alipayRowHead.put(11, "交易状态");
        alipayRowHead.put(12, "服务费（元）");
        alipayRowHead.put(13, "成功退款（元）");
        alipayRowHead.put(14, "备注");
        alipayRowHead.put(15, "资金状态");
    }

    private static HashMap<Integer, String> wechatRowHead = new HashMap<>();

    static {
        wechatRowHead.put(0, "交易时间");
        wechatRowHead.put(1, "交易类型");
        wechatRowHead.put(2, "交易对方");
        wechatRowHead.put(3, "商品");
        wechatRowHead.put(4, "收/支");
        wechatRowHead.put(5, "金额(元)");
        wechatRowHead.put(6, "支付方式");
        wechatRowHead.put(7, "当前状态");
        wechatRowHead.put(8, "交易单号");
        wechatRowHead.put(9, "商户单号");
        wechatRowHead.put(10, "备注");
    }

    private static ArrayList<String> sucState = new ArrayList<>();

    static {
        sucState.add("还款成功");
        sucState.add("交易成功");
        sucState.add("已存入零钱");
        sucState.add("支付成功");
        sucState.add("朋友已收钱");
    }

    @PostMapping("/wechat")
    public Response<String> wechatFile(MultipartFile file) throws Exception {

        List<List<Object>> details = detailDataFromRequest(file);

        Date curData = new Date();
        ArrayList<TransDetail> transDetails = new ArrayList<>();

        for (int i = 14; i < details.size(); i++) {

            List<Object> rowData = details.get(i);

            //校验excel行数据格式
            if (i == 14) {

                for (int j = 0; j < rowData.size(); j++) {
                    boolean valid = checkExcelValid(wechatRowHead, rowData);
                    if (!valid) {
                        log.error("文件格式不正确");
                        return new Response<>(500, "文件格式不正确", "");
                    }
                }

            } else {

                TransDetail transDetail = new TransDetail();
                try {
                    transDetail.setTransObjName((String) rowData.get(2));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                transDetail.setTransItemName((String) rowData.get(3));

                BigDecimal monycount;
                try {
                    monycount = new BigDecimal(rowData.get(5).toString().replace("￥", ""));
                } catch (Exception e) {
                    log.error("数据金额存在非法字符");
                    return new Response<>(500, "数据金额存在非法字符", "");
                }
                transDetail.setTransMoneyCount(monycount);

                transDetail.setTransDirection("支出".equals(rowData.get(4).toString().trim()) ? 0 : 1);

                String tranState = (String) rowData.get(7);
                transDetail.setTransState(sucState.contains(tranState) ? 1 : 0);
                transDetail.setTransStateDesc(tranState);

                transDetail.setTransSource(1);
                transDetail.setCreateUser("system");
                transDetail.setCreateTime(curData);
                transDetails.add(transDetail);

            }
        }
        //批量保存
        billService.saveBills(transDetails);
        return new Response<>("success");
    }

    @PostMapping("/alipay")
    public Response<String> alipayFile(MultipartFile file) throws Exception {

        List<List<Object>> details = detailDataFromRequest(file);

        Date curData = new Date();
        ArrayList<TransDetail> transDetails = new ArrayList<>();

        for (int i = 4; i < details.size() - 7; i++) {

            List<Object> rowData = details.get(i);

            //校验excel行数据格式
            if (i == 4) {

                boolean valid = checkExcelValid(alipayRowHead, rowData);
                if (!valid) {
                    log.error("文件格式不正确");
                    return new Response<>(500, "文件格式不正确", "");
                }

            } else {

                TransDetail transDetail = new TransDetail();
                try {
                    transDetail.setTransObjName((String) rowData.get(7));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                transDetail.setTransItemName((String) rowData.get(8));

                BigDecimal monycount;
                try {
                    monycount = new BigDecimal(rowData.get(9).toString());
                } catch (Exception e) {
                    log.error("数据金额存在非法字符");
                    return new Response<>(500, "数据金额存在非法字符", "");
                }
                transDetail.setTransMoneyCount(monycount);

                transDetail.setTransDirection("支出".equals(rowData.get(10).toString().trim()) ? 0 : 1);

                String tranState = (String) rowData.get(11);
                transDetail.setTransState(sucState.contains(tranState) ? 1 : 0);
                transDetail.setTransStateDesc(tranState);

                transDetail.setTransSource(0);
                transDetail.setCreateUser("system");
                transDetail.setCreateTime(curData);
                transDetails.add(transDetail);
            }
        }
        //批量保存
        billService.saveBills(transDetails);
        return new Response<>("success");
    }

    /**
     * 从请求中获取excel文件
     *
     * @param file 文件流
     * @return 解析之后的数据
     * @throws Exception
     */
    private List<List<Object>> detailDataFromRequest(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        return reader.read();
    }

    /**
     * 校验上传文件头是否合法
     *
     * @param rowHeadTempalte 定义好的文件头格式
     * @param rowData         上传的数据
     * @return 是否合法
     */
    private boolean checkExcelValid(HashMap<Integer, String> rowHeadTempalte, List<Object> rowData) {
        for (int j = 0; j < rowData.size(); j++) {
            String rowDataName = (String) rowData.get(j);
            String rowHead = rowHeadTempalte.get(j);
            if (!rowDataName.trim().equals(rowHead)) {
                return false;
            }
        }
        return true;
    }
}
