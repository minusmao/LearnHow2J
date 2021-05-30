package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/* 测试：处理 JSON 请求 */
@Controller
@RequestMapping("json")
public class JSONController {
    @ResponseBody
    @RequestMapping(value = "submitCategory", method = RequestMethod.POST)
    public String submitCategory(@RequestBody Category category) {
        // 打印收到的数据
        System.out.println("接收到的 JSON 自动解析为 JavaBean 对象：" + category.toString());

        // 响应用的 JSON 对象
        JSONObject json = new JSONObject();
        json.put("category", JSONObject.toJSON(category));

        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/getManyCategory")
    public String getManyCategory() {
        List<Category> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setId(i);
            c.setName("分类名称:"+i);
            cs.add(c);
        }

        return JSONObject.toJSON(cs).toString();
    }
}
