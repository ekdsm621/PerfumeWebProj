<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.MemberDAO" %>
<%@ page import="member.MemberDTO" %>

<% 
  String id = request.getParameter("id");
  String password = request.getParameter("password");
  
  System.out.println(id);
  System.out.println(password);
  
  MemberDAO dao = new MemberDAO();
  MemberDTO dto = new MemberDTO();
  
  dto.setId(id);
  dto.setPw(password);
  
  int data = 0;
  
  MemberDTO member = dao.getMember(dto);
  if(member != null){
	  data = 1;
	  session.setAttribute("id", member.getId());
  }else{
	  data = 0;
  }
  
  System.out.println(data);
  out.println(data);
 %>