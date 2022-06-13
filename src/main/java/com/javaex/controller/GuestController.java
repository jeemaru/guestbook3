package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestController {

	@RequestMapping(value="/delete/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@PathVariable("no") int no) {
		
		GuestbookDao guestbookDao = new GuestbookDao();
		guestbookDao.guestDelete(no);
		
		System.out.println("GuestController>delete()");
		return "redirect:/addList";
	}
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		
		System.out.println("GuestController>list");
		
		GuestbookDao guestbookDao = new GuestbookDao();
		
		List<GuestbookVo> guestbookVo = guestbookDao.getGuestList();
		model.addAttribute(guestbookVo);
		
		return "/WEB-INF/views/addList.jsp";
	}

}
