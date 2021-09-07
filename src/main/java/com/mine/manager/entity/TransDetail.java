package com.mine.manager.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xujie
 */
@Data
public class TransDetail {
    private Long id;
    private String transObjName;
    private String transItemName;
    private BigDecimal transMoneyCount;
    private int transDirection;
    private int transState;
    private String transStateDesc;
    /**
     * 交易来源：0-支付宝；1-微信
     */
    private int transSource;
    private Date createTime;
    private String createUser;
}
