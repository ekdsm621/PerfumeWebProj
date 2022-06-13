<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<%@ include file="include_common/setting.jsp"%>
<link rel="stylesheet" href="css/style_detail.css" type="text/css">
</head>
<body>
	
    <div id="box">
        <%@ include file="include_common/header.jsp"%>
        
        <div id="content">
        	<div class="cont_top">
                <!-- .imgslide: 상품 사진 -->
                <div class="imgslide">
                    <a><img src="${detail.sub_img_f }" alt=""></a>
                    <a><img src="${detail.sub_img_s }" alt=""></a>
                    <a><img src="${detail.sub_img_t }" alt=""></a>
                </div>

                <!-- .prod_info: 상품 정보 -->
                <div class="prod_info">
                    <h2>${detail.name }</h2>
                    <hr>
                    <table>
                        <tr>
                            <th>판매가</th>
                            <td>${detail.price }</td>
                        </tr>
                        <tr>
                            <th>배송비</th>
                            <td>2,500</td>
                        </tr>
                        <tr>
                            <th>옵션 선택 </th>
                            <td>
                                <select>
                                    <option>
                                        ---- Select Option ----
                                    </option>
                                    <option value="">
                                        Option 1
                                    </option>
                                    <option value="">
                                        Option 2
                                    </option>
                                    <option value="">
                                        Option 3
                                    </option>
                                </select>
                            </td>
                        </tr>
                        <tr><td></td><td></td></tr>
                        <tr>
                            <th>총 상품금액</th>
                            <td>${(detail.price + 2500) }</td>
                        </tr>
                        <tr><td></td><td></td></tr>
                        <tr>
                        	<td style="text-align:center"><button>장바구니</button></td>
                        	<td style="text-align:center"><button>주문하기</button></td>
                        </tr>
                    </table>
                </div>
            </div>
            <hr>
            
            <!-- .cont_body: 상품 상세 사진 -->
            <div class="cont_body">
                <img src="${detail.detail_img }" alt="">
            </div>
        </div>
     </div>
     
    <%@ include file="include_common/loginPopup.jsp"%>
    <%@ include file="include_common/footer.jsp"%>
</body>
</html>