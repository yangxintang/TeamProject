package com.istrom.controller;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.istrom.po.Result;
import com.istrom.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	protected static Logger logger = Logger.getLogger("UserController");  
	
	/** 
     * ��ת���û�����ҳ�� 
     *  
     * @return 
     */  
    @RequestMapping(value = "/user")
    public String getCommonPage() {  
        logger.debug("Received request to show user page");  
        return "protected/user";  
    }  
    
    /**
	 * ��ȡ�û���Ϣ
	 * 
	 * @author hongjiabin
	 * @data 2017��2��14�� ����6:47:56
	 */ 
	@RequestMapping(value = "/loadUser")
	@ResponseBody
	public Result loadUser(){
		Result result = new Result();
		result.setStatus(0);
		result.setData(userService.loadUserInfo());
		return result;
	}
	
}
