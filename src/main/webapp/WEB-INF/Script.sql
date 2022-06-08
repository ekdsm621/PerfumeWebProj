-- ȸ�� ���̺�
CREATE TABLE MEMBER(
    MEMBER_CODE NUMBER(4) PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) UNIQUE NOT NULL,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    MEMBER_BIRTH DATE NOT NULL,
    MEMBER_GENDER VARCHAR2(2) NOT NULL,
    MEMBER_PHONE VARCHAR2(11) UNIQUE NOT NULL,
    MEMBER_PHONE_AGREE NUMBER(1) DEFAULT 0 NOT NULL, -- 0: ���� 1: ����
    MEMBER_EMAIL VARCHAR2(40) UNIQUE NOT NULL,
    MEMBER_EMAIL_AGREE NUMBER(1) DEFAULT 0 NOT NULL,
    MEMBER_POST VARCHAR2(20) NOT NULL,
    MEMBER_ADDRESS VARCHAR2(100) NOT NULL,
    MEMBER_GRADE NUMBER(1) DEFAULT 1 NOT NULL
);