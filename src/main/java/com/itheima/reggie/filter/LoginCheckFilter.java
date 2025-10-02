package com.itheima.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;

import java.io.IOException;

@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    private static final Logger log = LoggerFactory.getLogger(LoginCheckFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        BaseContext.setCurrentId(20L);
        chain.doFilter(request, response);
//            return;
//
//        String requestURI = request.getRequestURI();
//
//        String[] urls = new String[]{
//                "/employee/login",
//                "/employee/logout",
//                "/backend/**",
//                "/front/**",
//                "/common/**",
//                "/user/sendMsg",
//                "/user/login"
//
//        };
//
//        if (check(urls, requestURI)) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        try {
//            if (request.getSession().getAttribute("employee") != null) {
//                Long empId = (Long) request.getSession().getAttribute("employee");
//                BaseContext.setCurrentId(empId);
//                chain.doFilter(request, response);
//                return;
//            }
//            response.setContentType("application/json;charset=UTF-8");
//            response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
//        } finally {
//            // 非常重要：清理 ThreadLocal，避免内存泄漏与线程复用污染
//            BaseContext.clear();
//        }
//
//        if (request.getSession().getAttribute("user") != null) {
//            Long userId = (Long) request.getSession().getAttribute("user");
//            BaseContext.setCurrentId(userId);
//            chain.doFilter(request, response);
//            return;
//        }
    }

    private boolean check(String[] urls, String requestURL){
        for (String url : urls){
            if (PATH_MATCHER.match(url, requestURL)) {
                return true;
            }
        }
        return false;
    }
}
