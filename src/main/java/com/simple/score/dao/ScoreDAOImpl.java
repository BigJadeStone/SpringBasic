package com.simple.score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("yyy")
public class ScoreDAOImpl implements ScoreDAO {

	@Autowired
	private DataSource dataSource; //connection 풀에 DataSource 객체 가져오기


	@Override
	public void regist(ScoreVO vo) {

		String sql = "insert into score(name, kor, eng) values(?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,  vo.getName()); //(1번째 물음표에, vo.getName()) 을 넣겠다. 
			pstmt.setString(2,  vo.getKor()); //(2번째 물음표에, vo.getKor()) 을 넣겠다. 
			pstmt.setString(3,  vo.getEng());

			pstmt.executeUpdate(); //insert, update, delete

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {

			}
		}

	}

	@Override
	public ArrayList<ScoreVO> getList() {

		ArrayList<ScoreVO> list = new ArrayList<>();

		String sql = "select * from score order by num desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			//ORM(object relation Mapping) 작업을 해준다.
			while(rs.next()) {

				ScoreVO vo = new ScoreVO();
				vo.setNum(rs.getInt("num")); //column명 , 자동형변환해서 가져와줌
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getString("kor"));
				vo.setEng(rs.getString("eng"));

				list.add(vo);
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {

			} 
		}

		return list;
	}

	@Override
	public void delete(int num) {

		//삭제기능 -
		//num는 key가 아니라 index가 넘어옵니다. (화면에서 key를 넘기도록 변경)
		//delete기능 구현.

		String sql = "Delete From score where num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num); // 위에 물음표에 num을 넣겠다는 의미

			pstmt.executeUpdate(); // insert, update, delete

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {

			}
		}
	}







	//	//데이터베이스
	//	ArrayList<ScoreVO> list = new ArrayList<>();
	//	
	//	@Override
	//	public void regist(ScoreVO vo) {
	//		
	//		//연결....
	//		//connect
	//		
	//
	//		//System.out.println("DAO영역:" + vo.toString());
	//		list.add(vo); // insert임
	//		System.out.println(list.toString());
	//	}
	//
	//	@Override
	//	public ArrayList<ScoreVO> getList() {
	//		
	//		//데이터조회...
	//		
	//		return list;
	//	}
	//
	//	@Override
	//	public void delete(int num) {
	//		//삭제작업..
	//		list.remove(num);
	//	}



}
