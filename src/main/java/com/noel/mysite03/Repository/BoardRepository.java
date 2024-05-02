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

	public boolean insert(BoardVo boardVo) {
		return 1 == sqlSession.insert("board.insert",boardVo);
	}

	public BoardVo findByNo(Long no) {
		return sqlSession.selectOne("board.findByNo", no);
	}

	public Boolean delete(Long no) {
		return 1 == sqlSession.delete("board.delete",no);
	}

	
	
	
	
}
