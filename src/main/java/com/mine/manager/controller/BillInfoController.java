package com.mine.manager.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mine.manager.entity.Result;
import com.mine.manager.entity.TransDetail;
import com.mine.manager.service.BillService;
import com.mine.manager.service.ITransDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xujie
 */
@RestController
@RequestMapping("/bill")
@Slf4j
public class BillInfoController {

    @Autowired
    private BillService billService;

    @Autowired
    private ITransDetailService iTransDetailService;

    @RequestMapping("/list")
    public Result<List<TransDetail>> listBillInfo() {

        EntityWrapper<TransDetail> transDetailEntityWrapper = new EntityWrapper<>();
        Page<TransDetail> page = iTransDetailService.selectPage(new Page<>(0, 10), transDetailEntityWrapper);

        Result<List<TransDetail>> result = new Result<>(transformDetail(page.getRecords()));
        result.setCount(page.getSize());
        log.info(JSON.toJSONString(result));

        return result;

    }

    /**
     * 结果数据的码值转换
     *
     * @param data data
     * @return list
     */
    private List<TransDetail> transformDetail(List<TransDetail> data) {
        for (TransDetail datum : data) {
            datum.setTransDirectionDesc(datum.getTransDirection() == 1 ? "收" : "支");
            datum.setTransSourceDesc(datum.getTransSource() == 1 ? "微信" : "支付宝");
        }
        return data;
    }

}
