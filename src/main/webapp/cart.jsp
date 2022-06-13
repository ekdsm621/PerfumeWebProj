<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<!-- 그 외 css와 설정 -->
<%@ include file="include_common/setting.jsp"%>
<!-- maincate css -->
<link href="css/style_cart.css" type="text/css" rel="stylesheet">
</head>
<body>
	 <!-- .box: 헤더 + 본문 -->
    <div id="box">
        <!-- .header: 로고 + 회원 메뉴 + 네비게이션바 -->
        <%@ include file="include_common/header.jsp"%>
        <div id="content">
        <hr>
        	<!-- 상단 제목들 -->
        	
	        <h3 class="cart_subj">장바구니</h3>
	        <!-- 카트 -->
	        <table class="cart">
	        	<tr>
	        		<th class="selector"><input type="radio"></th>
	        		<th class="prod" colspan="2">상품명</th>
	        		<th class="prod_quantity">수량</th>
	        		<th class="prod_price">판매가</th>
	        		<th class="cart_option">선택</th>
	        	</tr>
	        	<tr class="cate_prod">
		        	<td class="selector">
		        		<input type="radio">
		        	</td>
		        	<td class="prod_img">
		        		<img src="Images/product_img/main/diptyque_오 드 뚜왈렛 EDT_도_손.png">
		        	</td>
		        	<td class="prod_name">
		        		diptyque_오 드 뚜왈렛 EDT_도_손
		        	</td>
		        	<td class="prod_quantity">
		        		수량
		        	</td>
		        	<td class="prod_price">
		        		판매가
		        	</td>
		        	<td class="cart-option">
						<button>삭제하기</button>
						<button>주문하기</button>
					</td>
	        	</tr>
	        	<tr class="cate_prod">
		        	<td class="selector">
		        		<input type="radio">
		        	</td>
		        	<td class="prod_img">
		        		<img src="Images/product_img/main/diptyque_오 드 뚜왈렛 EDT_도_손.png">
		        	</td>
		        	<td class="prod_name">
		        		diptyque_오 드 뚜왈렛 EDT_도_손
		        	</td>
		        	<td class="prod_quantity">
		        		수량
		        	</td>
		        	<td class="prod_price">
		        		판매가
		        	</td>
		        	<td class="cart-option">
						<button>삭제하기</button>
						<button>주문하기</button>
					</td>
	        	</tr>
	        </table>

	        <table class="order">
	        	<tr>
	        		<td colspan="2" style="border-bottom: 1px solid #c0c0c0;">주문 요약</td>
	        	</tr>
	        	
	        	<tr>
	        		<td>총 금액</td>
	        		<td>xxxxxx</td>
	        	</tr>
	        	<tr>
	        		<td>배송비</td>
	        		<td>xxxxxx</td>
	        	</tr>
	        	<tr>
	        		<td>총 결제금액</td>
	        		<td>xxxxxx</td>
	        	</tr>
	        	<tr>
	        		<th colspan="2">주문 하기</th>
	        	</tr>
	        </table>

        </div>
    </div>
<!-- index.html과 동일 -->
    <!-- .layer: .login 누르면 뜨는 로그인창 -->
    <%@ include file="include_common/loginPopup.jsp"%>

    <!-- 푸터 -->
    <%@ include file="include_common/footer.jsp"%>
</body>
</html>