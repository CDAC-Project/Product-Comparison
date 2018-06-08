package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.dao.UserDao;

import pojos.User;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDao dao;
	
	public UserController() {
		System.out.println("user controller cnstr");
	}
	
	
	@GetMapping("/login")
	public String showLoginForm()
	{
		System.out.println("in show login form ");
		return "/user/login";
	}
	@PostMapping("/login")
	public String processLoginForm(Model map,@RequestParam String user_id,
			@RequestParam String password,HttpSession hs)
	{
		System.out.println("in show process form ");
		User u=null;
		try {
			u=dao.validateUser(user_id, password);
		} catch (RuntimeException e) {
			System.out.println("error" + e);
			//map.addAttribute("type",service.getAccountType());
			map.addAttribute("mesg", "Invalid Login , pls retry");
			return "/user/login";
		}
		hs.setAttribute("mesg","Successful Login...Hello User");
		hs.setAttribute("user_dtls", u);
		return "/user/initiate";
	}

}
