package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.service.LoginService;

@Controller
public class MyLoginController {
	@Autowired
	LoginService loginservice;
	
	@PostMapping("/validate")
	public ModelAndView validate(@RequestParam("uname") String unm,@RequestParam String passwd,HttpSession sess) {
		MyUser u=loginservice.validateUser(unm,passwd);
		if(u!=null) {
			sess.setAttribute("user", u);
			return new ModelAndView("redirect:/product/getproducts");
			
		}
		return new ModelAndView("success","msg","unsuccessful login");
	}

}
