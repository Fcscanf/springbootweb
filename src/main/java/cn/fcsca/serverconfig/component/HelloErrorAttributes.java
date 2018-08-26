package cn.fcsca.serverconfig.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * HelloErrorAttributes
 * @Component 注解将自定义ErrorAttributes添加到容器中
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 上午 10:15 2018-08-13
 */
@Component
public class HelloErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("company", "Fcscanf");
        //异常处理器携带的数据
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        errorAttributes.put("ext", ext);
        return errorAttributes;
    }
}
