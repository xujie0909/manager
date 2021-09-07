package com.mine.manager.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xujie
 * @since 2021-09-07
 */
@TableName("trans_detail")
public class TransDetail extends Model<TransDetail> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 交易对象
     */
    @TableField("trans_obj_name")
    private String transObjName;

    /**
     * 交易商品
     */
    @TableField("trans_item_name")
    private String transItemName;

    /**
     * 交易金额
     */
    @TableField("trans_money_count")
    private Double transMoneyCount;

    /**
     * 交易方向（收1or支0）
     */
    @TableField("trans_direction")
    private Integer transDirection;
    @TableField(exist = false)
    private String transDirectionDesc;

    /**
     * 交易状态描述
     */
    @TableField("trans_state_desc")
    private String transStateDesc;

    /**
     * 交易状态
     */
    @TableField("trans_state")
    private Integer transState;

    /**
     * 交易来源
     */
    @TableField("trans_source")
    private Integer transSource;
    @TableField(exist = false)
    private String transSourceDesc;

    /**
     * 交易类型
     */
    @TableField("trans_type")
    private int transType;

    /**
     * 交易时间
     */
    @TableField("trans_date")
    private Date transDate;

    /**
     * 记录创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 记录创建人
     */
    @TableField("create_user")
    private String createUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTransObjName() {
        return transObjName;
    }

    public void setTransObjName(String transObjName) {
        this.transObjName = transObjName;
    }
    public String getTransItemName() {
        return transItemName;
    }

    public void setTransItemName(String transItemName) {
        this.transItemName = transItemName;
    }
    public Double getTransMoneyCount() {
        return transMoneyCount;
    }

    public void setTransMoneyCount(Double transMoneyCount) {
        this.transMoneyCount = transMoneyCount;
    }
    public Integer getTransDirection() {
        return transDirection;
    }

    public void setTransDirection(Integer transDirection) {
        this.transDirection = transDirection;
    }
    public String getTransStateDesc() {
        return transStateDesc;
    }

    public void setTransStateDesc(String transStateDesc) {
        this.transStateDesc = transStateDesc;
    }
    public Integer getTransState() {
        return transState;
    }

    public void setTransState(Integer transState) {
        this.transState = transState;
    }
    public Integer getTransSource() {
        return transSource;
    }

    public void setTransSource(Integer transSource) {
        this.transSource = transSource;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setTransDirectionDesc(String transDirectionDesc) {
        this.transDirectionDesc = transDirectionDesc;
    }

    public String getTransDirectionDesc() {
        return transDirectionDesc;
    }

    public String getTransSourceDesc() {
        return transSourceDesc;
    }

    public void setTransSourceDesc(String transSourceDesc) {
        this.transSourceDesc = transSourceDesc;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public int getTransType() {
        return transType;
    }

    public void setTransType(int transType) {
        this.transType = transType;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    /*@Override
    public String toString() {
        return "TransDetail{" +
        "id=" + id +
        ", transObjName=" + transObjName +
        ", transItemName=" + transItemName +
        ", transMoneyCount=" + transMoneyCount +
        ", transDirection=" + transDirection +
        ", transStateDesc=" + transStateDesc +
        ", transState=" + transState +
        ", transSource=" + transSource +
        ", createTime=" + createTime +
        ", createUser=" + createUser +
        "}";
    }*/
}
