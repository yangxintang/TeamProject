package cn.forum.jee.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 判断用户登录超时拦截
 * @author Administrator
 *
 */
@Service
public class UserInterceptor extends HandlerInterceptorAdapter {
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		return true;
	}

	private void dispose(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equals("XMLHttpRequest")) {
			PrintWriter pw = response.getWriter();
			pw.println("{\"status\":1,\"info\":\"��¼���ӳ�ʱ\"}");
			pw.close();
		} else {
			response.sendRedirect(request.getContextPath() + "/index");
		}
	}
}
