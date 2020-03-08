package com.hong.mm.security;

import com.hong.mm.pojo.User;
import com.itheima.mm.framework.annotation.Controller;
import com.itheima.mm.framework.annotation.RequestMapping;
import com.itheima.mm.framework.utils.ClassScannerUtils;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/8
 */
public class SecurityFilter implements Filter {

    //注意,所有需要权限的都要在存在这里,也就是配置了PreAuthority,或者在web.xml中配置
    private HashMap<String, String> contextMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        contextMap = new HashMap<>();
        String configLocation = filterConfig.getInitParameter("configLocation");
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(configLocation);
        SAXReader saxReader = new SAXReader();
        try {
//        需要在web.xml中配置configLocation的init-param

            Document read = saxReader.read(in);
            List<Element> list = read.selectNodes("//security");
            for (Element element : list) {
                Attribute pattern = element.attribute("pattern");
                Attribute has_role = element.attribute("has_role");
                contextMap.put(pattern.getValue(), has_role.getValue());
            }
            Element node = (Element) read.selectSingleNode("//scan");
            Attribute attPackage = node.attribute("package");
            String packageValue = attPackage.getValue();
            List<Class<?>> classsFromPackage = ClassScannerUtils.getClasssFromPackage(packageValue);
            for (Class<?> aClass : classsFromPackage) {
                //1.获取所有的controller的类
                boolean hasController = aClass.isAnnotationPresent(Controller.class);
                if (hasController) {
                    //2.获取所以的PreAurthorize标识的方法
                    Method[] methods = aClass.getMethods();
                    for (Method method : methods) {
                        //有权限,那肯定有路径
                        boolean hasPreAuthority = method.isAnnotationPresent(PreAuthority.class);
                        if (hasPreAuthority) {
                            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                            String requestMapValue = requestMapping.value();
                            PreAuthority preAuthority = method.getAnnotation(PreAuthority.class);
                            //获取了权限的keyword,后面和获取user的keyword比较,是否包含,如果包含,就有访问权限
                            String preAuthorityValue = preAuthority.value();
                            //key是资源访问路径,value:权限的keyword
                            contextMap.put(requestMapValue, preAuthorityValue);
                        }
                    }
                }
            }
            System.out.println("封装好了的所以需要访问权限的html或者servlet---"+contextMap);
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //FilterChain:过滤器链对象  作用是：放行放行。放行请求 到下一个过滤器；如果下一个过滤器不存在，请求就到达目标资源
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//注意:HttpServletRequest才有获取session的方法
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletesponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();
        //用户当前权限
        User user = (User) session.getAttribute("user");

        //获取请求的uri:/项目名/资源路径.do--->提取出资源路径-->和作为key从map里取值
        //获取请求的uri:/项目名/....html
        String requestURI = httpServletRequest.getRequestURI();
        String contextPath = httpServletRequest.getContextPath();
        String url = requestURI.substring(contextPath.length());
        if (url.endsWith(".do")) {
            url = url.replace(".do", "");
        }
        String authority = contextMap.get(url);  //获取访问路径需要的权限

        //3. 获取当前用户拥有的角色（权限）
        //3.1 第一种情况:未登录的情况处理
        //请求的这个资源，不需要进行权限控制，直接放行即可
        if (authority == null || "".equalsIgnoreCase(authority)) {
            System.out.println("用户正在登录,不需要判断权限,直接放行--authority == null--url:"+url);
            chain.doFilter(httpServletRequest, httpServletesponse);
            return;
        }

        //3.2.第二种情况:外部直接输入网址访问,没有登录
        if (user == null) {
            System.out.println("请登录");
            httpServletesponse.sendRedirect(contextPath + "/login.html");
            return;
        }
        List<String> authorityList = user.getAuthorityList();
        //3.3已经登录的情况,没有任何权限,需要判断user用户的权限是否有
        if (authorityList == null || authorityList.size() == 0) {
            System.out.println(url + "：当前用户权限不足，请切换用户");
            response.getWriter().print("您没有足够任何访问权限,请联系管理员");
            return;
        }
        //3.3 登录了,但是得看下权限是不是足够
        String[] splitUriAuthority = authority.split(",");
        boolean hasEnoughAuthority = false;  //默认没有足够的权限
        for (String uriauthrity : splitUriAuthority) {
            //比如：访问资源，有任意一个角色即可访问：ROLE_ADMIN,ROLE_QUESTION_RECORDER
            if (authorityList.contains(uriauthrity)) {
                //说明有需要访问页面的任意一个权限
                hasEnoughAuthority = true;
                break;
            }
        }
        if (hasEnoughAuthority) {
            //有足够的权限访问
            System.out.println(user.getUsername() + "有足够的权限可以被访问");
            chain.doFilter(httpServletRequest,httpServletesponse);
        } else {
            System.out.println(user.getUsername() + "：当前用户权限不足，请切换用户--" + "访问的路径是:" + url);
            httpServletesponse.getWriter().print("用户权限不足,请更换用户");
        }
    }


    @Override
    public void destroy() {

    }
}
