package com.lee.cms.intercept;

import com.lee.cms.entity.Auth;
import com.lee.cms.entity.User;
import com.lee.cms.utils.StrUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 拦截器
 * 权限验证
 */
public class SecurityInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(StrUtil.USER);
        if (user == null) {
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        } else {
        	String url = request.getRequestURI();
        	List<Auth> list = user.getUrlList();
        	for (Auth auth: list) {
        		if (url.indexOf(auth.getUrl()) >= 0) return true;
        	}
        	response.sendRedirect(request.getContextPath()+"/404");
        }
        return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
