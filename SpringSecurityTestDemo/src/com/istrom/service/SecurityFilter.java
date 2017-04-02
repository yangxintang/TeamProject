package com.istrom.service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;


public class SecurityFilter extends AbstractSecurityInterceptor implements Filter {
	
	private Logger log = Logger.getLogger(SecurityFilter.class);

	// ��applicationContext-security.xml���myFilter������securityMetadataSource��Ӧ��
	// ����������������Ѿ���AbstractSecurityInterceptor����
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	/** 
	* ��Ҫ�ų���ҳ�� 
	*/  
	private String excludedPages;  
	  
	private String[] excludedPageArray; 
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("*********************************************");
		log.info("              SecurityFilter");
		log.info("*********************************************");
		
		Properties prop = new Properties(); 
		
		String context = ((HttpServletRequest)request).getServletContext().getRealPath("/");
		
		//��ȡ�����ļ�a.properties
		InputStream in = new BufferedInputStream(new FileInputStream(context+"/WEB-INF/classes/resource.properties"));
		prop.load(in);     ///���������б�
		excludedPages = prop.getProperty("resouce");  
		/*Iterator<String> it=prop.stringPropertyNames().iterator();
		while(it.hasNext()){
			String key=it.next();
			excludedPages = prop.getProperty(key);
		}*/
		in.close();
		
		excludedPageArray = excludedPages.split(",");  
		
		boolean isExcludedPage = false;  
		for (String page : excludedPageArray) {
			//�ж��Ƿ��ڹ���url֮��  
			if(((HttpServletRequest) request).getServletPath().contains(page)){  
				isExcludedPage = true;  
				break;  
			}  
		}  
		
		if (isExcludedPage) {
			//�ڹ���url֮��  
			chain.doFilter(request, response);  
		} else {
			//���ڹ���url֮��
			FilterInvocation fi = new FilterInvocation(request, response, chain);
			invoke(fi);		
		}
	}

	private void invoke(FilterInvocation fi) throws IOException, ServletException {
		// objectΪFilterInvocation����
		// super.beforeInvocation(fi);Դ��
		// 1.��ȡ������Դ��Ȩ��
		// ִ��Collection<ConfigAttribute> attributes =
		// SecurityMetadataSource.getAttributes(object);
		// 2.�Ƿ�ӵ��Ȩ��
		// this.accessDecisionManager.decide(authenticated, object, attributes);
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}
	
	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(
			FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		return;  
	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}

}
