package com.mine.manager.rules;

import com.mine.manager.enums.TranSpecialTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xujie
 */
public class ObjNameRule {

    private static final HashMap<TranSpecialTypeEnum, ArrayList<String>> RULE_MAPPING =
            new HashMap<TranSpecialTypeEnum, ArrayList<String>>() {{
                put(TranSpecialTypeEnum.YUEBAOSHUYI, new ArrayList<String>() {{
                    add("中欧基金管理有限公司");
                }});
                put(TranSpecialTypeEnum.DIANFEI, new ArrayList<String>() {{
                    add("国网北京市电力公司");
                }});
                put(TranSpecialTypeEnum.CHUXING, new ArrayList<String>() {{
                    add("北京轨道交通路网管理有限公司");
                    add("滴滴出行");
                    add("嘀嗒出行");
                }});
            }};

    public static TranSpecialTypeEnum matchDetail(String name) {
        for (Map.Entry<TranSpecialTypeEnum, ArrayList<String>> ruleMapping : RULE_MAPPING.entrySet()) {
            if (ruleMapping.getValue().contains(name.trim())) {
                return ruleMapping.getKey();
            }
        }
        return null;
    }
}
