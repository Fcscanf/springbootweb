package cn.fcsca.serverconfig.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginHandlerInterceptor 拦截器设置
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 15:04 2018-08-12
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * 登录前拦截检查 检查用户是否真正登录
     *
     * @param request
     * @param response
     * @return boolean
     * @author Fcscanf@樊乘乘
     * @date 下午 15:19 2018-08-12 
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
            request.setAttribute("msg","No Power,Please Sing In!");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
