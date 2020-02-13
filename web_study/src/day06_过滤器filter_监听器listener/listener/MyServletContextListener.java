package day06_过滤器filter_监听器listener.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ServletContextListener：通常用于监听服务器的启动和关闭
 *
 * SSM框架整合时，要求：在服务器启动时，就要加载Spring的配置文件
 *    要想实现这个效果：需要写一个监听器（Spring已经提供好了，到时候只要配置一下即可）
 *      监听ServletContext对象的创建（监听服务器的启动）
 *      一旦服务器启动，就加载Spring的配置文件
 *
 * @author liuyp
 * @date 2020/02/12
 */
/*@WebListener*/
public class MyServletContextListener implements ServletContextListener {

    /**
     * 在ServletContext对象被创建时（服务器启动时），执行的
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象创建了");
    }

    /**
     * 在ServletContext对象被销毁时（服务器关闭时），执行的
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象销毁了");
    }
}
