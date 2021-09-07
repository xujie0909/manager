package com.mine.manager;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import javafx.scene.input.DataFormat;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTest {

    @Test
    public void test01(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.append("code",0);

        JSONArray totalRow = new JSONArray();

        JSONObject ele1 = new JSONObject();
        ele1.append("id","1");
        ele1.append("username","2");
        ele1.append("sex","3");
        ele1.append("city","4");
        ele1.append("sign","5");
        ele1.append("experience","6");
        ele1.append("score","7");
        ele1.append("classify","8");
        ele1.append("wealth","9");
        totalRow.add(ele1);

        JSONObject ele2 = new JSONObject();
        ele2.append("id","1");
        ele2.append("username","2");
        ele2.append("sex","3");
        ele2.append("city","4");
        ele2.append("sign","5");
        ele2.append("experience","6");
        ele2.append("score","7");
        ele2.append("classify","8");
        ele2.append("wealth","9");
        totalRow.add(ele2);

        JSONObject ele3 = new JSONObject();
        ele3.append("id","1");
        ele3.append("username","2");
        ele3.append("sex","3");
        ele3.append("city","4");
        ele3.append("sign","5");
        ele3.append("experience","6");
        ele3.append("score","7");
        ele3.append("classify","8");
        ele3.append("wealth","9");
        totalRow.add(ele3);


        jsonObject.append("data",totalRow);

        System.out.println(jsonObject);
    }

    @Test
    public void test02() throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:hh");
        Date parse = simpleDateFormat.parse("2021/9/5 17:11:22");
        System.out.println(parse);
    }
}
