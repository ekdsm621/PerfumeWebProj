<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 페이지</title>
</head>
<body>
	<div align="center">
		<h3 style="margin-top:200px">상품 등록</h3>
		<hr width="400px">
		<form method="post" enctype="multipart/form-data" action="/insertProduct.do">
			<table>
				<tr>
					<td>상품명: </td>
					<td><input type="text" name="product_name"></td>
				</tr>
				<tr>
					<td>브랜드: </td>
					<td><input type="text" name="product_brand"></td>
				</tr>
				<tr>
					<td>카테고리: </td>
					<td>
						<select name="product_cate">
							<option value="fragrances">FRAGRANCES</option>
							<option value="skin care">SKIN CARE</option>
							<option value="body & hand">BODY & HAND</option>
							<option value="home">HOME</option>
							<option value="acc">ACC</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>가격: </td>
					<td><input type="text" name="product_price"></td>
				</tr>
				<tr>
					<td>메인 상품 이미지: </td>
					<td><input type="file" name="product_main"></td>
				</tr>
				<tr>
					<td>상품 이미지1: </td>
					<td><input type="file" name="product_sub_img_f"></td>
				</tr>
				<tr>
					<td>상품 이미지2: </td>
					<td><input type="file" name="product_sub_img_s"></td>
				</tr>
				<tr>
					<td>상품 이미지3: </td>
					<td><input type="file" name="product_sub_img_t"></td>
				</tr>
				<tr>
					<td>상세 이미지: </td>
					<td><input type="file" name="product_detail_img"></td>
				</tr>
				<tr>
					<td>베스트 상품: </td>
					<td><input type="radio" name="product_best" value="1"></td>
				</tr>
				<tr>
					<td>신상품: </td>
					<td><input type="radio" name="product_new" value="1"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록">
						<input type="reset" value="리셋">
					</td>
				</tr>		
			</table>
		</form>
	</div>
</body>
</html>