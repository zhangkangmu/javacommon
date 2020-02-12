package day06_过滤器filter_监听器listener.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")//访问所有资源之前，都会执行该过滤器
public class FilterDemo3 implements Filter {
// 1.多个过滤器拦截同一请求，执行的顺序是：按照过滤器类名排序，靠前的先过滤，靠后的后过滤
// 2.如果是在web.xml中配置的话,就按照前后顺序依次执行
//        <!--使用web.xml，配置过滤器-->
//    <!--配置demo1filter-->
//    <filter>
//        <filter-name>demo1</filter-name>
//        <filter-class>com.itheima.filter.Demo1Filter</filter-class>
//    </filter>
//
//    <!--配置demo02filter-->
//    <filter>
//        <filter-name>demo02</filter-name>
//        <filter-class>com.itheima.filter.Demo02Filter</filter-class>
//    </filter>
//
//    <!--配置demo03filter-->
//    <filter>
//        <filter-name>demo03</filter-name>
//        <filter-class>com.itheima.filter.Demo03Filter</filter-class>
//    </filter>
//
//    <filter-mapping>
//        <filter-name>demo1</filter-name>
//        <url-pattern>/*</url-pattern>
//    </filter-mapping>
//    <filter-mapping>
//        <filter-name>demo03</filter-name>
//        <url-pattern>/*</url-pattern>
//    </filter-mapping>
//    <filter-mapping>
//        <filter-name>demo02</filter-name>
//        <url-pattern>/*</url-pattern>
//    </filter-mapping>

    /**
     * 在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。用于加载资源
     *
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        /*
            FilterConfig：过滤器的配置信息对象。Tomcat会创建FilterConfig对象，并传递进来，我们可以直接使用
            作用有三个：
         */
        //1. 获取当前过滤器的名称【了解】
        String filterName = config.getFilterName();
        System.out.println("过滤器名称：" + filterName);

        //2. 获取当前过滤器的初始化参数【了解，基本不用了】
        String aa = config.getInitParameter("aa");
        System.out.println("初始化参数aa：" + aa);

        //3. 获取ServletContext对象【掌握】
        ServletContext context = config.getServletContext();
        System.out.println("ServletContext对象：" + context);

        System.out.println("init....");
    }

    /**
     * 每一次请求被拦截资源时，会执行。执行多次
     *
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息增强
        System.out.println("filterDemo执行了....");
        //放行
        chain.doFilter(req, resp);
        //对response对象的响应消息增强
        System.out.println("filterDemo回来了...");
         /*
            ServletRequest：代表http请求的request对象。实际开发中，通常要强转成HttpServletRequest
            ServletResponse：代表HTTP响应的response对象。实际开发中，通常要强转成HttpServletResponse
            FilterChain【重点】：过滤器链对象。
                对象里是：能够拦截本次请求的所有过滤器，组成的一个链对象（相当于一个队列）
                作用是：放行请求。
                    放行请求到下一个过滤器对象；如果已经是最后一个过滤器了，请求最终到达目标资源
                如何放行：chain.doFilter(request, response)
         */
    }

    /**
     * 在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源
     */
    public void destroy() {
        System.out.println("destroy....");
    }

}
