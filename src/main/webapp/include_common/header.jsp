<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header">
	<!-- .header_top: 로고 + 로그인 -->
	<div class="header_top">
		<!-- .logo: 로고 -->
		<div class="logo">
			<a href="#">
				<h2>Perfumality</h2>
			</a>
		</div>
		<!-- .member: 회원 관련 메뉴 -->
		<div class="member">
			<!-- .login: 누르면 로그인창 띄움 -->
			<a class="login"><img src="Images/member.png"></a>
			<ul>
				
				<%if(session.getAttribute("id") != null){%>
				<li><a href="/logout.do">Logout</a></li>
				<%}else{%>
				<li><a class="login">Login</a></li>
				<%} %>
				
				<li><a href="join.jsp">Join</a></li>
				<li><a href="#">Cart</a></li>
			</ul>
		</div>
	</div>
	<!-- .nav: 네비게이션 -->
	<div class="nav">
		<ul class="main_cate">
			<li><a href="maincate.html">FRAGRANCES</a>
				<ul class="sub_cate">
					<li><a href="#">ALL</a></li>
					<li><a href="#">BRAND</a></li>
					<li><a href="#">UNISEX</a></li>
					<li><a href="#">FOR MAN</a></li>
					<li><a href="#">FOR WOMAN</a></li>
				</ul></li>
			<li><a href="#">SKIN CARE</a>
				<ul class="sub_cate">
					<li><a href="#">CLEANSERS</a></li>
					<li><a href="#">SKIN & LOTION</a></li>
				</ul></li>
			<li><a href="#">BODY & HAND</a>
				<ul class="sub_cate">
					<li><a href="#">HAND CARE</a></li>
					<li><a href="#">BODY CARE</a></li>
					<li><a href="#">SOAP</a></li>
				</ul></li>
			<li><a href="#">HOME</a>
				<ul class="sub_cate">
					<li><a href="#">DIFFUSER</a></li>
					<li><a href="#">CANDLE</a></li>
				</ul></li>
			<li><a href="#">ACC</a>
				<ul class="sub_cate">
					<li><a href="#">TRAVLE KIT</a></li>
				</ul></li>
			<li><a href="#">ABOUT</a>
				<ul class="sub_cate">
					<li><a href="#">CONTACT US</a></li>
					<li><a href="#">EVENT</a></li>
					<li><a href="#" style="font-weight: bold;">시향 서비스</a></li>
					<li><a href="#" style="font-weight: bold;">문의 사항</a></li>
				</ul></li>
		</ul>
	</div>
</div>