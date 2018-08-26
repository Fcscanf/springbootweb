package cn.fcsca.serverconfig.config;

import cn.fcsca.serverconfig.filter.HelloFilter;
import cn.fcsca.serverconfig.lisyener.HelloListener;
import cn.fcsca.serverconfig.servlet.HelloServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * HelloSeverConfig 配置Servlet的三大组件
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 20:13 2018-08-13
 */
public class HelloSeverConfig {

    //注册三大组件
    /**
     *
     *
     * @param
     * @return
     * @author Fcscanf@樊乘乘
     * @date 下午 20:46 2018-08-13
     */
    @Bean
    public ServletRegistrationBean helloServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new HelloServlet(),"/helloServlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    /**
     * 注册过滤器
     *
     * @param
     * @return
     * @author Fcscanf@樊乘乘
     * @date 下午 21:20 2018-08-13
     */
    @Bean
    public FilterRegistrationBean helloFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new HelloFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/helloServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean helloListener() {
        ServletListenerRegistrationBean<HelloListener> helloListenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new HelloListener());
        return helloListenerServletListenerRegistrationBean;
    }

    /**
     * 注册配置嵌入式的Servlet容器,SpringBoot2.0以上版本已经抛弃EmbeddedServletContainerCustomizer定制器
     * 改用WebServerFactoryCustomizer
     *
     * @param
     * @return
     * @author Fcscanf@樊乘乘
     * @date 下午 22:04 2018-08-13
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8085);
            }
        };
    }
}
