package com.noel.mysite03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.noel.mysite03.Repository.UserRepository;
import com.noel.mysite03.User.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	// repository가 담겨져 있는 컨테이너에서 자동으로 묶어준다.
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}

	// ResponseBody 브라우져에 표시하는 것.
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo vo) {
		userRepository.insert(vo);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping(value="/joinsuccess", method=RequestMethod.GET)
	public String joinsuccess() {
		return "user/joinsuccess";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="email", required=true, defaultValue="")String email,
			@RequestParam(value="password", required=true, defaultValue="")String password,
			Model model) {
		UserVo authUser = userRepository.findByEmailAndPassword(email, password);
		if(authUser == null) {
			model.addAttribute("email",email);
			model.addAttribute("result","fail");
			
			return "user/login";
		}
		
		return "redirect:/";
	}
}
