package day06_过滤器filter_监听器listener.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 讲解Filter的配置：用@WebFilter注解配置，常用属性有
 *      value或者urlPatterns：配置过滤器的拦截范围/过滤范围。常用写法有：
 *          精确拦截【用的少，了解】：/target，表示过滤器只拦截对/target的请求
 *              客户端请求 /target           拦截
 *              客户端请求 /admin/manager    不拦截
 *          拦截目录匹配的请求【用的多，最多的是/*】：要求以/开头，以*结尾。
 *              过滤器的拦截范围是：/*
 *              客户端请求 /target           拦截
 *              客户端请求 /admin/manager    拦截
 *              客户端请求 /index.jsp        拦截
 *
 *              过滤器的拦截范围是：/admin/*
 *              客户端请求 /target           不拦截
 *              客户端请求 /admin/manager    拦截
 *              客户端请求 /index.jsp        不拦截
 *              客户端请求 /admin/mgr.jsp    拦截
 *
 *          拦截扩展名匹配的请求【偶尔会用】：要求以*开头，以扩展名结尾
 *              过滤器的拦截范围是：*.jsp
 *              客户端请求 /target           不拦截
 *              客户端请求 /admin/manager    不拦截
 *              客户端请求 /index.jsp        拦截
 *              客户端请求 /admin/mgr.jsp    拦截
 *
 *          - 一个过滤器能不能拦截多种资源的请求？可以  urlPatterns = {"*.jsp", "/admin/*"}
 *              客户端请求 /target           不拦截
 *              客户端请求 /admin/manager    拦截
 *              客户端请求 /index.jsp        拦截
 *              客户端请求 /admin/mgr.jsp    拦截
 *
 *          - 一次请求可以有多少个过滤器拦截？多个。
 *              只要请求的资源，在过滤器的拦截范围内，过滤器就会执行过滤/拦截
 *
 *          - 能不能写成：`/admin/*.jsp`的写法？不能。不符合语法
 *              如果这么写，Tomcat启动时就会报错
 *
 *              如果确实要拦截  对  /admin下边的jsp 的请求，怎样实现呢？
 *                  1. 配置 urlPatterns = "/admin/*"
 *                  2. 在doFilter方法里：
 *                      获取客户端请求的资源路径: String uri = request.getRequestURI();
 *                      判断uri是否是以jsp结尾的：if uri.endWith(".jsp")
 *
 *      dispatcherTypes：配置过滤器的拦截方式
 */
//*******************注意的地方***************************
 /**          /admin/*.jsp`的写法？不能。不符合语法
         *              如果这么写，Tomcat启动时就会报错
         *              如果确实要拦截  对  /admin下边的jsp 的请求，怎样实现呢？
         *                  1. 配置 urlPatterns = "/admin/*"
         *                  2. 在doFilter方法里：
         *                      获取客户端请求的资源路径: String uri = request.getRequestURI();
         *                      判断uri是否是以jsp结尾的：if uri.endWith(".jsp")
         *
         *      dispatcherTypes：配置过滤器的拦截方式
/*@WebFilter(
        value = "/*",
        dispatcherTypes = DispatcherType.REQUEST,
        filterName = "demo02",
        initParams = {
                @WebInitParam(name = "aa", value = "AA"),
                @WebInitParam(name = "bb", value = "BB")
        }
)*/
/*@WebFilter(urlPatterns = "/target")*/
/*@WebFilter(urlPatterns = "/admin/*")*/
/*@WebFilter(urlPatterns = "*.jsp")*/
/*@WebFilter(urlPatterns = {"*.jsp", "/admin/*"})*/
/*@WebFilter(urlPatterns = "/admin/*.jsp")*/
/*@WebFilter("/*")*/
public class FilterDemo4 implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4....");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
