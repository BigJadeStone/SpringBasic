package com.simple.basic.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.simple.command.ScoreVO;

@Mapper //마이바티스 매퍼를 지칭 - (스프링에서는 생략가능)
public interface TestMapper {
	
	public String getTime(); //1
	public ArrayList<ScoreVO> getScore();
	public ScoreVO getOne(int a);
	
	public int insertOne(String name); //단일값
	public int insertTwo(ScoreVO vo); //다중값
	public int insertThree(Map<String, String> map); //다중값
	
	public Map<String, Object> selectMap(int num); // Map<String, Object> 이거는 한 행만 가져오겠다는 뜻. 3번 키값 조회
	public ArrayList<Map<String, Object>> selectTwo(); //맵을 통한 다중행 조회
	
	public boolean updateOne(ScoreVO vo); //update(3번 업데이트)
	
	//마이바티스는 매개변수를 한개만 받아야함(문법적규칙임)
	public void insertFour(@Param("변수명1") String name, @Param("변수명2") int kor);
}
