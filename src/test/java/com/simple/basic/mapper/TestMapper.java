package com.simple.basic.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.simple.command.ScoreVO;

@Mapper //���̹�Ƽ�� ���۸� ��Ī - (������������ ��������)
public interface TestMapper {
	
	public String getTime(); //1
	public ArrayList<ScoreVO> getScore();
	public ScoreVO getOne(int a);
	
	public int insertOne(String name); //���ϰ�
	public int insertTwo(ScoreVO vo); //���߰�
	public int insertThree(Map<String, String> map); //���߰�
	
	public Map<String, Object> selectMap(int num); // Map<String, Object> �̰Ŵ� �� �ุ �������ڴٴ� ��. 3�� Ű�� ��ȸ
	public ArrayList<Map<String, Object>> selectTwo(); //���� ���� ������ ��ȸ
	
	public boolean updateOne(ScoreVO vo); //update(3�� ������Ʈ)
	
	//���̹�Ƽ���� �Ű������� �Ѱ��� �޾ƾ���(��������Ģ��)
	public void insertFour(@Param("������1") String name, @Param("������2") int kor);
}
