package com.noel.mysite03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noel.mysite03.Repository.UserRepository;
import com.noel.mysite03.User.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	// repository가 담겨져 있는 컨테이너에서 자동으로 묶어준다.
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/joinform")
	public String joinform() {
		return "user/joinform";
	}

	// ResponseBody 브라우져에 표시하는 것.
	@RequestMapping("join")
	public String join(UserVo vo) {

		userRepository.insert(vo);

		return "redirect:/user/joinsuccess";
	}

	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
	}

	@RequestMapping("/Loginform")
	public String loginform() {
		return "user/loginform";
	}

}
