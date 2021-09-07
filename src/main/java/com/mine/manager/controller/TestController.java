package com.mine.manager.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xujie
 */
@Controller
@Slf4j
public class TestController {


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     *   "code": 0,
     *   "totalRow": {
     *     "score": "666"
     *     ,"experience": "999"
     *   },
     *   "data": [{}, {}],
     *   "msg": "",
     *   "count": 1000
     * }
     * @return json
     */
    @GetMapping("/demo/data")
    @ResponseBody
    public JSONObject data() {
        log.info("===start===");
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("code",0);

        JSONArray totalRow = new JSONArray();

        JSONObject ele1 = new JSONObject();
        ele1.set("id","1");
        ele1.set("username","2");
        ele1.set("sex","3");
        ele1.set("city","4");
        ele1.set("sign","5");
        ele1.set("experience","6");
        ele1.set("score","7");
        ele1.set("classify","8");
        ele1.set("wealth","9");
        totalRow.add(ele1);

        JSONObject ele2 = new JSONObject();
        ele2.set("id","2");
        ele2.set("username","2");
        ele2.set("sex","3");
        ele2.set("city","4");
        ele2.set("sign","5");
        ele2.set("experience","6");
        ele2.set("score","7");
        ele2.set("classify","8");
        ele2.set("wealth","9");
        totalRow.add(ele2);

        JSONObject ele3 = new JSONObject();
        ele3.set("id","3");
        ele3.set("username","2");
        ele3.set("sex","3");
        ele3.set("city","4");
        ele3.set("sign","5");
        ele3.set("experience","6");
        ele3.set("score","7");
        ele3.set("classify","8");
        ele3.set("wealth","9");
        totalRow.add(ele3);

        jsonObject.set("data",totalRow);
        jsonObject.set("count",1000);


        return jsonObject;
    }



}
