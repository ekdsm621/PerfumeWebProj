<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Index</title>
<%@ include file="include_common/setting.jsp"%>
</head>
<body>
    <!-- .box: 헤더 + 본문 -->
    <div id="box">
        <!-- .header: 로고 + 회원 메뉴 + 네비게이션바 -->
		<%@ include file="include_common/header.jsp"%>
        <!-- .content : 메인 사진 + 신상품 + 베스트상품 -->
        <div id="content">
            <!-- .main_pic: 메인 사진 -->
            <img class="main_pic" src="Images/lavender.jpg" alt="라벤더">
            <!-- .new_prod: 신상품 -->
            <div class="new_prod">
                <h3>New Product</h3>
                <hr>
                <ul>
                	<c:forEach var="newProd" items="${newProducts }" >
	                    <li><a href="detail.html"><img src="${newProd.main_img }" alt=""></a>
	                        <a href="">${newProd.brand }<br>${newProd.name }</a></li>                	
                	</c:forEach>
                </ul>
            </div>
            <!-- .best_prod: 베스트상품 -->
            <div class="best_prod">
                <h3>Best Seller</h3>
                <hr>
                <ul>
                	<c:forEach var="bestProd" items="${bestProducts }" >
	                    <li><a href="detail.html"><img src="${bestProd.main_img }" alt=""></a>
	                        <a href="">${bestProd.brand }<br>${bestProd.name }</a></li>                	
                	</c:forEach>
                </ul>
            </div>
        </div>
    </div>

    <!-- .layer: .login 누르면 뜨는 로그인창 -->
    <%@ include file="include_common/loginPopup.jsp"%>

    <!-- 푸터 -->
    <%@ include file="include_common/footer.jsp"%>
</body>
</html>