package org.koushik.javabrains.service;

import java.util.HashMap;
import java.util.Map;

import org.koushik.javabrains.dto.User;

public class LoginService {
	
	Map<String,String> userMap = new HashMap<String,String>();
	
	
	public LoginService() {
		userMap.put("kmrvikash", "Vikash Kumar");
		userMap.put("krirohini", "Rohini Kumari");
		userMap.put("krivardhini", "Vardhini Kashyap");
	}
	
	public User getUserDetails( String userId) {
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userMap.get(userId));
		return user;
	}

	
	public boolean authenticate (String userId, String password) {
		
		if( null == password ||  password.trim() == "") {
			return false;
		}
	
		return true;
	}
}
