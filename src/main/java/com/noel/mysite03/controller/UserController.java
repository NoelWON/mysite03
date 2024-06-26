package com.noel.mysite03.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		System.out.println("로그인창 진입");
		return "user/login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="email", required=true, defaultValue="")String email,
			@RequestParam(value="password", required=true, defaultValue="")String password,
			Model model,
			HttpServletRequest request
			) {
		UserVo authUser = userRepository.findByEmailAndPassword(email, password);
		
		if(authUser == null) {
			model.addAttribute("email",email);
			model.addAttribute("result","fail");
			return "user/login";
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		// authUser 확인
		System.out.println("로그인된 유저"+authUser);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	
	// 업데이트 진행완료
	@RequestMapping(value="/updateform", method=RequestMethod.GET)
	public String update(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		Long no = authUser.getNo();

		UserVo userVo = userRepository.findByNo(no);
		
		// 로그인된 유저 정보 no, 이름 확인
		System.out.println("업데이트창: " + userVo);
		
		request.setAttribute("userVo", userVo);
		
		return "user/updateform";
	}
	
	// 하나로 합치기
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestParam(value="name", required=true, defaultValue="")String name,
			@RequestParam(value="password", required=true, defaultValue="")String password,
			@RequestParam(value="gender", required=true, defaultValue="")String gender,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		Long no = authUser.getNo();
		
		System.out.println("로그인 유저현재 정보: "+authUser);
		
		String edname = name;
		String edpassword = password;
		String edgender = gender;
				
		UserVo edvo = new UserVo();
		edvo.setNo(no);
		edvo.setName(edname);
		edvo.setPassword(edpassword);
		edvo.setGender(edgender);
		
		System.out.println("수정한 정보: "+edvo);
		// repository로 넘기기
		userRepository.update(edvo);
		
		return "user/updatesuccess";
	}
}
