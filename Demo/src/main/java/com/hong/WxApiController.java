//package com.hong;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpSession;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.HashMap;
//
///**
// * Created by zhangyuhong
// * Date:2020/6/14
// */
//@CrossOrigin
//@Controller//注意这里没有配置 @RestController
//@RequestMapping("/api/ucenter/wx")
//public class WxApiController {
//
//    @GetMapping("login")
//    public String genQrConnect(HttpSession session) throws Exception {
//
//        System.out.println("sessionId = " + session.getId());
//
//        // 微信开放平台授权baseUrl
//        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
//                "?appid=%s" +
//                "&redirect_uri=%s" +
//                "&response_type=code" +
//                "&scope=snsapi_login" +
//                "&state=%s" +
//                "#wechat_redirect";
//
//        // 回调地址
//        String redirectUrl = ConstantPropertiesUtil.WX_OPEN_REDIRECT_URL; //获取业务服务器重定向地址
//        try {
//            redirectUrl = URLEncoder.encode(redirectUrl, "UTF-8"); //url编码
//        } catch (UnsupportedEncodingException e) {
//            throw new Exception("url错误");
//        }
//
//        // 防止csrf攻击（跨站请求伪造攻击）
//        //String state = UUID.randomUUID().toString().replaceAll("-", "");//一般情况下会使用一个随机数
//        String state = "imhelen";//为了让大家能够使用微信回调跳转服务器，这里填写你在ngrok的前置域名
//        System.out.println("生成 state = " + state);
//        session.setAttribute("wx-open-state", state);
//
//        //生成qrcodeUrl
//        String qrcodeUrl = String.format(
//                baseUrl,
//                ConstantPropertiesUtil.WX_OPEN_APP_ID,
//                redirectUrl,
//                state);
//
//        return "redirect:" + qrcodeUrl;
//    }
//
//
//    @Autowired
//    private MemberService memberService;
//
//    @GetMapping("callback")
//    public String callback(String code, String state, HttpSession session) {
//
//        System.out.println("sessionId = " + session.getId());
//
//        //得到授权临时票据code
//        System.out.println("code = " + code);
//        System.out.println("获取 state = " + state);
//
//        // 判断state是否合法
//        String stateStr = (String)session.getAttribute("wx-open-state");
//        System.out.println("存储 state = " + stateStr);
//        if (StringUtils.isEmpty(code) || StringUtils.isEmpty(stateStr) || !state.equals(stateStr)) {
//            throw new GuliException(ResultCodeEnum.ILLEGAL_CALLBACK_REQUEST_ERROR);
//        }
//
//        // 通过code获取access_token
//        String baseAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token" +
//                "?appid=%s" +
//                "&secret=%s" +
//                "&code=%s" +
//                "&grant_type=authorization_code";
//
//        String accessTokenUrl = String.format(
//                baseAccessTokenUrl,
//                ConstantPropertiesUtil.WX_OPEN_APP_ID,
//                ConstantPropertiesUtil.WX_OPEN_APP_SECRET,
//                code);
//
//        String result = null;
//        try {
//            result = HttpClientUtils.get(accessTokenUrl);
//            System.out.println(result);
//        } catch (Exception e) {
//            throw new GuliException(ResultCodeEnum.FETCH_ACCESSTOKEN_FAILD);
//        }
//
//        Gson gson = new Gson();
//        Map<String, Object> resultMap = gson.fromJson(result, HashMap.class);
//        if (resultMap.get("errcode") != null) {
//            throw new GuliException(ResultCodeEnum.FETCH_ACCESSTOKEN_FAILD);
//        }
//
//        String accessToken = (String) resultMap.get("access_token");
//        String openid = (String) resultMap.get("openid");
//
//        if (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(openid)) {
//            throw new GuliException(ResultCodeEnum.FETCH_ACCESSTOKEN_FAILD);
//        }
//
//        // 根据Openid返回用户信息。
//        Member member = memberService.getByOpenid(openid);
//        if (member == null) { //新用户
//
//            System.out.println("新用户注册");
//
//            //从微信获取用户信息
//            //获取用户基本信息
//            String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo" +
//                    "?access_token=%s" +
//                    "&openid=%s";
//            String userInfoUrl = String.format(baseUserInfoUrl, accessToken, openid);
//
//            //获取用户信息
//            String resultUserInfo = null;
//            try {
//                resultUserInfo = HttpClientUtils.get(userInfoUrl);
//                System.out.println(resultUserInfo);
//            } catch (Exception e) {
//                throw new GuliException(ResultCodeEnum.FETCH_USERINFO_ERROR);
//            }
//
//            Map<String, Object> resultUserInfoMap = gson.fromJson(resultUserInfo, HashMap.class);
//            if (resultMap.get("errcode") != null) {
//                throw new GuliException(ResultCodeEnum.FETCH_USERINFO_ERROR);
//            }
//
//            //保存用户信息
//            String nickname = (String)resultUserInfoMap.get("nickname");
//            String headimgurl = (String)resultUserInfoMap.get("headimgurl");
//
//            member = new Member();
//            member.setNickname(nickname);
//            member.setOpenid(openid);
//            member.setAvatar(headimgurl);
//            memberService.save(member);
//        }
//
//        // TODO 登录
//        System.out.println("登录");
//
//        return "redirect:http://localhost:3000";
//    }
//}
