package cn.fcsca.serverconfig.config;

import cn.fcsca.serverconfig.component.HelloLocaleResolver;
import cn.fcsca.serverconfig.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * HelloConfig 使用WebMvcConfigurerAdapter来扩充SpringMVC的功能
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 16:29 2018-08-11
 */
@Configuration
public class HelloConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/fcsca").setViewName("success");
    }

    /**
     * 配置视图解析器 ,要使用@Bean将添加的组件添加到容器里
     *
     * @param 
     * @return
     * @author Fcscanf@樊乘乘
     * @date 下午 16:57 2018-08-11 
     */
    @Bean 
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html", "/", "/user/login");
            }
        };
        return webMvcConfigurerAdapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new HelloLocaleResolver();
    }
}
