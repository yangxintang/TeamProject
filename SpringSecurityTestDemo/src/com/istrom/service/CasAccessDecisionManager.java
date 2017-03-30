package com.istrom.service;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**  
 * AccessdecisionManager��Spring security���Ǻ���Ҫ�ġ�  
 *   
 * ����֤���ּ�������ˣ����е�Authenticationʵ����Ҫ������һ��GrantedAuthority���������С� ����Ǹ���������Ȩ�ޡ�  
 * GrantedAuthority����ͨ��AuthenticationManager ���浽  
 * Authentication�����Ȼ���AccessDecisionManager��������������Ȩ�жϡ�  
 *   
 * Spring Security�ṩ��һЩ�������������ƶ԰�ȫ����ķ���Ȩ�ޣ����緽�����û�web����  
 * һ���Ƿ�����ִ�е��õ�Ԥ���þ���������AccessDecisionManagerʵ�ֵġ� ��� AccessDecisionManager  
 * ��AbstractSecurityInterceptor���ã� �����������շ��ʿ��Ƶľ�����  
 * ���AccessDecisionManager�ӿڰ�������������  
 *   
 * void decide(Authentication authentication, Object secureObject,  
 * List<ConfigAttributeDefinition> config) throws AccessDeniedException; boolean  
 * supports(ConfigAttribute attribute); boolean supports(Class clazz);  
 *   
 * �ӵ�һ���������Կ�������AccessDecisionManagerʹ�÷�����������������Ϣ�����������֤����ʱ���о�����  
 * �ر��ǣ�����ʵ�İ�ȫ�����������õ�ʱ�򣬴��ݰ�ȫObject������Щ������ ���磬�����Ǽ��谲ȫ������һ��MethodInvocation��  
 * ������Ϊ�κ�Customer������ѯMethodInvocation��  
 * Ȼ����AccessDecisionManager��ʵ��һЩ����İ�ȫ�߼�����ȷ�������Ƿ��������Ǹ��ͻ��ϲ�����  
 * ������ʱ��ܾ���ʵ�ֽ��׳�һ��AccessDeniedException�쳣��  
 *   
 * ��� supports(ConfigAttribute) ������������ʱ��  
 * AbstractSecurityInterceptor���ã�������AccessDecisionManager  
 * �Ƿ����ִ�д���ConfigAttribute�� supports(Class)��������ȫ������ʵ�ֵ��ã�  
 * ������ȫ����������ʾ��AccessDecisionManager֧�ְ�ȫ��������͡�  
 */ 

public class CasAccessDecisionManager implements AccessDecisionManager {
	
	protected static Logger logger = Logger.getLogger("CasAccessDecisionManager");  

	/*@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {  
            return;  
        }  
        Collection<? extends GrantedAuthority> as= authentication.getAuthorities();
 
        Iterator<ConfigAttribute> ite = configAttributes.iterator();  
 
        while (ite.hasNext()) {  
 
            ConfigAttribute ca = ite.next();  
            String needRole = ((SecurityConfig) ca).getAttribute();  
            System.out.print("URL:"+object+"----needrole:"+needRole);  
            // ga Ϊ�û����������Ȩ�ޡ� needRole Ϊ������Ӧ����ԴӦ�þ��е�Ȩ�ޡ�  
            for (GrantedAuthority ga : as) {  
 
                if (needRole.trim().equals(ga.getAuthority().trim())) {  
 
                    return;  
                }  
 
            }  
 
        }  
 
        throw new AccessDeniedException("���ʾܾ�");  

	}*/
	
	@Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {

        if (configAttributes == null) {
            return;
        }

        Iterator<ConfigAttribute> ite = configAttributes.iterator();
        while (ite.hasNext()) {
            ConfigAttribute ca = ite.next();
            String needRole = ((SecurityConfig) ca).getAttribute();
            logger.info("URL:"+object+"----needrole:"+needRole);
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (needRole.equals(ga.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("��Ȩ�޷��ʣ�");
	}
	
	

	@Override
	public boolean supports(ConfigAttribute arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
