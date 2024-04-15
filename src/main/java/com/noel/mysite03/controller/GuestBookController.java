package com.noel.mysite03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noel.mysite03.Service.GuestbookService;
import com.noel.mysite03.User.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookService.getContentsList();
		
		System.out.println(list);
		model.addAttribute("list",list);
		return "guestbook/index";
		
	}
}
