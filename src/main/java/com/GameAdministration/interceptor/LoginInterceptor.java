package com.GameAdministration.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.GameAdministration.baseinfo.UserInfo;

/**
 * 
 * @author YP
 * @Description: 登录拦截器
 * @param:
 * @date:     2021年2月20日下午1:43:45
 * 
 */

@Order(500)
@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		String contextPath = session.getServletContext().getContextPath();
		String[] requireAuthPages = new String[]{"index",};
		
		//拦截所有路径
		String uri = StringUtils.remove(request.getRequestURI(), contextPath+"/");
		String page = uri;
		
		if(begingWith(page, requireAuthPages)){
			//判断session中是否存在user属性，存在放行，不存在跳转到登录
			UserInfo user = (UserInfo) session.getAttribute("user");
            if(user==null) {
            	response.sendRedirect("login");
                return false;
            }
        }
        return true;
	}
	
    private boolean begingWith(String page, String[] requiredAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requiredAuthPages) {
            if(StringUtils.startsWith(page, requiredAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
