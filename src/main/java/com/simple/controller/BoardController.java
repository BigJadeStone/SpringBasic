package com.simple.controller;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.board.service.BoardService;
import com.simple.command.BoardVO;

@Controller
@RequestMapping("/service")
public class BoardController {
	
	@Autowired
	@Qualifier("boardService")
	private BoardService service;
	
	//등록화면 출력
	@RequestMapping("/boardRegister")
	public void registView(){}
	
	//글 등록
	@RequestMapping(value="/contentRegist", method=RequestMethod.POST)
	public String regist(BoardVO vo) {
		
		service.regist(vo);
		
		return "service/boardResult";
	}
	
//	//글 등록 결과 화면
//	@RequestMapping("/boardResult")
//	public String resultView() {
//		return "service/boardResult";
//	}
	
	
	//목록화면
	@RequestMapping("/boardList")
	public String listView(Model model) {
		
		ArrayList<BoardVO> list = service.getList();
		model.addAttribute("list", list);
		
		return "service/boardList";
	}
	
	//삭제기능
	@RequestMapping("/boardDelete")
	public String delete(@RequestParam("num") int num) {
		
		service.delete(num);
		
		return "redirect:/service/boardList";
		
		
	}
	

}
