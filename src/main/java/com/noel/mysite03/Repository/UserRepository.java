package com.noel.mysite03.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noel.mysite03.User.UserVo;

@Repository
public class UserRepository {
	
	// mybatis
	@Autowired
	private SqlSession sqlSession;
	
	
	// getconnection을 사용하기 위함 
	// conn = dataSource.getConnection();
	// sqlSession 을 사용하면서 내부에서 처리함
//	@Autowired
//	private DataSource dataSource;
	// mybatis
	
	
	public Boolean insert(UserVo vo) {
		
		return 1 == sqlSession.insert("user.insert",vo);
	

//		Boolean result = false;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//  			Class.forName("org.mariadb.jdbc.Driver");
//  			String url = "jdbc:mariadb://192.168.100.8:3307/webdb?chatset=utf8";
//  			conn = DriverManager.getConnection(url,"webdb","webdb");
//			
//			// MyBatis 부분이 이렇게 바뀐다.
//			conn = dataSource.getConnection();
//			
//			System.out.println("connection success!");
//			String sql = "insert into user values(null,?,?,password(?),?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getName());
//			pstmt.setString(2, vo.getEmail());
//			pstmt.setString(3, vo.getPassword());
//			pstmt.setString(4, vo.getGender());
//			int count = pstmt.executeUpdate();
//			result = count == 1;
//
//		}
//  		catch (ClassNotFoundException e) {
//  			System.out.println("shit Driver loading fail:   " + e);
//  		}
//		catch (SQLException e) {
//			System.out.println("Error:   " + e);
//		}
//		finally {
//			try {
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}	
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
	}
	
	public UserVo findByEmailAndPassword(String email, String password) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("email",email);
		map.put("password",password);
//		UserVo vo = sqlSession.selectOne("user.findByEmailAndPassword",map);
//		System.out.println("ddd ; "+vo);
//		return null;
		
		return sqlSession.selectOne("user.findByEmailAndPassword",map);
		
//		UserVo result = null;
//		ResultSet rs = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
		
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://192.168.100.8:3307/webdb?chatset=utf8";
//			conn = DriverManager.getConnection(url,"webdb","webdb");
//			conn = dataSource.getConnection();
//			System.out.println("connection success!");
//			
//			
//			String sql = "select no, name from user where email =? and password = password(?)";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, email);
//			pstmt.setString(2, password);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				Long no = rs.getLong(1);
//				String name = rs.getString(2);
//				
//				result = new UserVo();
//				result.setNo(no);
//				result.setName(name);
//			}
//		
//		}
//		catch (ClassNotFoundException e) {
//			System.out.println("shit Driver loading fail:   " + e);
//		}
//		catch (SQLException e) {
//			System.out.println("Error:   " + e);
//		}finally {
//			try {
//				if(rs != null) {
//					rs.close();
//				}
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}	
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
		
//		return result;
	}


	public UserVo findByNo(Long no) {
		
		// no로 유저의 정보를 가져와야함
		Long num = no;
		System.out.println("findByNo 진입");
		return sqlSession.selectOne("user.findByNo",num);
		
//		
//		UserVo result = null;
//		ResultSet rs = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://192.168.100.8:3307/webdb?chatset=utf8";
//			conn = DriverManager.getConnection(url,"webdb","webdb");
//			System.out.println("connection success!");
//			String sql = "select no,name,email,password,gender from user where no=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setLong(1, no);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {				
//				no = rs.getLong(1);
//				String name = rs.getString(2);
//				String email = rs.getString(3);
//				String password = rs.getString(4);
//				String gender = rs.getString(5);
//				result = new UserVo();
//				result.setName(name);
//				result.setEmail(email);
//				result.setPassword(password);
//				result.setGender(gender);
//			}
//		} catch (ClassNotFoundException e) {
//			System.out.println("shit Driver loading fail:   " + e);
//		} catch (SQLException e) {
//			System.out.println("Error:   " + e);
//		}finally {
//			try {
//				if(rs != null) {
//					rs.close();
//				}
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}	
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
	}

	public Boolean update(UserVo vo) {
		System.out.println("repository 진입");
		System.out.println("repository: "+vo);
		return 1 == sqlSession.update("user.update",vo);
		
		
		
//		Boolean result = false;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://192.168.100.8:3307/webdb?chatset=utf8";
//			conn = DriverManager.getConnection(url,"webdb","webdb");
//			System.out.println("connection success!");
//			
//			if(vo.getPassword()==null || vo.getPassword()=="") {
//				String sql = "update user Set name = ?, gender = ? where no = ?";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, vo.getName());
//				pstmt.setString(2, vo.getGender());
//				pstmt.setLong(3, vo.getNo());
//				
//				int count = pstmt.executeUpdate();
//				result = count == 1;
//			}else {
//				String sql = "update user Set name = ?, password = password(?), gender = ? where no = ?";
//				
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, vo.getName());
//				pstmt.setString(2, vo.getPassword());
//				pstmt.setString(3, vo.getGender());
//				pstmt.setLong(4, vo.getNo());
//				
//				int count = pstmt.executeUpdate();
//				result = count == 1;
//			}
//		}catch (ClassNotFoundException e) {
//			System.out.println("shit Driver loading fail:   " + e);
//		} catch (SQLException e) {
//			System.out.println("Error:   " + e);
//		}		finally {
//			try {
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}	
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
	}
}
