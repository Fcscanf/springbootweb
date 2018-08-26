package cn.fcsca.controller;

import cn.fcsca.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * HelloExceptionHandler
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 上午 9:51 2018-08-13
 */
@ControllerAdvice
public class HelloExceptionHandler {

    /**
     * 这种方式浏览器和客户端统一返回的是JSON数据
     * @ResponseBody
     * @ExceptionHandler(UserNotExistException.class)
     *
     * @param
     * @return
     * @author Fcscanf@樊乘乘
     * @date 上午 9:58 2018-08-13 
     */
    public Map<String, Object> handlerException(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());
        return map;
    }

    /**
     *
     *
     * @param e
     * @return 
     * @author Fcscanf@樊乘乘
     * @date 上午 10:00 2018-08-13 
     */
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
