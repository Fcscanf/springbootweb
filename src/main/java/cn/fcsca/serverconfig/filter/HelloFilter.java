package cn.fcsca.serverconfig.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * HelloFilter
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 21:14 2018-08-13
 */
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Hello Filter process...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
