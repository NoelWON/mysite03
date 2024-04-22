package com.noel.mysite03.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public boolean insert(GuestbookVo guestbookVo) {
		return 1 == sqlSession.insert("guestbook.insert",guestbookVo);
	}

	public Boolean remove(Long no, String password) {
		Map<String,Object> map = new HashMap<>();
		map.put("no",no);
		map.put("password",password);
		return 1 == sqlSession.delete("guestbook.remove", map);
	}
}
