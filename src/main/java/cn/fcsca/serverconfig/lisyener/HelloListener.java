package cn.fcsca.serverconfig.lisyener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * HelloListener
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 21:25 2018-08-13
 */
public class HelloListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized start...web application start");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized over...web application over");
    }
}
