package com.noel.mysite03.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.noel.mysite03.Repository.UserRepository;
import com.noel.mysite03.Service.BoardService;
import com.noel.mysite03.User.BoardVo;
import com.noel.mysite03.User.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String home(Model model) {
		
		List<BoardVo> list = boardService.getContentsList();
		System.out.println("게시판 가져오는 정보: "+list);
		model.addAttribute("Blist",list);
		return "board/list";
	}
	
	@RequestMapping(value="wirte", method=RequestMethod.GET)
	public String write(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		Long no = authUser.getNo();
		UserVo userVo = userRepository.findByNo(no);
		
		System.out.println("게시판글쓰기 유저 정보: "+ userVo);
		return "board/write";
	}
}
