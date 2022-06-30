<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
	<!-- .header_top: 로고 + 로그인 -->
	<div class="header_top">
		<!-- .logo: 로고 -->
		<div class="logo">
			<a href="/home.do">
				<h2>Perfumality</h2>
			</a>
		</div>
		<!-- .member: 회원 관련 메뉴 -->
		<div class="member">
			<!-- .login: 누르면 로그인창 띄움 -->
			<a class="login"><img src="Images/member.png"></a>
			<ul>
				<%if(session.getAttribute("id") != null){
				String from = request.getRequestURI();%>
				<li><a href="" id="logoutBtn">Logout</a></li>
				<%}else{%>
				<li><a class="login">Login</a></li>
				<li><a href="join.jsp">Join</a></li>
				<%} %>
				<li><a href="/cart.do">Cart</a></li>
			</ul>
		</div>
	</div>
	<!-- .nav: 네비게이션 -->
	<div class="nav">
		<ul class="main_cate">			
			<c:forEach var="main" items="${allCate }">
			<li><a href="maincate.do?maincate=${main.key }">${main.key }</a>
				<ul class="sub_cate">
					<c:forEach var="sub" items="${main.value }">
					<li><a href="#">${sub }</a></li>
					</c:forEach>
				</ul>
			</li>
			</c:forEach>
		</ul>
	</div>
</div>