<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
	<div align="center">
		<h3>상품 목록</h3>
		<table>
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>브랜드</th>
				<th>카테고리</th>
				<th>가격</th>
				<th>새상품</th>
				<th>베스트상품</th>
				<th>삭제</th>
				<th>수정</th>
			</tr>
			
			<c:forEach items="${products }" var="product">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.brand }</td>
				<td>${product.cate }</td>
				<td>${product.price }</td>
				<td>${product.prod_new }</td>
				<td>${product.prod_best }</td>
				<td><a href="/admin/productDelete.do?id=${product.id }"><button>삭제</button></a></td>
				<td><a href="/admin/productUpdate.do?id=${product.id }"><button>수정</button></a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>