package day06_过滤器filter_监听器listener.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author liuyp
 * @date 2020/02/12
 */
@WebListener
public class MyRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }
}
