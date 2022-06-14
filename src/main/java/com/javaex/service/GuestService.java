package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestService {
	@Autowired
	private GuestbookDao guestbookDao;
	
	public int guestDelete(int no) {
		
		int count = guestbookDao.guestDelete(no);
		return count;
	}

	public List<GuestbookVo> getGuestList() {
		
		List<GuestbookVo> guestList = guestbookDao.getGuestList();
		return guestList;
	}
	
}
