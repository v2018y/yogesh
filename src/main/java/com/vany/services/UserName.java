package com.vany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.vany.model.DAOUser;
import com.vany.repositeroy.UserDao;

@Service
public class UserName {

	@Autowired
	UserDao userDao;

	// This Functiosn get Username form Token And Return the User Details
	public DAOUser getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		System.out.println("Your User Name :" + username);

		DAOUser daoUser = userDao.findByUsername(username);
		return daoUser;
	}
	
	
}
