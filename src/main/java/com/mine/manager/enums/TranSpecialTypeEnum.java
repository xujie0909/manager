package com.mine.manager.enums;

/**
 * 专项交易类型
 *
 * @author xujie
 */
public enum TranSpecialTypeEnum {

    /**
     * 未定义类型
     */
    UNDEFAULT(0, "未定义"),

    /**
     * 电费
     */
    DIANFEI(1, "电费"),

    CHUXING(2,"出行"),
    /**
     * 余额宝收益类型
     */
    YUEBAOSHUYI(3, "余额宝收益"),

    ;

    private int code;
    private String desc;

    private TranSpecialTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
