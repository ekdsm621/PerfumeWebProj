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
<script type="text/javascript">
function selectAll(selectAll)  {
  const checkboxes 
       = document.getElementsByName('checkedId');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
  })
}
</script>
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
	        <form action="/actcart.do" >
	        <table class="cart">
	        	<tr>
	        		<th class="selector"><input type="checkbox" name="checkedId" value="all" onclick='selectAll(this)'></th>
	        		<th class="prod" colspan="2">상품명</th>
	        		<th class="prod_quantity">수량</th>
	        		<th class="prod_price">판매가</th>
	        		<th class="cart_option">선택</th>
	        	</tr>
        		<c:if test="${cartExist eq 1 }">
	        	<c:forEach var="item" items="${cartItem }">
	        	<tr class="cate_prod">
		        	<td class="selector">
		        		<input type="checkbox" name="checkedId" value="${item.id }">
		        	</td>
		        	<td class="prod_img">
		        		<img src="${item.main_img }">
		        	</td>
		        	<td class="prod_name">
		        		${item.name }
		        	</td>
		        	<td class="prod_quantity">
		        		${item.quantity }
		        	</td>
		        	<td class="prod_price">
		        		${item.priceStr(item.price) }
		        	</td>
		        	<td class="cart-option">
						<button name="act" value="delete">삭제하기</button>
						<button name="act" value="order">주문하기</button>
					</td>
	        	</tr>
	        	</c:forEach>
        		</c:if>
	        </table>
	        </form>
	        

	        <table class="order">
	        	<tr>
	        		<td colspan="2" style="border-bottom: 1px solid #c0c0c0;">주문 요약</td>
	        	</tr>
	        	
	        	<tr>
	        		<td>총 금액</td>
	        		<td>${totalPriceStr }</td>
	        	</tr>
	        	<tr>
	        		<td>배송비</td>
	        		<td>
	        		<c:choose>
	        		<c:when test="${cartExist eq 1 }">
	        		2,500
	        		</c:when>
	        		<c:otherwise>
	        		0
	        		</c:otherwise>
	        		</c:choose>
	        		</td>
	        	</tr>
	        	<tr>
	        		<td>총 결제금액</td>
	        		<td>${totalPriceWithShipStr }</td>
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