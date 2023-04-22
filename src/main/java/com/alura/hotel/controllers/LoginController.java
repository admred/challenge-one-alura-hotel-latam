package com.alura.hotel.controllers;

import com.alura.hotel.dao.UserDao;
import com.alura.hotel.models.User;
import com.alura.hotel.utils.JPAUtils;

public class LoginController {
	private UserDao userDao;

	public LoginController() {
		userDao=new UserDao(JPAUtils.getEntityManager());
	}
	
	public boolean authenticate(String username,String password) {
		User user=userDao.getByName(username);
		
		if(user == null ) {
			return false;
		}
		return user.getPassword().equals(password);
	}
}
