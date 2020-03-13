package com.hong.mm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hong.mm.pojo.WxMember;
import com.hong.mm.service.MemberService;
import com.hong.mm.utils.DateUtils;
import com.hong.mm.utils.JsonUtils;
import com.hong.mm.utils.WxUtil;
import com.itheima.mm.framework.annotation.Controller;
import com.itheima.mm.framework.annotation.RequestMapping;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyuhong
 * Date:2020/3/11
 */
@Controller
public class MemberController {
    private MemberService service = new MemberService();

    @RequestMapping("/member/login")
    public void saveMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HashMap map = JsonUtils.parseJSON2Object(request, HashMap.class);
        HashMap<String, Object> resultMap = new HashMap<>();
        System.out.println("login接收到的参数:" + map);
        String code = (String) map.get("code");
        //这里返回的是一个map,里面仅仅有session_key和openid
        //{"openid":"osYTz5NpU0lL86fH7kA2g2Bkt5WU","session_key":"tyoOVfhIjfBwXX/ickeO0A=="}
        JSONObject session_key_and_openid = WxUtil.get(code);
        String openid = session_key_and_openid.getString("openid");//这里可以直接getString,不需要get
        //查找数据库中是否存了这个用户
        //走到了这里
        WxMember member = service.findMemberByOpenId(openid);
        System.out.println("保存好的用户:" + member);
        try {
            if (member == null) {
                String encryptedData = (String) map.get("encryptedData");
                String sessionKey = (String) session_key_and_openid.get("session_key");
                String iv = (String) map.get("iv");
                JSONObject userInfo = WxUtil.getUserInfo(encryptedData, sessionKey, iv);
                System.out.println("userInfo:" + userInfo);
                //把JSONObject注入到bean
//                BeanUtils.populate(wxMember, userInfo);
                member = userInfo.toJavaObject(WxMember.class);
                //补全信息
                member.setCreateTime(DateUtils.parseDate2String(new Date()));
                System.out.println(member);
                //这时候数据库中没有该用户,要保存用户
                boolean count = service.saveWxMember(member);
                System.out.println("保存好的menber:" + member);
//                wx.setStorageSync('token', res.data.token)
//                wx.setStorageSync('userInfo', res.data.userInfo)
            }
            resultMap.put("token", openid);
            resultMap.put("userInfo", member);
            JsonUtils.printResult(response, resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.printResult(response, null);
        }

    }

    @RequestMapping("/member/setCityAndCourse")
    public void saveCityAndCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HashMap map = JsonUtils.parseJSON2Object(request, HashMap.class);
        //接收到的参数:{cityID=18, subjectID=1}
        String authorization = request.getHeader("Authorization");
        authorization = authorization.substring(7);
        map.put("openid", authorization);
        System.out.println(map);
        boolean b = service.saveWxMemberCityCourse(map);
        if (b) {
            System.out.println("保存cityID--subjectID成功");
        }
    }
}
