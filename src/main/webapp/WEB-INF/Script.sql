-- 회원 테이블
CREATE TABLE MEMBER(
    MEMBER_CODE NUMBER(4) PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) UNIQUE NOT NULL,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    MEMBER_BIRTH DATE NOT NULL,
    MEMBER_GENDER VARCHAR2(4) NOT NULL,
    MEMBER_PHONE VARCHAR2(11) UNIQUE NOT NULL,
    MEMBER_PHONE_AGREE NUMBER(1) DEFAULT 0 NOT NULL, -- 0: 비동의 1: 동의
    MEMBER_EMAIL VARCHAR2(40) UNIQUE NOT NULL,
    MEMBER_EMAIL_AGREE NUMBER(1) DEFAULT 0 NOT NULL,
    MEMBER_POST VARCHAR2(20) NOT NULL,
    MEMBER_ADDRESS VARCHAR2(100) NOT NULL,
    MEMBER_GRADE NUMBER(1) DEFAULT 1 NOT NULL
);

-- 상품 테이블
create table product (
    product_id number(4) not null primary key,
    product_name varchar2(200) not null,
    product_brand varchar2(50) not null,
    product_cate varchar2(50) not null,
    product_price number not null,
    product_main_img varchar2(300) not null,
    product_sub_img_f varchar2(300) null,
    product_sub_img_s varchar2(300) null,
    product_sub_img_t varchar2(300) null,
    product_new number(1) null,
    product_best number(1) null
);
-- 상품 입력 데이터
-- new
insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_new)
values((select nvl(max(product_id),0)+1 from product),'포마드 콘크레뜨 핸드크림','Buly',
'bodyNhand',58000,'Images/product_img/main/불리 포마드 콘크레뜨 핸드크림 75ml.jpg',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_new)
values((select nvl(max(product_id),0)+1 from product),'오 트리쁠 향수 발팽송의 목욕하는 여인','Buly',
'fragrances',276100,'Images/product_img/main/불리 오 트리쁠 향수 발팽송의 목욕하는 여인.jpg',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_new)
values((select nvl(max(product_id),0)+1 from product),'윌 앙띠끄 바디오일 - 리켄 데코스','Buly',
'bodyNhand',80100,'Images/product_img/main/불리 윌 앙띠끄 바디오일 - 리켄 데코스.jpg',1);

-- best

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'프리지아 오드 코롱','Santa Maria Vovella',
'fragrances',152000,'Images/Perfume/Santa_Maria_Vovella_프리지아_오드코롱_50ml.png',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'오 드 퍼퓸 필로시코스','diptyque',
'fragrances',167000,'Images/Perfume/diptyque_오_드_퍼퓸_필로시코스_75ml.png',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'오 드 퍼퓸 도손','diptyque',
'fragrances',167000,'Images/Perfume/diptyque_오드퍼퓸_도_손.png',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'라 까사 술 라고 디퓨저','ACQUA DI PARMA',
'home',127000,'Images/Perfume/라 까사 술 라고 디퓨저.jpg',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'로사 노빌레 EDP','ACQUA DI PARMA',
'fragrances',184500,'Images/Perfume/로사 노빌레 EDP.jpg',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'매그놀리아 노빌레 EDP','ACQUA DI PARMA',
'fragrances',184500,'Images/Perfume/매그놀리아 노빌레 EDP.jpg',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'어벤투스 포 허 EDP','CREED',
'fragrances',369000,'Images/Perfume/[크리드] 어벤투스 포 허 EDP.jpg',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'어나더 13','LELABO',
'fragrances',220300,'Images/Perfume/LELABO 르라보 어나더 13.jpg',1);
