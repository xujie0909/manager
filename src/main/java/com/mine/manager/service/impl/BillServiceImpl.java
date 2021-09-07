package com.mine.manager.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mine.manager.entity.TransDetail;
import com.mine.manager.mapper.TransDetailMapper;
import com.mine.manager.service.BillService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xujie
 */
@Service
public class BillServiceImpl implements BillService {

    private final TransDetailMapper transDetailMapper;

    public BillServiceImpl(TransDetailMapper transDetailMapper) {
        this.transDetailMapper = transDetailMapper;
    }

    @Override
    public void saveBills(List<TransDetail> transDetails) {
        for (TransDetail transDetail : transDetails) {
            transDetailMapper.insert(transDetail);
        }
    }

    @Override
    public List<TransDetail> list() {
        EntityWrapper<TransDetail> wrapper = new EntityWrapper<>();
        wrapper.setEntity(null);
        return transDetailMapper.selectPage(new RowBounds(), wrapper);
    }

}
