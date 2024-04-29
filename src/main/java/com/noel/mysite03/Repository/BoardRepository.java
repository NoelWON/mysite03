package com.noel.mysite03.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noel.mysite03.User.BoardVo;
import com.noel.mysite03.User.UserVo;

@Repository
public class BoardRepository {
	@Autowired
	private SqlSession sqlSession;

	public List<BoardVo> findAll() {
		
		return sqlSession.selectList("board.findAll");
	}

	
	
	
	
}
