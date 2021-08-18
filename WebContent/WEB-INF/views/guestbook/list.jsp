<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ page import="com.javaex.dao.guestbookDao"%>
<%@ page import="com.javaex.dao.GuestbookVo"%>
<%@ page import="com.javaex.dao.GuestbookDaoImpl"%>
<%@ page import="java.util.List"%>

<%
  guestbookDao dao = new GuestbookDaoImpl();

  List<GuestbookVo> list = dao.getList();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="add.jsp" method="get">
    <table border='1'>
      <tr>
        <td>이름</td>
        <td><input type="text" name="name" size="30px"></td>
        <td>비밀번호</td>
        <td><input type="password" name="password" size="20px"></td>
      </tr>
      <tr>
        <td colspan="4"><textarea name="content" cols="60" rows="10"></textarea></td>
      </tr>
      <tr>
        <td colspan="4"><input type="submit" value="확인" id="bt"></td>
      </tr>

    </table>
  </form>
  <br>
  <br>


  <% 
      for (GuestbookVo GuestbookVO: list) {
  %>
  <form action="deleteform.jsp" method="get">
    <table border='1'>
      <tr>
        <td width="10px"><%= GuestbookVO.getNo() %></td>
        <td width="30px"><%= GuestbookVO.getName() %></td>
        <td width="50px"><%= GuestbookVO.getReg_date() %></td>
        <td width="20px"><input type="submit" value="삭제"></td>
      </tr>
      <tr>
        <td colspan="4">
          <textarea name="content" cols="60" rows="4"><%= GuestbookVO.getContent() %></textarea>
        </td>
      </tr>
    </table>
    <input type="hidden" name="no" value="<%= GuestbookVO.getNo() %>">
    <input type="hidden" name="dbPassWord" value="<%= GuestbookVO.getPassword() %>">
  </form>

  <%
      }
   %>

</body>
</html>