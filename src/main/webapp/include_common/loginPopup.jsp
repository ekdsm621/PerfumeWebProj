<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="layer">
	<div class="layer_up">
		<div class="btn">x</div>
		<div class="uptitle">LOGIN</div>
		<div class="upbody">
			<form action="/login.do" class="login_box" method="post">
				<div class="user">
					<label for="id">User</label>
					<input type="text" id="id" name="id">
				</div>
				<div class="password">
					<label for="password">Password</label>
					<input type="password" id="password" name="pw">
				</div>
				<button type="submit">로그인</button>
			</form>
			<div class="find">
				<a href="#">비밀번호 찾기</a> <a href="#">아이디 찾기</a> <a href="join.jsp">회원가입</a>
			</div>
			<hr style="width: 425px; border-color: rgb(231, 231, 231);">
			<div>SNS 로그인</div>
			<div class="sns_login">
				<img src="Images/sns_icon/kakaotalk.ico" alt=""> <img
					src="Images/sns_icon/facebook.ico" alt=""> <img
					src="Images/sns_icon/instagram.ico" alt=""> <img
					src="Images/sns_icon/google.ico" alt="">
			</div>
		</div>
	</div>
</div>
