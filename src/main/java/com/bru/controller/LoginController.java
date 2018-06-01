package com.bru.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bru.dao.LoginDao;
import com.bru.model.LoginBean;

@Controller
public class LoginController {

	@Autowired
	private LoginDao logindao;
	
	@RequestMapping("/")
	public String login(Model model){
		model.addAttribute("messessError", "");
		return "hello";
	}
	@RequestMapping("/hello")
	public String authenLogin(String email, String password, Model model, HttpServletRequest request) {
		String authen = "";
		LoginBean bean = new LoginBean();
		List<LoginBean> findAll = new ArrayList<>();
		try {
			bean = logindao.login(email, password);
			
			if(bean.getEmail() !=null) {
				request.getSession().setAttribute("LoginUser", bean);
				request.getSession().setAttribute("listUser", findAll);
				authen = "world";
				
			} else {
				model.addAttribute("amnuay", "F");
				authen = "hello";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return authen;
	}
	@RequestMapping("/logout")
	private String logout(HttpServletRequest request, Model model) {
		request.getSession().removeAttribute("LoginUser");
		request.getSession().removeAttribute("listUser");
		model.addAttribute("amnuay", "L");

		return "login";
	}
}
