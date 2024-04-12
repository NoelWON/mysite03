package com.noel.mysite03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noel.mysite03.User.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping("/joinform")
	public String joinform() {
		return "user/joinform";
	}
	
	//ResponseBody 브라우져에 표시하는 것.
	@ResponseBody
	@RequestMapping("join")
	public String join(UserVo vo) {
	
		System.out.println(vo);
		return "UserController:join";
	}
	
	
	@RequestMapping("/Loginform")
	public String loginform() {
		return "user/loginform";
	}
	
	
}
