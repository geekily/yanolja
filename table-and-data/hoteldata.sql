DROP TABLE MANAGER PURGE;
DROP TABLE USERHISTORY PURGE;
DROP TABLE RESERVATION PURGE;
DROP TABLE USERGRADE PURGE;
DROP TABLE USERDB PURGE;
DROP TABLE HOTELROOM PURGE;
DROP TABLE HOTEL PURGE;

CREATE TABLE USERDB
(USERID VARCHAR2(10) CONSTRAINT USERDB_USERID_PK PRIMARY KEY,
PWD VARCHAR2(10) CONSTRAINT USERDB_PWD_NN NOT NULL,
USERNAME VARCHAR2(10) CONSTRAINT USERDB_USERNAME_NN NOT NULL,
AGE NUMBER(3) CONSTRAINT USERDB_AGE_NN NOT NULL,
SEX CHAR(2) CONSTRAINT USERDB_SEX_CK CHECK (SEX IN ('M','W') AND SEX IS NOT NULL),
COUNTRY VARCHAR2(20) CONSTRAINT USERDB_COUNTRY_NN NOT NULL,
CITY VARCHAR2(20) CONSTRAINT USERDB_CITY_NN NOT NULL,
EMAIL VARCHAR2(20) CONSTRAINT USERDB_EMAIL_NN NOT NULL,
REGDATE DATE CONSTRAINT USERDB_REGDATE_NN NOT NULL,
TEL VARCHAR2(15) CONSTRAINT USERDB_TEL_NN NOT NULL);

INSERT INTO USERDB VALUES('MISSA','BADGIRL','SUZI','26','W','KOREA','SEOUL','SUZI@GOOGLE.COM',SYSDATE,'010-2546-5678');

CREATE TABLE HOTEL
(HOTELCODE VARCHAR2(10) CONSTRAINT HOTEL_HOTELCODE_PK PRIMARY KEY,
HOTELNAME VARCHAR2(10) CONSTRAINT HOTEL_HOTELNAME_NN NOT NULL,
HOTELCLASS CHAR(2) CONSTRAINT HOTEL_HOTELCLASS_CK CHECK (HOTELCLASS BETWEEN 1 AND 5 AND HOTELCLASS IS NOT NULL),
OWNER VARCHAR2(10) CONSTRAINT HOTEL_OWNER_NN NOT NULL,
COUNTRY VARCHAR2(10) CONSTRAINT HOTEL_COUNTRY_NN NOT NULL,
CITY VARCHAR2(10) CONSTRAINT HOTEL_CITY_NN NOT NULL);

INSERT INTO HOTEL VALUES('KOR100','GRAND','5','LEE','KOREA','SEOUL');
INSERT INTO HOTEL VALUES('KOR101','YANOLJA','4','PARK','KOREA','SEOUL');
INSERT INTO HOTEL VALUES('KOR102','DESUNG','3','KIM','KOREA','SEOUL');
INSERT INTO HOTEL VALUES('KOR103','JAVA','2','LEE','KOREA','SEOUL');
INSERT INTO HOTEL VALUES('KOR104','HANBIT','1','DAVID','KOREA','SEOUL');
INSERT INTO HOTEL VALUES('KOR105','ACE','5','LIM','KOREA','BUSAN');
INSERT INTO HOTEL VALUES('KOR106','HEUN','4','LISA','KOREA','BUSAN');
INSERT INTO HOTEL VALUES('KOR107','SQL','3','JANG','KOREA','DEJEON');
INSERT INTO HOTEL VALUES('KOR108','LOTTE','5','JUNG','KOREA','INCHEON');
INSERT INTO HOTEL VALUES('JAP100','LOTTEJAPAN','5','NAKAMURA','JAPAN','OSAKA');
INSERT INTO HOTEL VALUES('JAP101','SINRA','4','DOYOTOMI','JAPAN','OSAKA');
INSERT INTO HOTEL VALUES('JAP102','FOREVER','5','KIMITOMU','JAPAN','DOKYO');
INSERT INTO HOTEL VALUES('JAP103','ILOVEU','1','JOHN','JAPAN','DOKYO');
INSERT INTO HOTEL VALUES('TWN102','NICHANG','5','XIAN','TAIWAN','TAIPEI');
INSERT INTO HOTEL VALUES('TWN103','XIONCHU','3','NIHAO','TAIWAN','TAIPEI');

