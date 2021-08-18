package com.javaex.dao;

import java.util.List;

public interface guestbookDao {

	public List<GuestbookVo> getList();
	
	public int insert(GuestbookVo vo);
	
	public int delete(GuestbookVo vo);

}
