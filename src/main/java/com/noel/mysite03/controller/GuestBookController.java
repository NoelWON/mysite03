package com.noel.mysite03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.noel.mysite03.Service.GuestbookService;
import com.noel.mysite03.User.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(Model model) {
		List<GuestbookVo> list = guestbookService.getContentsList();
		
		System.out.println(list);
		model.addAttribute("list",list);
		return "guestbook/guestmain";
	}
	@RequestMapping(value="", method=RequestMethod.POST)
	public String write(GuestbookVo guestbookVo) {
				
		System.out.println("방명록 추가 내용: "+guestbookVo);
		guestbookService.write(guestbookVo);
		return "redirect:/guestbook";
	}
	
	@RequestMapping(value="remove/{no}", method=RequestMethod.GET)
	public String remove(@PathVariable("no") Long no, Model model) {
		// hidden 에 no을 넣고 다음 확인을 넣었을때 파라미터로 쓰기 위함
		model.addAttribute("no",no);
		return "guestbook/deleteform";
	}
	
	@RequestMapping(value="remove/{no}", method=RequestMethod.POST)
	public String remove(@RequestParam(value="password", required=true, defaultValue="") String password,
			@PathVariable("no") Long no) {
		guestbookService.remove(no,password);
		return "redirect:/guestbook";
	}
	
	
	
	
}
