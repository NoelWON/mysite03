package com.noel.mysite03.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
//		System.out.println("게시판 가져오는 정보: "+list);
		model.addAttribute("Blist",list);
		return "board/list";
	}
	
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write() {
		System.out.println("글쓰기 진입");
		return "board/write";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(HttpServletRequest request,
			BoardVo boardVo) {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		System.out.println("로그인된 유저:"+authUser);
		
		boardVo.setUserNo(authUser.getNo());
		boardVo.setUserName(authUser.getName());
		
		System.out.println(boardVo);
		// 유저 no, 제목, 내용이 들어가야함
		boardService.insert(boardVo);
		
		return "redirect:/board";
	}
	
	@RequestMapping(value="view/{no}", method=RequestMethod.GET)
	public String view(@PathVariable("no") Long no, Model model) {
		
		BoardVo boardVo = boardService.view(no);
		model.addAttribute("boardVo",boardVo);
		System.out.println(boardVo);
		return "board/view";
	}
	
	@RequestMapping(value="delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable("no") Long no) {
		System.out.println("delete 진입");
		boardService.delete(no);
		System.out.println("delete 성공");
		return "redirect:/board";
	}
	
	@RequestMapping(value="modify/{no}", method=RequestMethod.GET)
	public String modify(@PathVariable("no") Long no) {
		return "board/modify";
	}
}
