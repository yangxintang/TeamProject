package org.springframework.security.core.userdetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.istrom.dao.ResourceDao;
import com.istrom.dao.RoleDao;

public class CasMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	private Logger log = Logger.getLogger(CasMetadataSource.class);
	
	@Resource
	private RoleDao roleDao;
	
	@Resource 
	private ResourceDao resourceDao;
	
    private Map<String, Collection<ConfigAttribute>> resourceMap ; 

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		if ((object == null) || !this.supports(object.getClass())) {
			// logger.info("Object must be a FilterInvocation");
			throw new IllegalArgumentException(
					"Object must be a FilterInvocation");
		}
		
		Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
		if (object instanceof FilterInvocation) {
			FilterInvocation filterInvocation = (FilterInvocation) object;
			resourceMap = loadResourceDefine();
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
					log.debug("����urlƥ���ɫ��" + configAttribute.toString());
				}
				return configAttributes;
			}
		}
 
        return null;  
        
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Map<String, Collection<ConfigAttribute>>  loadResourceDefine(){
		
		List<String> auNames = roleDao.getRoleName();
		
		/*  
         * Ӧ������ԴΪkey�� Ȩ��Ϊvalue�� ��Դͨ��Ϊurl�� Ȩ�޾�����Щ��ROLE_Ϊǰ׺�Ľ�ɫ�� һ����Դ�����ɶ��Ȩ�������ʡ�  
         */ 
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();  
        
        for (String auth : auNames) {  
            ConfigAttribute ca = new SecurityConfig(auth);  
 
            List<String> query1 = resourceDao.getResUrl(auth);
 
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

}
