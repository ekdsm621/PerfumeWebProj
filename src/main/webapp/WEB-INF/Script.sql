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
    product_sub_img_f varchar2(300) null,
    product_sub_img_s varchar2(300) null,
    product_sub_img_t varchar2(300) null,
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
