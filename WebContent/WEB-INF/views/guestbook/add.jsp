<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ page import="com.javaex.dao.guestbookDao"%>
<%@ page import="com.javaex.dao.GuestbookVo"%>
<%@ page import="com.javaex.dao.GuestbookDaoImpl"%>

<%
	request.setCharacterEncoding("UTF-8");
	String name 	= request.getParameter("name");
	String password = request.getParameter("password");
	String content 	= request.getParameter("content");
	
  	GuestbookVo vo = new GuestbookVo(name, password, content);
	guestbookDao dao = new GuestbookDaoImpl();
	int count = dao.insert(vo);
	
  if(count >= 1){
    response.sendRedirect("list.jsp");
  }
	
%>
