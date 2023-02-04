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
	private DataSource dataSource; //connection Ǯ�� DataSource ��ü ��������


	@Override
	public void regist(ScoreVO vo) {

		String sql = "insert into score(name, kor, eng) values(?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,  vo.getName()); //(1��° ����ǥ��, vo.getName()) �� �ְڴ�. 
			pstmt.setString(2,  vo.getKor()); //(2��° ����ǥ��, vo.getKor()) �� �ְڴ�. 
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
			//ORM(object relation Mapping) �۾��� ���ش�.
			while(rs.next()) {

				ScoreVO vo = new ScoreVO();
				vo.setNum(rs.getInt("num")); //column�� , �ڵ�����ȯ�ؼ� ��������
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

		//������� -
		//num�� key�� �ƴ϶� index�� �Ѿ�ɴϴ�. (ȭ�鿡�� key�� �ѱ⵵�� ����)
		//delete��� ����.

		String sql = "Delete From score where num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num); // ���� ����ǥ�� num�� �ְڴٴ� �ǹ�

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







	//	//�����ͺ��̽�
	//	ArrayList<ScoreVO> list = new ArrayList<>();
	//	
	//	@Override
	//	public void regist(ScoreVO vo) {
	//		
	//		//����....
	//		//connect
	//		
	//
	//		//System.out.println("DAO����:" + vo.toString());
	//		list.add(vo); // insert��
	//		System.out.println(list.toString());
	//	}
	//
	//	@Override
	//	public ArrayList<ScoreVO> getList() {
	//		
	//		//��������ȸ...
	//		
	//		return list;
	//	}
	//
	//	@Override
	//	public void delete(int num) {
	//		//�����۾�..
	//		list.remove(num);
	//	}



}
