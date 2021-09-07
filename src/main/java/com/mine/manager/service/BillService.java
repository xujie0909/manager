package com.mine.manager.service;

import com.mine.manager.entity.TransDetail;

import java.util.List;

/**
 * @author xujie
 */
public interface BillService {

    /**
     * 解析账单
     */
    void  dealBillDeail();

    /**
     * 保存单条账单
     * @param transDetai 账单
     */
    void saveBill(TransDetail transDetai);

    /**
     * 批量保存账单
     * @param transDetails 账单集合
     */
    void saveBills(List<TransDetail> transDetails);

}
