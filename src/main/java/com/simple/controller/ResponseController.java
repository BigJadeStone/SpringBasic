package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
	//1.ȭ��
	@RequestMapping("/ex01")//�Է°��
	public String ex01() {
		return "response/ex01"; //��°��
	}
	
	//result01��û - model��ü
	@RequestMapping("/result01")
	public String result01(Model model) {
		
		model.addAttribute("data", "ȫ�浿"); //Ű, ��
		model.addAttribute("serverTime", new Date());
		
		return "response/result01";
	}
	
	//result02��û - ModelAndView��ü
	@RequestMapping("/result02")
	public ModelAndView result02() {
		
		//���� ����, data������ �Բ� ������ �� �ִ� ��ü
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", "ȫ�浿");
		mv.addObject("name", "�̼���");
		mv.setViewName("response/result02");
		
		return mv;
	}
	
	
	//@ModelAttribute = request + model
	@RequestMapping("/result03")
	public String result03(@ModelAttribute("num") String aaa) {
		
		System.out.println("ȭ�鵥����:" + aaa);
		
		return "response/result03";
	}
	
	@RequestMapping("/result04")
	public String result04(@ModelAttribute("article") ReqVO vo) {
		//��û���� �޾ƿ� ���� article �̶�� �̸����� �޾Ƽ� �ٽ� �������شٴ� �ǹ�.
		
		System.out.println("ȭ�鵥����:" + vo.toString());
		
		return "response/result04";
	}
	
	//--------------------------------------------------------------
	//redirect �̵��� redirectAttribute
	//���������� redirect�� �ٽ� ��Ʈ�ѷ��� �¿�� ��û�Դϴ�.
	//redirectAttribute�� redirect�ÿ� 1ȸ�� �����͸� ������ �� �ֽ��ϴ�.
	
	//ȭ���û
	@RequestMapping("/redirect_login")
	public String loginView() {
		
		return "response/redirect_login";
		
	}
	
	//�α��ο�û
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						RedirectAttributes ra) {
		//�α��� ���� -> homeȭ������
		if(id.equals(pw)) {
			
			ra.addFlashAttribute("msg","���"); // 1ȸ�� ������
			
			return "redirect:/"; //�ٽ� home ��Ʈ�ѷ��� �¿� ���� - model�� ����� �� ����
			
		//�α��� ����
		} else {
			ra.addFlashAttribute("msg", "Ʋ�ȴµ���?��");
			return "redirect:/response/redirect_login"; //"redirect:/������"
			
		}
		
	}
	
	
	
}
