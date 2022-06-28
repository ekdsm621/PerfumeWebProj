<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.MemberDAO" %>

<% 
  String id = request.getParameter("id");
  
  MemberDAO dao = new MemberDAO();
  
  int check= dao.confirmID(id);
  
  out.println(check);
 %>