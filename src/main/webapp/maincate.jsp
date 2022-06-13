<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>Main Category</title>
<!-- 그 외 css와 설정 -->
<%@ include file="include_common/setting.jsp"%>
<!-- maincate css -->
<link href="css/style_maincate.css" type="text/css" rel="stylesheet">
</head>
<body>
    <!-- .box: 헤더 + 본문 -->
    <div id="box">
        <!-- .header: 로고 + 회원 메뉴 + 네비게이션바 -->
        <%@ include file="include_common/header.jsp"%>
		<!-- maincate.html 고유 -->
        <!-- .content: 메인 이미지 슬라이드 + 서브 카테고리 + 상품 -->
        <div id="content">
            <!-- .imgslide: 메인 이미지 슬라이드 -->
            <div class="imgslide">
                <a href="#"><img src="Images/img_slide/배너1.jpg" alt=""></a>
                <a href="#"><img src="Images/img_slide/배너2.jpg" alt=""></a>
                <a href="#"><img src="Images/img_slide/배너3.jpg" alt=""></a>
            </div>

            <!-- .main: 메인 카테고리 -->
            <div class="main">
            <c:choose>
            <c:when test="${param.maincate eq null }">
                <span class="main_cate_name">FRAGRANCES</span>
            </c:when>
            <c:otherwise>
                <span class="main_cate_name">${param.maincate }</span>
            </c:otherwise>
            </c:choose>
            </div>

            <!-- .sub: 서브 카테고리 -->
            <div class="sub">
                <ul class="sub_cate_name">
                    <li><a href="#">ALL</a></li>
                    <li><a href="#">BRAND</a></li>
                    <li><a href="#">UNISEX</a></li>
                    <li><a href="#">FOR MAN</a></li>
                    <li><a href="#">FOR WOMAN</a></li>
                </ul>
            </div>
            <hr>

            <!-- .prod_list: 상품 -->
            <div class="prod_list">
                <ul>
                <c:forEach var="prod" items="${products }" >
	               	<li>
	               		<a href="/detail.do?id=${prod.id }"><img src="${prod.main_img }" alt=""></a>
                        <a href="/detail.do?id=${prod.id }">${prod.brand }<br>${prod.name }</a>
                    </li>
                </c:forEach>
                </ul>                
            </div>
            <!-- 페이징 -->
            <%@ include file="include_common/paging.jsp" %>
        </div>
    </div>


<!-- index.html과 동일 -->
    <!-- .layer: .login 누르면 뜨는 로그인창 -->
    <%@ include file="include_common/loginPopup.jsp"%>

    <!-- 푸터 -->
    <%@ include file="include_common/footer.jsp"%>
</body>
</html>