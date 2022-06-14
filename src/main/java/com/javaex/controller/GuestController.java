package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestController {
	
	@Autowired
	public GuestService guestService;
	

	@RequestMapping(value="/delete/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@PathVariable("no") int no) {
		
		guestService.guestDelete(no);
		
		System.out.println("GuestController>delete()");
		return "redirect:/addList";
	}
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		
		System.out.println("GuestController>list");
		
		
		List<GuestbookVo> guestbookVo = guestService.getGuestList();
		model.addAttribute(guestbookVo);
		
		return "addList";
	}

}
