<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link href="css/style_index.css" type="text/css" rel="stylesheet">
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
                    <li><a href="detail.html"><img src="Images/Perfume/불리 포마드 콘크레뜨 핸드크림 75ml.jpg" alt=""></a>
                        <a href="">Buly<br>포마드 콘크레뜨 핸드크림</a></li>
                    <li><a href="#"><img src="Images/Perfume/불리 오 트리쁠 향수 발팽송의 목욕하는 여인.jpg" alt=""></a>
                        <a href="">Buly<br>오 트리쁠 향수 발팽송의 목욕하는 여인</a></li>
                    <li><a href="#"><img src="Images/Perfume/불리 윌 앙띠끄 바디오일 - 리켄 데코스.jpg" alt=""></a>
                            <a href="">Buly<br>윌 앙띠끄 바디오일 - 리켄 데코스</a></li>
                </ul>
            </div>
            <!-- .best_prod: 베스트상품 -->
            <div class="best_prod">
                <h3>Best Seller</h3>
                <hr>
                <ul>
                    <li><a href="#"><img src="Images/Perfume/Santa_Maria_Vovella_프리지아_오드코롱_50ml.png" alt=""></a>
                        <a href="#">Santa Maria Vovella<br>프리지아 오드 코롱</a></li>
                    <li><a href="#"><img src="Images/Perfume/diptyque_오_드_퍼퓸_필로시코스_75ml.png" alt=""></a>
                        <a href="#">diptyque<br>오 드 퍼퓸 필로시코스</a></li>
                    <li><a href="detail.html"><img src="Images/Perfume/diptyque_오드퍼퓸_도_손.png" alt=""></a>
                        <a href="">diptyque<br>오 드 퍼퓸 도손</a></li>
                    <li><a href="#"><img src="Images/Perfume/라 까사 술 라고 디퓨저.jpg" alt=""></a>
                        <a href="">ACQUA DI PARMA<br>라 까사 술 라고 디퓨저</a></li>
                    <li><a href="#"><img src="Images/Perfume/로사 노빌레 EDP.jpg" alt=""></a>
                            <a href="">ACQUA DI PARMA<br>로사 노빌레 EDP</a></li>
                    <li><a href="#"><img src="Images/Perfume/매그놀리아 노빌레 EDP.jpg" alt=""></a>
                            <a href="">ACQUA DI PARMA<br>매그놀리아 노빌레 EDP</a></li>
                    <li><a href="#"><img src="Images/Perfume/[크리드] 어벤투스 포 허 EDP.jpg" alt=""></a>
                        <a href="">CREED<br>어벤투스 포 허 EDP</a></li>
                    <li><a href="#"><img src="Images/Perfume/LELABO 르라보 어나더 13.jpg" alt=""></a>
                        <a href="">LELABO<br>어나더 13</a></li>

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