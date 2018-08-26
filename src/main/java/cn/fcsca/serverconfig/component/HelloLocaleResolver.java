package cn.fcsca.serverconfig.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * HelloLocaleResolver 自定义区域国际化,根据浏览器参数进行国际化请求处理
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 19:55 2018-08-11
 */
public class HelloLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)) {
            String[] spilt = l.split("_");
            locale = new Locale(spilt[0], spilt[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
