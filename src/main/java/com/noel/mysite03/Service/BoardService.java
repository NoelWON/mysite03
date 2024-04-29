package com.noel.mysite03.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noel.mysite03.Repository.BoardRepository;
import com.noel.mysite03.User.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;

	public List<BoardVo> getContentsList() {

		return boardRepository.findAll();
	}
}
