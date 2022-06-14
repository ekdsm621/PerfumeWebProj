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

-- 메인 카테고리 테이블
create table main_category(
    cate_id number(4) primary key,
    cate_name varchar2(50) not null
);

insert into main_category(cate_id, cate_name)
values((select nvl(max(cate_id),0)+1 from main_category),'FRAGRANCES');

insert into main_category
values((select nvl(max(cate_id),0)+1 from main_category),'SKIN CARE');

insert into main_category
values((select nvl(max(cate_id),0)+1 from main_category),'BODY & HAND');

insert into main_category
values((select nvl(max(cate_id),0)+1 from main_category),'HOME');

insert into main_category
values((select nvl(max(cate_id),0)+1 from main_category),'ACC');

insert into main_category
values((select nvl(max(cate_id),0)+1 from main_category),'ABOUT');

-- 서브 카테고리 테이블
create table sub_category(
    cate_id number(4) primary key,
    cate_name varchar2(50) not null,
    main_cate_id number(4),
    constraint fk_sub_main_id foreign key(main_cate_id) references main_category(cate_id) on delete cascade
);

insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'ALL',1);
insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'BRAND',1);
insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'UNISEX',1);
insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'FOR MAN',1);
insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'FOR WOMAN',1);

insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'CLEANSERS',2);
insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'SKIN & LOTION',2);

insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'HAND CARE',3);
insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'BODY CARE',3);
insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'SOAP',3);

insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'DIFFUSER',4);
insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'CANDLE',4);

insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'TRAVLE KIT',5);

insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'CONTACT US',6);
insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'EVENT',6);
insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'시향 서비스',6);
insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'문의 사항',6);


-- 상품 디테일 테이블
create table product_detail(
    product_id number(4) not null primary key,
    product_sub_img_f varchar2(300) not null,
    product_sub_img_s varchar2(300) not null,
    product_sub_img_t varchar2(300) not null,
    product_detail_img varchar2(300) not null,
     constraint fk_detail_prod_id foreign key(product_id) references product(product_id) on delete cascade
);

insert into product_detail(product_id,product_sub_img_f,product_sub_img_s,product_sub_img_t,product_detail_img)
values(6, 'Images/product_img/sub/prod_img1.png','Images/product_img/sub/prod_img2.png','Images/product_img/sub/prod_img3.png', 'Images/product_img/detail/998c9866d03e515a5789ea523db11542.jpg');

insert into product_detail(product_id,product_sub_img_f,product_sub_img_s,product_sub_img_t,product_detail_img)
values(2, 'Images/product_img/sub/불리_오_뜨리쁠_1.jpg','Images/product_img/sub/불리_오_뜨리쁠_3.png','Images/product_img/sub/불리_오_뜨리쁠_2.jpg', 'Images/product_img/detail/Buly-1803-Le-MusC3A9e-du-Louvre-La-Baigneuse_D.jpg');