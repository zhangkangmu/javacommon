package day06_过滤器filter_监听器listener.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * @author liuyp
 * @date 2020/02/12
 */
@WebListener
public class MyServletContextAttrListener implements ServletContextAttributeListener {
    /**
     * 向ServletContext里添加了数据时触发
     * @param scae
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {

    }

    /**
     * 从ServletContext里删除了数据时触发
     * @param scae
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {

    }

    /**
     * ServletContext里的数据被修改时触发。比如：
     *      1. ServletContext里有一项数据，key是abc，value是"ABC"
     *      2. 再执行一次 servletContext.setAttribute("abc", "AAA")
     * @param scae
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {

    }
}
