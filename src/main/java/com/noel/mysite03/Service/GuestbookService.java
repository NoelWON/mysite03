package com.noel.mysite03.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noel.mysite03.Repository.GuestbookRepository;
import com.noel.mysite03.User.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookRepository guestbookRepository;

	public List<GuestbookVo> getContentsList() {
		
		return guestbookRepository.findAll();
	}
}
