package com.mine.manager.service.impl;

import com.mine.manager.mapper.TransDetaiMapper;
import com.mine.manager.entity.TransDetail;
import com.mine.manager.service.BillService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author xujie
 */
@Service
public class BillServiceImpl implements BillService {

    private final TransDetaiMapper transDetaiMapper;

    public BillServiceImpl(TransDetaiMapper transDetaiMapper) {
        this.transDetaiMapper = transDetaiMapper;
    }

    @Override
    public void dealBillDeail() {


    }

    @Override
    public void saveBill(TransDetail transDetai) {
        TransDetail t = new TransDetail();
        t.setId(1L);
        t.setCreateTime(new Date());
        t.setCreateUser("system");
        t.setTransState(1);
        t.setTransDirection(1);
        t.setTransMoneyCount(new BigDecimal(100));
        t.setTransItemName("方便面");
        t.setTransObjName("一个超时");
        int insert = transDetaiMapper.insert(t);
        System.out.println("save result" + insert);
    }

    @Override
    public void saveBills(List<TransDetail> transDetails) {
        for (TransDetail transDetail : transDetails) {
            transDetaiMapper.insert(transDetail);
        }
    }
}
