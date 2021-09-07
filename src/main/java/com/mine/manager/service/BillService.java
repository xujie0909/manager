package com.mine.manager.service;

import com.mine.manager.entity.TransDetail;

import java.util.List;

/**
 * @author xujie
 */
public interface BillService {

    /**
     * 批量保存账单
     * @param transDetails 账单集合
     */
    void saveBills(List<TransDetail> transDetails);


    /**
     * 账单清单
     * @return list
     */
    List<TransDetail> list();

}
