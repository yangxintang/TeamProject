package com.istrom.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.istrom.dao.db.ResourceDb;
import com.istrom.dao.db.RoleDb;
import com.istrom.po.DbUser;


public class CasMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	private Logger log = Logger.getLogger(CasMetadataSource.class);
	
	@Autowired
	private RoleDb roleDb;
	
	@Autowired
	private ResourceDb resourceDb;
	
	private static DbUser dbUser;
	
	private static int i = 1;
	
	private static Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
    
	/**
     * ��ʼ����Դ����
     * <p>
     * spring ���ø÷����ķ�ʽ��2��
     * ��ʽ1�������ϼ�ע�⣺ @PostConstruct
     * ��ʽ2�������ļ��� init-method ����ָ����
     * <beans:bean id="webSecurityMetadataSource" init-method="initResource"
     * class="com.spring.security.security.security.WebSecurityMetadataSource"/>
     */
    public void initResource() {
    	resourceMap.clear();
    	log.info("********************************************");
    	log.info("        initResource()���д�����"+i);
    	log.info("********************************************");
    	setResourceMap(loadResourceDefine());
    	i++;
    }

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		log.info("********************************************");
		log.info("             getAttributes()");
		log.info("********************************************");
		
		if ((object == null) || !this.supports(object.getClass())) {
			// logger.info("Object must be a FilterInvocation");
			throw new IllegalArgumentException(
					"Object must be a FilterInvocation");
		}
		
		Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
		
		HttpServletRequest request = ((FilterInvocation) object).getRequest();
		
		if (object instanceof FilterInvocation) {
			for (String resourceURL : resourceMap.keySet()) {
	            //AntPathRequestMatcher : ������Ant��Ŀ����һ�ּ��׶���·��ƥ����ԡ�
	            //RegexRequestMatcher : ��� AntPathRequestMatcher �޷���������
	            //������ѡ��ʹ�ø�ǿ���RegexRequestMatcher����֧��ʹ��������ʽ��URL��ַ����ƥ��
				//  RequestMatcher requestMatcher = new AntPathRequestMatcher(resourceURL);
				resourceURL = resourceURL.replace("*", "");
	            RequestMatcher requestMatcher = new RegexRequestMatcher(resourceURL, request.getMethod(), true);
	            if (requestMatcher.matches(request)) {	
	            	configAttributes.addAll(resourceMap.get(resourceURL));
	            }
			}
			
			if (configAttributes.isEmpty()) {
				configAttributes.add(new SecurityConfig("nobody"));
			}
			for (ConfigAttribute configAttribute : configAttributes) {
				log.info("����urlƥ���ɫ��" + configAttribute.toString());
			}
			return configAttributes;
		}
		
		/*if (object instanceof FilterInvocation) {
			
			FilterInvocation filterInvocation = (FilterInvocation) object;
			
			resourceMap = getResourceMap();
			
			// �Ƚ�����url����Դ��url��ƥ�������Ӧ�Ľ�ɫȨ��
			if (resourceMap != null && !resourceMap.isEmpty()) {
				Iterator<String> iterator = resourceMap.keySet().iterator();
				while (iterator.hasNext()) {
					String requestURL = iterator.next();
		            RequestMatcher requestMatcher = new AntPathRequestMatcher(requestURL);
		            if(requestMatcher.matches(filterInvocation.getHttpRequest())) {
		            	configAttributes.addAll(resourceMap.get(requestURL));
		            }
				}
				if (configAttributes.isEmpty()) {
					configAttributes.add(new SecurityConfig("nobody"));
				}
				for (ConfigAttribute configAttribute : configAttributes) {
					log.info("����urlƥ���ɫ��" + configAttribute.toString());
				}
				return configAttributes;
			}
			
		}*/
 
        return null;  
        
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public Map<String, Collection<ConfigAttribute>>  loadResourceDefine(){
		
		List<String> auNames = roleDb.get();
				
		/*  
         * Ӧ������ԴΪkey�� Ȩ��Ϊvalue�� ��Դͨ��Ϊurl�� Ȩ�޾�����Щ��ROLE_Ϊǰ׺�Ľ�ɫ�� һ����Դ�����ɶ��Ȩ�������ʡ�  
         */ 
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();  
        
        for (String auth : auNames) {  
            ConfigAttribute ca = new SecurityConfig(auth);  
 
            List<String> query1 = resourceDb.getResUrl(auth);
 
            for (String res : query1) {  
                String url = res;  
                
                /*  
                 * �ж���Դ�ļ���Ȩ�޵Ķ�Ӧ��ϵ������Ѿ�������ص���Դurl����Ҫͨ����urlΪkey��ȡ��Ȩ�޼��ϣ���Ȩ�����ӵ�Ȩ�޼����С�  
                 * sparta  
                 */ 
                if (resourceMap.containsKey(url)) {  
 
                    Collection<ConfigAttribute> value = resourceMap.get(url);  
                    value.add(ca);  
                    resourceMap.put(url, value);  
                } else {  
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();  
                    atts.add(ca);  
                    resourceMap.put(url, atts);  
                }  
          
 
            }  
 
        }  
        
        return resourceMap;
	}
	
	public static Map<String, Collection<ConfigAttribute>> getResourceMap() {
        return resourceMap;
    }

    public static void setResourceMap(Map<String, Collection<ConfigAttribute>> resourceMap) {
    	CasMetadataSource.resourceMap = resourceMap;
    }
    
    public static DbUser getDbUser(){
    	return dbUser;
    }
    
    public static void setDbUser(DbUser dbUser){
    	CasMetadataSource.dbUser = dbUser;
    }

}
