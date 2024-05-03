package com.noel.mysite03.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noel.mysite03.Repository.BoardRepository;
import com.noel.mysite03.User.BoardVo;
import com.noel.mysite03.User.UserVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;

	public List<BoardVo> getContentsList() {

		return boardRepository.findAll();
	}

	public boolean insert(BoardVo boardVo) {
		return boardRepository.insert(boardVo);
	}

	public BoardVo view(Long no) {
		BoardVo boardVo = boardRepository.findByNo(no);
		return boardVo;
	}

	public Boolean delete(Long no) {
		return boardRepository.delete(no);
		
	}

	public Boolean modify(BoardVo boardVo) {
		return boardRepository.modify(boardVo);
	}

}
