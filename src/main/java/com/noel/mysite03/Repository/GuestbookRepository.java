package com.noel.mysite03.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noel.mysite03.User.GuestbookVo;

@Repository
public class GuestbookRepository {

	@Autowired
	private SqlSession sqlSession;

	public List<GuestbookVo> findAll() {

		return sqlSession.selectList("guestbook.findAll");
	}
}
