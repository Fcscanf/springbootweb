package cn.fcsca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * LoginController 处理登录
 * @RequestMapping(value = "/user/login" ,method = RequestMethod.POST)可以用
 * @PostMapping(value = "/user/login")代替，该注解指明了请求方式
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 22:44 2018-08-11
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            //login success 防止表单重复提交，重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            //login fail
            map.put("msg", "用户名密码错误！");
            return "login";
        }
    }
}
