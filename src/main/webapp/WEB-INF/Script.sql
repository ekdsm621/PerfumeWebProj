-- ȸ�� ���̺�
CREATE TABLE MEMBER(
    MEMBER_CODE NUMBER(4) PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) UNIQUE NOT NULL,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    MEMBER_BIRTH DATE NOT NULL,
    MEMBER_GENDER VARCHAR2(4) NOT NULL,
    MEMBER_PHONE VARCHAR2(11) UNIQUE NOT NULL,
    MEMBER_PHONE_AGREE NUMBER(1) DEFAULT 0 NOT NULL, -- 0: ���� 1: ����
    MEMBER_EMAIL VARCHAR2(40) UNIQUE NOT NULL,
    MEMBER_EMAIL_AGREE NUMBER(1) DEFAULT 0 NOT NULL,
    MEMBER_POST VARCHAR2(20) NOT NULL,
    MEMBER_ADDRESS VARCHAR2(100) NOT NULL,
    MEMBER_GRADE NUMBER(1) DEFAULT 1 NOT NULL
);

-- ��ǰ ���̺�
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

-- ��ǰ �Է� ������
-- new
insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_new)
values((select nvl(max(product_id),0)+1 from product),'������ ��ũ���� �ڵ�ũ��','Buly',
'bodyNhand',58000,'Images/product_img/main/�Ҹ� ������ ��ũ���� �ڵ�ũ�� 75ml.jpg',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_new)
values((select nvl(max(product_id),0)+1 from product),'�� Ʈ���� ��� ���ؼ��� ����ϴ� ����','Buly',
'fragrances',276100,'Images/product_img/main/�Ҹ� �� Ʈ���� ��� ���ؼ��� ����ϴ� ����.jpg',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_new)
values((select nvl(max(product_id),0)+1 from product),'�� �Ӷ�� �ٵ���� - ���� ���ڽ�','Buly',
'bodyNhand',80100,'Images/product_img/main/�Ҹ� �� �Ӷ�� �ٵ���� - ���� ���ڽ�.jpg',1);

-- best

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'�������� ���� �ڷ�','Santa Maria Vovella',
'fragrances',152000,'Images/Perfume/Santa_Maria_Vovella_��������_�����ڷ�_50ml.png',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'�� �� ��Ǿ �ʷν��ڽ�','diptyque',
'fragrances',167000,'Images/Perfume/diptyque_��_��_��Ǿ_�ʷν��ڽ�_75ml.png',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'�� �� ��Ǿ ����','diptyque',
'fragrances',167000,'Images/Perfume/diptyque_������Ǿ_��_��.png',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'�� ��� �� ��� ��ǻ��','ACQUA DI PARMA',
'home',127000,'Images/Perfume/�� ��� �� ��� ��ǻ��.jpg',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'�λ� ����� EDP','ACQUA DI PARMA',
'fragrances',184500,'Images/Perfume/�λ� ����� EDP.jpg',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'�ű׳�� ����� EDP','ACQUA DI PARMA',
'fragrances',184500,'Images/Perfume/�ű׳�� ����� EDP.jpg',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'����� �� �� EDP','CREED',
'fragrances',369000,'Images/Perfume/[ũ����] ����� �� �� EDP.jpg',1);

insert into product(product_id,product_name,product_brand,product_cate,product_price,product_main_img,product_best)
values((select nvl(max(product_id),0)+1 from product),'��� 13','LELABO',
'fragrances',220300,'Images/Perfume/LELABO ���� ��� 13.jpg',1);

-- ���� ī�װ� ���̺�
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

-- ���� ī�װ� ���̺�
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
values((select nvl(max(cate_id),0)+1 from sub_category),'���� ����',6);
insert into sub_category
values((select nvl(max(cate_id),0)+1 from sub_category),'���� ����',6);


-- ��ǰ ������ ���̺�
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
values(2, 'Images/product_img/sub/�Ҹ�_��_�߸���_1.jpg','Images/product_img/sub/�Ҹ�_��_�߸���_3.png','Images/product_img/sub/�Ҹ�_��_�߸���_2.jpg', 'Images/product_img/detail/Buly-1803-Le-MusC3A9e-du-Louvre-La-Baigneuse_D.jpg');