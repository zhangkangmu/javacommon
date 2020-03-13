package com.hong.mm.controller;

import com.alibaba.fastjson.JSON;
import com.hong.mm.entity.QuestionList;
import com.hong.mm.service.CatalogService;
import com.hong.mm.utils.JsonUtils;
import com.itheima.mm.framework.annotation.Controller;
import com.itheima.mm.framework.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/13
 */
@Controller
public class CatalogController {
    private CatalogService catalogService = new CatalogService();

    @RequestMapping("/category/list")
    public void loadCourses(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //categoryKind(区分技术点、企业、方向)  categoryType(区分题库列表、错题本列表、收藏本列表、练习本列表)
        HashMap listMap = JsonUtils.parseJSON2Object(request, HashMap.class);
        HashMap<String, Object> resultMap = new HashMap<>();

        System.out.println("questionList:" + listMap);
        //携带了两个参数过来,categoryKind,categoryType
        // 还有Authorization: Bearer osYTz5NpU0lL86fH7kA2g2Bkt5WU--截取字符串可以获取openid--微信的唯一标识
        String authorization = request.getHeader("Authorization");
        authorization = authorization.substring(7);

        //1.找到微信用户 wx_member,为什么先找,因为这个语句用的字段比较散,而且比较多
        //复杂的sql语句尽可能分开,先查询一部分
        HashMap wxMemberHashMap = catalogService.findWxMember(authorization);
        wxMemberHashMap.put("categoryKind",listMap.get("categoryKind"));
        wxMemberHashMap.put("categoryType",listMap.get("categoryType"));
        List list = catalogService.getList(wxMemberHashMap);
        System.out.println("返回的用户获取数量:" + list);
        if (list != null && list.size() > 0) {
            resultMap.put("items", list);
            resultMap.put("errmsg", "加载列表成功");
            JsonUtils.printResult(response, resultMap);
        }else {
            resultMap.put("errmsg", "加载列表失败");
            JsonUtils.printResult(response, resultMap);
        }

    }

}
