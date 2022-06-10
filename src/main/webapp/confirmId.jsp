<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.MemberDAO" %>

<% 
  String id = request.getParameter("id");
  
  MemberDAO dao = new MemberDAO();
  
  int check= dao.confirmID(id);
  
  out.println(check);//처리 결과를 register.js로 리턴
 %>