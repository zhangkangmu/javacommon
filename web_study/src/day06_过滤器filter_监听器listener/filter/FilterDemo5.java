package day06_过滤器filter_监听器listener.filter;

import javax.servlet.*;
import java.io.IOException;

 /** 配置过滤器的拦截方式：通过注解的dispatcherTypes来配置的
         *      value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST：拦截客户端的请求，对/index.jsp的请求
         *          客户端直接访问/index.jsp                   会拦截
         *          客户端访问/forword，请求转发到/index.jsp    不拦截
         *          客户端访问/redirect，重定向到/index.jsp     会拦截
         *
         *      value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD：拦截请求转发的请求，对/index.jsp的请求
         *          客户端直接访问/index.jsp                   不拦截
         *          客户端访问/forword，请求转发到/index.jsp    会拦截
         *          客户端访问/redirect，重定向到/index.jsp     不拦截
         *
         *      一个过滤器，能否拦截多种方式？可以
         *      value = "/index.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST}
         *          客户端直接访问/index.jsp                   拦截
         *          客户端访问/forword，请求转发到/index.jsp    拦截
         *          客户端访问/redirect，重定向到/index.jsp     拦截
  */
//浏览器直接请求index.jsp或者转发访问index.jsp。该过滤器才会被执行
//@WebFilter(value="/*",dispatcherTypes ={ DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo5 implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo5....");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
