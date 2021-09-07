package com.mine.manager.rules;

import com.mine.manager.enums.TranSpecialTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xujie
 */
public class ItemNameRule {

    private static final HashMap<TranSpecialTypeEnum, ArrayList<String>> RULE_MAPPING =
            new HashMap<TranSpecialTypeEnum, ArrayList<String>>() {{
                put(TranSpecialTypeEnum.YUEBAOSHUYI, new ArrayList<String>() {{
                    add("收益发放");
                }});
            }};

    public static TranSpecialTypeEnum matchDetail(String name) {
        for (Map.Entry<TranSpecialTypeEnum, ArrayList<String>> ruleMapping : RULE_MAPPING.entrySet()) {
            if (ruleMapping.getValue().contains(name)) {
                return ruleMapping.getKey();
            }
        }
        return null;
    }

}
