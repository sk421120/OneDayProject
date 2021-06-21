-- food

--DROP TABLE tbl_myfoods CASCADE CONSTRAINTS;
--DROP VIEW view_일일섭취 CASCADE CONSTRAINTS;

CREATE TABLE tbl_foods (
    f_code     CHAR(7) PRIMARY KEY,
    f_name     NVARCHAR2(125) NOT NULL,
    f_date     NUMBER NOT NULL,
    f_ccode    CHAR(6) NOT NULL,
    f_icode    CHAR(4) NOT NULL,
    f_serv     NUMBER NOT NULL,
    f_cap      NUMBER NOT NULL,
    f_energy   NUMBER NOT NULL,
    f_protein  NUMBER NOT NULL,
    f_fat      NUMBER NOT NULL,
    f_carbo    NUMBER NOT NULL,
    f_sugar    NUMBER NOT NULL
);

CREATE TABLE tbl_company (
    c_code  CHAR(6) PRIMARY KEY,
    c_name  NVARCHAR2(100) NOT NULL
);

CREATE TABLE tbl_items (
    i_code  CHAR(4) PRIMARY KEY,
    i_name  NVARCHAR2(50) NOT NULL
);

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_company
FOREIGN KEY (f_ccode)
REFERENCES tbl_company(c_code);

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_items
FOREIGN KEY (f_icode)
REFERENCES tbl_items(i_code);

CREATE VIEW view_식품정보 AS (
SELECT
    F.f_code 식품코드,
    F.f_name 식품명,
    F.f_date 출시일,
    F.f_ccode 제조사코드,
    C.c_name 제조사명,
    F.f_icode 분류코드,
    I.i_name 분류명,
    F.f_serv "1회제공량",
    F.f_cap 총내용량,
    F.f_energy 에너지,
    F.f_protein 단백질,
    F.f_fat 지방,
    F.f_carbo 탄수화물,
    F.f_sugar 총당류
FROM tbl_foods F
    LEFT JOIN tbl_company C
        ON F.f_ccode = C.c_code
    LEFT JOIN tbl_items I
        ON F.f_icode = I.i_code
);

CREATE TABLE tbl_myfoods (
    m_seq   NUMBER PRIMARY KEY,
    m_date    VARCHAR2(10) NOT NULL,
    m_fcode   CHAR(7) NOT NULL,
    m_intake  NUMBER NOT NULL
);

ALTER TABLE tbl_myfoods
ADD CONSTRAINT fk_foods
FOREIGN KEY (m_fcode)
REFERENCES tbl_foods(f_code);

CREATE SEQUENCE seq_myfoods   START WITH 1    INCREMENT BY 1;

CREATE VIEW view_일일섭취 AS (
SELECT
    M.m_seq 구분,
    M.m_date 날짜,
    V.식품명,
    M.m_intake 섭취량,
    V.총내용량,
    V.에너지,
    V.단백질,
    V.지방,
    V.탄수화물,
    V.총당류
FROM tbl_myfoods M
    LEFT JOIN view_식품정보 V
        ON V.식품코드 = M.m_fcode
);

INSERT INTO tbl_myfoods ( m_seq, m_date, m_fcode, m_intake )
VALUES(seq_myfoods.NEXTVAL, '2021-05-11', 'PD00092', 1);

INSERT INTO tbl_myfoods ( m_seq, m_date, m_fcode, m_intake )
VALUES(seq_myfoods.NEXTVAL, '2021-05-10', 'PD00090', 2);

commit;

 SELECT * FROM view_식품정보  WHERE 식품코드 = 'PD00113' ;
 
SELECT * FROM view_일일섭취 ORDER BY 구분;