CREATE TABLE HOTELROOM
(HOTELCODE VARCHAR2(10) CONSTRAINT HOTELROOM_HOTELCODE_NN NOT NULL,
ROOMNAME VARCHAR2(10) CONSTRAINT HOTELROOM_ROOMNAME_NN NOT NULL,
PRICE NUMBER(5) CONSTRAINT HOTELROOM_PRICE_NN NOT NULL,
CONSTRAINT HOTELROOM_HOTELCODE_FK FOREIGN KEY(HOTELCODE) REFERENCES HOTEL(HOTELCODE));

INSERT INTO HOTELROOM VALUES('KOR100','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('KOR100','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('KOR100','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('KOR100','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('KOR101','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('KOR101','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('KOR101','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('KOR101','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('KOR102','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('KOR102','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('KOR102','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('KOR102','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('KOR103','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('KOR103','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('KOR103','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('KOR103','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('KOR104','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('KOR104','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('KOR104','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('KOR104','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('KOR105','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('KOR105','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('KOR105','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('KOR105','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('KOR106','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('KOR106','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('KOR106','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('KOR106','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('KOR107','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('KOR107','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('KOR107','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('KOR107','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('KOR108','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('KOR108','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('KOR108','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('KOR108','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('JAP100','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('JAP100','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('JAP100','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('JAP100','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('JAP101','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('JAP101','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('JAP101','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('JAP101','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('JAP102','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('JAP102','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('JAP102','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('JAP102','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('JAP103','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('JAP103','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('JAP103','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('JAP103','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('TWN102','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('TWN102','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('TWN102','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('TWN102','BUSINESS','2000');

INSERT INTO HOTELROOM VALUES('TWN103','LUXURY','4000');
INSERT INTO HOTELROOM VALUES('TWN103','SUPERIOR','3000');
INSERT INTO HOTELROOM VALUES('TWN103','FAMILY','2000');
INSERT INTO HOTELROOM VALUES('TWN103','BUSINESS','2000');

CREATE TABLE RESERVATION
(USERID VARCHAR2(10) CONSTRAINT RESERVATION_USERID_NN NOT NULL,
HOTELCODE VARCHAR2(10) CONSTRAINT RESERVATION_HOTELCODE_NN NOT NULL,
ROOMNAME VARCHAR2(10) CONSTRAINT RESERVATION_ROOMNAME_NN NOT NULL,
CHECKIN DATE CONSTRAINT RESERVATION_CHECKIN_NN NOT NULL,
CHECKOUT DATE CONSTRAINT RESERVATION_CHECKOUT_NN NOT NULL,
RESDATE DATE CONSTRAINT RESERVATION_RESDATE_NN NOT NULL,
CONSTRAINT RESERVATION_USERID_FK FOREIGN KEY(USERID) REFERENCES USERDB(USERID),
CONSTRAINT RESERVATION_HOTELCODE_FK FOREIGN KEY(HOTELCODE) REFERENCES HOTEL(HOTELCODE));

CREATE TABLE USERHISTORY
(USERID VARCHAR2(10) CONSTRAINT USERHISTORY_USERID_NN NOT NULL,
HOTELCODE VARCHAR2(10) CONSTRAINT USERHISTORY_HOTELCODE_NN NOT NULL,
CHECKIN DATE CONSTRAINT USERHISTORY_CHECKIN_NN NOT NULL,
CHECKOUT DATE CONSTRAINT USERHISTORY_CHECKOUT_NN NOT NULL,
TOTALEXP NUMBER(10) CONSTRAINT USERHISTORY_TOTALEXP_NN NOT NULL,
CONSTRAINT USERHISTORY_USERID_FK FOREIGN KEY(USERID) REFERENCES USERDB(USERID),
CONSTRAINT USERHISTORY_HOTELCODE_FK FOREIGN KEY(HOTELCODE) REFERENCES HOTEL(HOTELCODE));

CREATE TABLE USERGRADE
(GRADE VARCHAR2(10) CONSTRAINT USERGRADE_GRADE_PK PRIMARY KEY,
LOWEXP NUMBER(10) CONSTRAINT USERGRADE_LOWEXP_NN NOT NULL,
HIGHEXP NUMBER(10) CONSTRAINT USERGRADE_HIGHEXP_NN NOT NULL);

INSERT INTO USERGRADE VALUES('A',50000,1000000000);
INSERT INTO USERGRADE VALUES('B',30000,49999);
INSERT INTO USERGRADE VALUES('C',10000,29999);
INSERT INTO USERGRADE VALUES('D',5000,100000);
INSERT INTO USERGRADE VALUES('E',0,4999);

CREATE TABLE MANAGER
(USERID VARCHAR2(10),
PWD VARCHAR2(10));

INSERT INTO MANAGER VALUES('MANAGER','MANAGER');
INSERT INTO MANAGER VALUES('manager','manager');

COMMIT;
/