package com.noel.mysite03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.noel.mysite03.Service.BoardService;
import com.noel.mysite03.User.GuestbookVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String home(Model model) {
		List<BoardVo> list = boardService.getContentsList();
		model.addAttribute("list",list);
		return "board/list";
	}
}
