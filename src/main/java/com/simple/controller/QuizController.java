package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	//quiz01 ȭ�� ���̱�
	@RequestMapping("/quiz01")
	public void quiz01() {}
	
	@RequestMapping("/sendBirth") //����û
	public String sendBirth(Quiz01VO vo,
							Model model) {
		
		System.out.println( ("" + vo.getMonth()) + vo.getMonth()+ vo.getDay());

		model.addAttribute("birth", vo.getYear() + "��" +
									vo.getMonth() + "��" +
									vo.getDay() + "��");
		model.addAttribute("year",vo.getYear());
		model.addAttribute("month",vo.getMonth());
		model.addAttribute("day",vo.getDay());
		
		return "/quiz/quiz01_ok";
	}

	//quiz02 ȭ�� ���̱�
	@RequestMapping("/quiz02")
	public void quiz02() {}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute("id") String id,
					   @ModelAttribute("pw") String pw,
					   @ModelAttribute("name") String name,
					   @ModelAttribute("email") String email) {
		
		return "quiz/quiz02_ok";
	}
	
	//quiz03 ȭ�� ���̱�
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "/quiz/quiz03";
	}
	
	@RequestMapping("/join2")
	public String join2(@ModelAttribute("id") String id,
						@ModelAttribute("pw") String pw,
						@ModelAttribute("pw_check") String pwCheck,
						Model model,
						RedirectAttributes ra) {
		
		if(id.equals("")) {
			ra.addFlashAttribute("msg","���̵� �Է��ϼ���");
			return "redirect:/quiz/quiz03";
		} else if(!pw.equals(pwCheck)) {
			ra.addFlashAttribute("msg", "��ι�ȣ�� Ȯ���ϼ���");
			return "redirect:/quiz/quiz03";
		} else {
			model.addAttribute("id", id);
			return "/quiz/quiz03_ok";
		}
		
	}
	
	
	
	
}
