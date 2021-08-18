package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbookDaoImpl;
import com.javaex.dao.GuestbookVo;

import com.javaex.dao.guestbookDao;

@WebServlet(description = "방명록 서블릿", urlPatterns = {"/guestbook"})
public class GuestbookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GuestbookServlet() {
      super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("GuestBookServlet.doGet() 호출");
      request.setCharacterEncoding("utf-8");

      String actionName = request.getParameter("a");
      
      if("deleteform".equals(actionName)) {
        System.out.println("actionName => " + actionName);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
        rd.forward(request, response);
      }
      else if("add".equals(actionName)) {
        System.out.println("actionName => " + actionName);
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String content = request.getParameter("content");

        GuestbookVo vo = new GuestbookVo();

        vo.setName(name);
        vo.setPassword(password);
        vo.setContent(content);

        guestbookDao dao = new GuestbookDaoImpl();
        dao.insert(vo);

        response.sendRedirect("/GuestbookJSP/guestbook");
      }else if("delete".equals(actionName)) {
        System.out.println("actionName => " + actionName);
        request.setCharacterEncoding("utf-8");
        
        Integer no = Integer.parseInt(request.getParameter("no"));
        String password = request.getParameter("password");
        String dbpass = request.getParameter("dbpass");
        
        GuestbookVo vo = new GuestbookVo();
        
        vo.setNo(no);
        vo.setPassword(password);
        
        guestbookDao dao = new GuestbookDaoImpl();
        
        
        if( dbpass.equals(password)){
          dao.delete(vo);
        }
        
        response.sendRedirect("/GuestbookJSP/guestbook");
      }else {
        System.out.println("actionName => " + actionName);
        guestbookDao dao = new GuestbookDaoImpl();
        List<GuestbookVo> list = dao.getList();

        request.setAttribute("list", list);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        rd.forward(request, response);
      }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}