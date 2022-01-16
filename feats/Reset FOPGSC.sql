/*
This script will RESET the whole database to its initial form.
RUN WITH CAUTION!
*/
/*
CREATE DATABASE FOPGSC;
*/
USE FOPGSC;


DROP TABLE customer;
DROP TABLE history;
DROP TABLE staff;
DROP TABLE fnb;
DROP TABLE movies;
DROP TABLE casts;
DROP TABLE datetimeloc;

CREATE TABLE customer(
    c_id INT AUTO_INCREMENT,
    c_name VARCHAR(100) NOT NULL,
    c_email VARCHAR(50) NOT NULL,
    c_uname VARCHAR(30) UNIQUE,
    c_pswd VARCHAR(30) NOT NULL,
    c_phno VARCHAR(15) NOT NULL,
    PRIMARY KEY(c_id)
);

CREATE TABLE history(
    h_id INT AUTO_INCREMENT,
    h_uname VARCHAR(50) NOT NULL,
    h_title VARCHAR(100) NOT NULL,
    h_date VARCHAR(10) NOT NULL,
    h_time VARCHAR(5) NOT NULL,
    h_hallno VARCHAR(3) NOT NULL,
    h_seats VARCHAR(640) NOT NULL,
    adult INT NOT NULL,
    student INT NOT NULL,
    children INT NOT NULL,
    f_id VARCHAR(100) NOT NULL,
    t_datetime VARCHAR(10) NOT NULL,
    t_amount INT NOT NULL,
    t_cardtype VARCHAR(10) NOT NULL,
    t_cardnum VARCHAR(19) NOT NULL,
    PRIMARY KEY(h_id)
);

CREATE TABLE staff(
    s_id INT AUTO_INCREMENT,
    s_name VARCHAR(100) NOT NULL,
    s_email VARCHAR(50) NOT NULL,
    s_uname VARCHAR(30) UNIQUE,
    s_pswd VARCHAR(30) NOT NULL,
    s_phno VARCHAR(15) NOT NULL,
    PRIMARY KEY(s_id)
);

CREATE TABLE fnb(
    f_id INT AUTO_INCREMENT,
    f_name VARCHAR(50) UNIQUE,
    f_desc VARCHAR(150) NOT NULL,
    f_price INT NOT NULL,
    PRIMARY KEY(f_id)
);

CREATE TABLE movies(
    m_id INT AUTO_INCREMENT,
    m_title VARCHAR(100) NOT NULL,
    m_reldate VARCHAR(10) NOT NULL,
    synopsis VARCHAR(1000) NOT NULL,
    adultp INT NOT NULL,
    studentp INT NOT NULL,
    childrenp INT NOT NULL,
    PRIMARY KEY(m_id)
);

CREATE TABLE casts(
    m_id INT AUTO_INCREMENT,
    m_title VARCHAR(100) NOT NULL,
    c_name VARCHAR(100) NOT NULL,
    c_char VARCHAR(100) NOT NULL,
    PRIMARY KEY(m_id)
);

CREATE TABLE datetimeloc(
    m_id INT AUTO_INCREMENT,
    m_title VARCHAR(100) NOT NULL,
    m_date VARCHAR(10) NOT NULL,
    m_time VARCHAR(5) NOT NULL,
    m_hallno VARCHAR(3) NOT NULL,
    m_capacity INT NOT NULL,
    a01 INT NOT NULL DEFAULT 0,
    a02 INT NOT NULL DEFAULT 0,
    a03 INT NOT NULL DEFAULT 0,
    a04 INT NOT NULL DEFAULT 0,
    a05 INT NOT NULL DEFAULT 0,
    a06 INT NOT NULL DEFAULT 0,
    a07 INT NOT NULL DEFAULT 0,
    a08 INT NOT NULL DEFAULT 0,
    a09 INT NOT NULL DEFAULT 0,
    a10 INT NOT NULL DEFAULT 0,
    a11 INT NOT NULL DEFAULT 0,
    a12 INT NOT NULL DEFAULT 0,
    a13 INT NOT NULL DEFAULT 0,
    a14 INT NOT NULL DEFAULT 0,
    a15 INT NOT NULL DEFAULT 0,
    a16 INT NOT NULL DEFAULT 0,
    b01 INT NOT NULL DEFAULT 0,
    b02 INT NOT NULL DEFAULT 0,
    b03 INT NOT NULL DEFAULT 0,
    b04 INT NOT NULL DEFAULT 0,
    b05 INT NOT NULL DEFAULT 0,
    b06 INT NOT NULL DEFAULT 0,
    b07 INT NOT NULL DEFAULT 0,
    b08 INT NOT NULL DEFAULT 0,
    b09 INT NOT NULL DEFAULT 0,
    b10 INT NOT NULL DEFAULT 0,
    b11 INT NOT NULL DEFAULT 0,
    b12 INT NOT NULL DEFAULT 0,
    b13 INT NOT NULL DEFAULT 0,
    b14 INT NOT NULL DEFAULT 0,
    b15 INT NOT NULL DEFAULT 0,
    b16 INT NOT NULL DEFAULT 0,
    c01 INT NOT NULL DEFAULT 0,
    c02 INT NOT NULL DEFAULT 0,
    c03 INT NOT NULL DEFAULT 0,
    c04 INT NOT NULL DEFAULT 0,
    c05 INT NOT NULL DEFAULT 0,
    c06 INT NOT NULL DEFAULT 0,
    c07 INT NOT NULL DEFAULT 0,
    c08 INT NOT NULL DEFAULT 0,
    c09 INT NOT NULL DEFAULT 0,
    c10 INT NOT NULL DEFAULT 0,
    c11 INT NOT NULL DEFAULT 0,
    c12 INT NOT NULL DEFAULT 0,
    c13 INT NOT NULL DEFAULT 0,
    c14 INT NOT NULL DEFAULT 0,
    c15 INT NOT NULL DEFAULT 0,
    c16 INT NOT NULL DEFAULT 0,
    d01 INT NOT NULL DEFAULT 0,
    d02 INT NOT NULL DEFAULT 0,
    d03 INT NOT NULL DEFAULT 0,
    d04 INT NOT NULL DEFAULT 0,
    d05 INT NOT NULL DEFAULT 0,
    d06 INT NOT NULL DEFAULT 0,
    d07 INT NOT NULL DEFAULT 0,
    d08 INT NOT NULL DEFAULT 0,
    d09 INT NOT NULL DEFAULT 0,
    d10 INT NOT NULL DEFAULT 0,
    d11 INT NOT NULL DEFAULT 0,
    d12 INT NOT NULL DEFAULT 0,
    d13 INT NOT NULL DEFAULT 0,
    d14 INT NOT NULL DEFAULT 0,
    d15 INT NOT NULL DEFAULT 0,
    d16 INT NOT NULL DEFAULT 0,
    e01 INT NOT NULL DEFAULT 0,
    e02 INT NOT NULL DEFAULT 0,
    e03 INT NOT NULL DEFAULT 0,
    e04 INT NOT NULL DEFAULT 0,
    e05 INT NOT NULL DEFAULT 0,
    e06 INT NOT NULL DEFAULT 0,
    e07 INT NOT NULL DEFAULT 0,
    e08 INT NOT NULL DEFAULT 0,
    e09 INT NOT NULL DEFAULT 0,
    e10 INT NOT NULL DEFAULT 0,
    e11 INT NOT NULL DEFAULT 0,
    e12 INT NOT NULL DEFAULT 0,
    e13 INT NOT NULL DEFAULT 0,
    e14 INT NOT NULL DEFAULT 0,
    e15 INT NOT NULL DEFAULT 0,
    e16 INT NOT NULL DEFAULT 0,
    f01 INT NOT NULL DEFAULT 0,
    f02 INT NOT NULL DEFAULT 0,
    f03 INT NOT NULL DEFAULT 0,
    f04 INT NOT NULL DEFAULT 0,
    f05 INT NOT NULL DEFAULT 0,
    f06 INT NOT NULL DEFAULT 0,
    f07 INT NOT NULL DEFAULT 0,
    f08 INT NOT NULL DEFAULT 0,
    f09 INT NOT NULL DEFAULT 0,
    f10 INT NOT NULL DEFAULT 0,
    f11 INT NOT NULL DEFAULT 0,
    f12 INT NOT NULL DEFAULT 0,
    f13 INT NOT NULL DEFAULT 0,
    f14 INT NOT NULL DEFAULT 0,
    f15 INT NOT NULL DEFAULT 0,
    f16 INT NOT NULL DEFAULT 0,
    g01 INT NOT NULL DEFAULT 0,
    g02 INT NOT NULL DEFAULT 0,
    g03 INT NOT NULL DEFAULT 0,
    g04 INT NOT NULL DEFAULT 0,
    g05 INT NOT NULL DEFAULT 0,
    g06 INT NOT NULL DEFAULT 0,
    g07 INT NOT NULL DEFAULT 0,
    g08 INT NOT NULL DEFAULT 0,
    g09 INT NOT NULL DEFAULT 0,
    g10 INT NOT NULL DEFAULT 0,
    g11 INT NOT NULL DEFAULT 0,
    g12 INT NOT NULL DEFAULT 0,
    g13 INT NOT NULL DEFAULT 0,
    g14 INT NOT NULL DEFAULT 0,
    g15 INT NOT NULL DEFAULT 0,
    g16 INT NOT NULL DEFAULT 0,
    h01 INT NOT NULL DEFAULT 0,
    h02 INT NOT NULL DEFAULT 0,
    h03 INT NOT NULL DEFAULT 0,
    h04 INT NOT NULL DEFAULT 0,
    h05 INT NOT NULL DEFAULT 0,
    h06 INT NOT NULL DEFAULT 0,
    h07 INT NOT NULL DEFAULT 0,
    h08 INT NOT NULL DEFAULT 0,
    h09 INT NOT NULL DEFAULT 0,
    h10 INT NOT NULL DEFAULT 0,
    h11 INT NOT NULL DEFAULT 0,
    h12 INT NOT NULL DEFAULT 0,
    h13 INT NOT NULL DEFAULT 0,
    h14 INT NOT NULL DEFAULT 0,
    h15 INT NOT NULL DEFAULT 0,
    h16 INT NOT NULL DEFAULT 0,
    i01 INT NOT NULL DEFAULT 0,
    i02 INT NOT NULL DEFAULT 0,
    i03 INT NOT NULL DEFAULT 0,
    i04 INT NOT NULL DEFAULT 0,
    i05 INT NOT NULL DEFAULT 0,
    i06 INT NOT NULL DEFAULT 0,
    i07 INT NOT NULL DEFAULT 0,
    i08 INT NOT NULL DEFAULT 0,
    i09 INT NOT NULL DEFAULT 0,
    i10 INT NOT NULL DEFAULT 0,
    i11 INT NOT NULL DEFAULT 0,
    i12 INT NOT NULL DEFAULT 0,
    i13 INT NOT NULL DEFAULT 0,
    i14 INT NOT NULL DEFAULT 0,
    i15 INT NOT NULL DEFAULT 0,
    i16 INT NOT NULL DEFAULT 0,
    j01 INT NOT NULL DEFAULT 0,
    j02 INT NOT NULL DEFAULT 0,
    j03 INT NOT NULL DEFAULT 0,
    j04 INT NOT NULL DEFAULT 0,
    j05 INT NOT NULL DEFAULT 0,
    j06 INT NOT NULL DEFAULT 0,
    j07 INT NOT NULL DEFAULT 0,
    j08 INT NOT NULL DEFAULT 0,
    j09 INT NOT NULL DEFAULT 0,
    j10 INT NOT NULL DEFAULT 0,
    j11 INT NOT NULL DEFAULT 0,
    j12 INT NOT NULL DEFAULT 0,
    j13 INT NOT NULL DEFAULT 0,
    j14 INT NOT NULL DEFAULT 0,
    j15 INT NOT NULL DEFAULT 0,
    j16 INT NOT NULL DEFAULT 0,
    PRIMARY KEY(m_id)
);


/* customer */
INSERT INTO customer VALUES(1,'Goh Yi Xian', 'gohyixian456@gmail.com', 'yx123', 'qwerty', '0172613298');
INSERT INTO customer VALUES(2,'Rony Tan Yi Khai', 'ronylau123@gmail.com', 'rony456', 'wasdf', '0171234567');
INSERT INTO customer VALUES(3,'Lim Jia Yu', 'lim.jia.yu.desmond@gmail.com', 'Pyrexia02', 'jiayulim', '0179876453');
INSERT INTO customer VALUES(4,'Jesson Law Cong Ji', 'jessonlaw@gmail.com', 'Congji02', 'SingleInUM', '0123456789');
INSERT INTO customer VALUES(5,'Hing Hong Way', 'waytheking@gmail.com', 'waytheking', 'hongwayhing', '0125003181');
INSERT INTO customer VALUES(6,'Tan Hui Hui', 'tanhuihui02@gmail.com', 'huihuitan', '123456789', '0124213222');
INSERT INTO customer VALUES(7,'Jason Wong', 'jasonwong@gmail.com', 'jasonwong', 'abcdefg', '0125638556');
INSERT INTO customer VALUES(8,'Yan Yew Xuan', 'yewxuan5163@gmail.com', 'xxuan02', 'iampretty', '0126783942');
INSERT INTO customer VALUES(9,'Ng Jia Xuan', 'jiaxuan123@gmail.com', 'prettygirl', '4783623', '01184759384');
INSERT INTO customer VALUES(10,'Pua Jing Yi', 'jingyi@gmail.com', 'JingYiIsTall', 'IGot180cm', '0173294339');
INSERT INTO customer VALUES(11,'Jacqueline Tong', 'jacqueline0124@gmail.com', 'Jacqueline0124', '01240124', '0123546785');
INSERT INTO customer VALUES(12,'Muhammad Afiq', 'afiqali@gmail.com', 'MuhammadAfiq', '1234567890', '0123536745');
INSERT INTO customer VALUES(13,'Iman Nisreen', 'iman1234@gmail.com', 'Iman1234', '20120212', '0189203829');
INSERT INTO customer VALUES(14,'Najihatul Mardhiyyah', 'najihatul@hotmail.com', 'Najihal12', '20010204', '0173294339');
INSERT INTO customer VALUES(15,'Maizatul', 'maizatul@gmail.com', 'maizatul11', '19960213', '01192830483');
INSERT INTO customer VALUES(16,'Santhi Jayamalar', 'santhii@gmail.com', 'Santhi123', 'santhi12345', '0123546869');
INSERT INTO customer VALUES(17,'Kiranjeet Kaur', 'kiranjeet1010@gmail.com', 'Kiranjeet88', '888888', '01124242596');
INSERT INTO customer VALUES(18,'Shalini a/p namasivayam', 'shalini23@gmail.com', 'Shalini123', '20000817', '0123535645');
INSERT INTO customer VALUES(19,'Low May Yen', 'mayyen@gmail.com', 'may may', 'May_1124', '0197743847');
INSERT INTO customer VALUES(20,'Albert Einstein', 'Einstein@gmail.com', 'imEinstein', '12011201', '0198876253');
INSERT INTO customer VALUES(21,'George Trump', 'georgie@gmail.com', 'Georgie', 'george098', '019845553');
INSERT INTO customer VALUES(22,'Tan Boon Teik', 'tantan@gmail.com', 'tantan', 'tan1234567', '0123833253');
INSERT INTO customer VALUES(23,'Samuel Tan', 'samsam@gmail.com', 'Samuel', 'samsam123', '0132535553');
INSERT INTO customer VALUES(24,'Danny Lee', 'danny123@gmail.com', 'Danny1212', 'xxxxoooo', '0128493583');
INSERT INTO customer VALUES(25,'Lim Chen Kang', 'chenkang@gmail.com', 'ChenKang', '123456789', '0128224243');
INSERT INTO customer VALUES(26,'Low Xing Ping', 'gohyixian456@gmail.com', 'a', 'a', '0128224243');

INSERT INTO customer(c_name, c_email, c_uname, c_pswd, c_phno) VALUES('Tan Hui Xin', 'huixin@gmail.com', 'hx02', 'ronytanyikhai', '0189237564');



/* staff */
INSERT INTO staff VALUES(1,'Ang Tan Fong', 'angtf@gmail.com', 'AngTF', 'wasd', '0123456789');
INSERT INTO staff VALUES(2,'Root', 'no_email', 'root', 'qwerty', '0000000000');
INSERT INTO staff VALUES(3,'Root', 'no_email', 'a', 'a', '0000000000');

/* fnb */
INSERT INTO fnb(f_name,f_desc,f_price) VALUES('Popcorn','Delicious Caramel Popcorns!',10);
INSERT INTO fnb(f_name,f_desc,f_price) VALUES('Chips','Chrunchy chips for the go!',6);
INSERT INTO fnb(f_name,f_desc,f_price) VALUES('Ice Cream', 'Some chill ice cream to send your back freezing!', 5);
INSERT INTO fnb(f_name,f_desc,f_price) VALUES('Hotdogs', 'Grilled cheesy hotdogs warms you up', 10);
INSERT INTO fnb(f_name,f_desc,f_price) VALUES('Iced Lemon Tea','Some gas drinks to spice up your day!',3);
INSERT INTO fnb(f_name,f_desc,f_price) VALUES('Orange Juice','Some gas drinks to spice up your day!',3);
INSERT INTO fnb(f_name,f_desc,f_price) VALUES('Hundred Plus','Some gas drinks to spice up your day!',3);
INSERT INTO fnb(f_name,f_desc,f_price) VALUES('Coca-Cola','Some gas drinks to spice up your day!',3);
INSERT INTO fnb(f_name,f_desc,f_price) VALUES('Sprite', 'Some gas drinks to spice up your day!', 3);


/* history */
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Pyrexia02", "Spider-Man: No Way Home", "2022-01-18", "08:00", "01", "i10;i11;i12;i13", 3, 1, 0, "1;1;8;8;8;5", "2022-01-10", 134, "credit", "1435-4956-0984-2365");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("rony456", "Spider-Man: No Way Home", "2022-01-18", "08:00", "01", "g14;g15;h13;h14", 4, 0, 0, "1;4;5;5;6", "2022-01-11", 141, "debit", "9087-4562-1328-5336");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("waytheking", "Spider-Man: No Way Home", "2022-01-18", "08:00", "01", "i14;i15;i16", 2, 0, 1, "1;4;8;9", "2022-01-12",156, "debit", "3067-5164-1178-5135");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("waytheking", "Spider-Man: No Way Home", "2022-01-18", "09:00", "05", "g01;g02;g03;g04;g05;g06;g07", 3, 2, 2, "1;1;1;1", "2022-01-12",174, "dedit", "3067-5164-1178-5135");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("JingYiIsTall", "Spider-Man: No Way Home", "2022-01-18", "09:00", "05", "f03;f04;f05;f06;f07;f08", 3, 2, 1, "2;3;4;5", "2022-01-13",210, "credit", "1037-4154-1567-5775");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("xxuan02", "Spider-Man: No Way Home", "2022-01-18", "09:00", "05", "e05;e06;e07;e08;e09;e10", 4, 2, 0, "1;2;3;4", "2022-01-17",122, "debit", "3447-4144-5768-5665");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("may may", "Shang-Chi and the Legend of the Ten Rings", "2022-01-18", "10:00", "02", "c02;c03;c04;c05;c06;c07;c08", 4, 2, 1, "2;3;3;4", "2022-01-14",302, "debit", "8467-4874-7788-8965");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Congji02", "Shang-Chi and the Legend of the Ten Rings", "2022-01-18", "10:00", "02", "d04;d05;d06;d07;d08", 1, 3, 1, "5;6;7;8", "2022-01-14",232, "credit", "4347-1344-7468-5465");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("jasonwong", "Shang-Chi and the Legend of the Ten Rings", "2022-01-18", "10:00", "02", "e05;e06;e07;e08;e09;e10", 2, 2, 2, "3;3;3;3", "2022-01-15",124, "credit", "5545-4555-5878-6605");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Iman1234", "Shang-Chi and the Legend of the Ten Rings", "2022-01-18", "11:00", "04", "a02;a03;a04;a05;a06", 3, 2, 0, "4;4;5;6", "2022-01-16",143, "debit", "3754-4154-5658-5655");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Kiranjeet88", "Shang-Chi and the Legend of the Ten Rings", "2022-01-18", "11:00", "04", "g02;g03;g04;g05;g06;g07", 3, 3, 0, "5;5;5;6", "2022-01-17",102, "debit", "3546-6154-6658-6655");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("imEinstein", "Shang-Chi and the Legend of the Ten Rings", "2022-01-18", "11:00", "04", "f07;f08;f09;f10;f11", 5, 0, 0, "1;1;1", "2022-01-18",202, "debit", "8654-4847-5705-5005");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("prettygirl", "Shang-Chi and the Legend of the Ten Rings", "2022-01-18", "11:00", "04", "e01;e02;e03;e04;e05", 5, 0, 0, "2;2;3;3", "2022-01-18",235, "credit", "3722-4190-5609-0505");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Jacqueline0124", "Avengers: Endgame", "2022-01-18", "12:00", "03", "d01;d02;d03;d04;d05;d06;d07;d08", 2, 0, 6, "1;1;1;1;1", "2022-01-10",212, "credit", "1722-4198-8689-8985");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("huihuitan", "Avengers: Endgame", "2022-01-18", "12:00", "03", "f07;f08;f09;f10;f11;f12;f13", 5, 2, 0, "2;2;2;2", "2022-01-09",210, "debit", "3766-6980-8608-4035");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("maizatul11", "Avengers: Endgame", "2022-01-18", "12:00", "03", "e01;e02;e03;e04;e05", 5, 0, 0, "2;2;3;3", "2022-01-13",231, "debit", "4522-4240-3469-9857");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("hx02", "Avengers: Endgame", "2022-01-18", "13:00", "06", "e10;e11;e12;e13;e14;e15", 5, 1, 0, "5;6;7;8", "2022-01-15",214, "credit", "6522-4570-6666-3574");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("rony456", "Avengers: Endgame", "2022-01-18", "13:00", "06", "h11;h12;h13;h14;h15", 5, 0, 0, "1;2;5;6", "2022-01-14",217, "debit", "3732-4220-5229-0345");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Shalini123", "Avengers: Endgame", "2022-01-18", "13:00", "06", "f11;f12;f13;h07;h08", 1, 4, 0, "1;1;1", "2022-01-16",148, "credit", "3322-4490-4093-3305");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Najihal12", "Mulan", "2022-01-18", "14:00", "07", "a09;a10;a11;a12;a13;a14;a15", 5, 2, 0, "4;5;6;7", "2022-01-12",198, "credit", "7623-4330-2639-1105");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("xxuan02", "Mulan", "2022-01-18", "14:00", "07", "c03;c04;c05;c06;c07;c08;c09;c10", 3, 2, 3, "2;2;3;3", "2022-01-13",142, "debit", "5286-4278-2657-1575");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("prettygirl", "Mulan", "2022-01-18", "14:00", "07", "g03;g04;g05;g06;h03;h04;h05;h06", 3, 3, 2, "2;3;7;8;3", "2022-01-12",165, "debit", "6722-4277-8729-8815");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("waytheking", "Mulan", "2022-01-18", "15:00", "08", "e13;e14;e15;e16;f07;f08;f09;f10", 3, 3, 2, "1;1;6;7;3", "2022-01-13",289, "credit", "1257-4275-4629-8615");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Congji02", "Mulan", "2022-01-18", "15:00", "08", "c13;c14;c15;a06;a07", 3, 2, 0, "1;1;1;4;3", "2022-01-15",232, "debit", "7652-8592-8629-7775");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Iman1234", "Mulan", "2022-01-18", "15:00", "08", "d02;d03;e05;e06;e07;e08;e09;e10", 4, 4, 0, "3;4;5;3", "2022-01-15",213, "debit", "7522-7592-5669-5165");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Georgie", "Train to Busan", "2022-01-18", "16:00", "06", "h03;h04;h05;h06;h07;h08;h09;h10", 3, 3, 1, "6;7;8;3", "2022-01-11",192, "credit", "1562-6980-3454-1535");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("jasonwong", "Train to Busan", "2022-01-18", "16:00", "06", "a03;a04;a05;a06;a07;a08;a09", 2, 2, 3, "1;3;5;3", "2022-01-16",122, "debit", "7652-4267-2679-1165");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("tantan", "Train to Busan", "2022-01-18", "16:00", "06", "f03;f04;f05;f06;f07;f08;f09;f10", 3, 2, 3, "1;1;4;6;3", "2022-01-13",212, "credit", "1562-4444-2654-2345");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Samuel", "Train to Busan", "2022-01-18", "17:00", "09", "c13;c14;c15", 3, 0, 0, "1;1;1;2;3", "2022-01-12",98, "credit", "5622-2452-5629-3155");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("JingYiIsTall", "Train to Busan", "2022-01-18", "17:00", "09", "c03;c04;c05;c06;c07", 3, 2, 0, "2;3;7;7;3", "2022-01-16",102, "debit", "3462-5393-5649-5545");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("MuhammadAfiq", "Train to Busan", "2022-01-18", "17:00", "09", "d03;d04;d05;d06;d07;d08;d09;d10", 8, 0, 0, "4;5;6;3", "2022-01-17",202, "credit", "2422-2222-2667-8165");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("waytheking", "Aladdin", "2022-01-18", "18:00", "10", "d09;d10", 2, 0, 0, "4;3;6;8", "2022-01-15",152, "credit", "2020-2202-2607-0100");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("hx02", "Aladdin", "2022-01-18", "18:00", "10", "d03;d04;d05;d06", 4, 0, 0, "5;3;2;1", "2022-01-12",182, "debit", "9492-2922-2997-8999");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("imEinstein", "Aladdin", "2022-01-18", "18:00", "10", "f01;f02;f03;f04", 2, 2, 0, "3;2;6;1", "2022-01-14",212, "credit", "9929-2928-2878-8186");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("jasonwong", "Aladdin", "2022-01-18", "19:00", "01", "e01;e02;e03;e04;e05", 5, 0, 0, "1;5;1;4", "2022-01-13",213, "debit", "8292-9262-7687-9175");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Shalini123", "Aladdin", "2022-01-18", "19:00", "01", "d03;d04;d05", 3, 0, 0, "2;2;6;2", "2022-01-15",102, "credit", "2920-8928-7887-7175");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("MuhammadAfiq", "Aladdin", "2022-01-18", "19:00", "01", "c03;c04", 2, 0, 0, "1;4;6;4", "2022-01-16",133, "debit", "1202-0782-2897-9105");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("prettygirl", "Polis Evo", "2022-01-18", "20:00", "03", "b02;b03", 2, 0, 0, "3;1", "2022-01-17",124, "credit", "2492-8978-5677-6195");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("xxuan02", "Polis Evo", "2022-01-18", "20:00", "03", "a03;a04;a05;a06;a07;a08;a09", 7, 0, 0, "3", "2022-01-09",162, "debit", "5626-6782-9877-9185");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("MuhammadAfiq", "Polis Evo", "2022-01-18", "20:00", "03", "d09;d10", 2, 0, 0, "4;5;6;1", "2022-01-14",132, "credit", "8948-4568-2998-8960");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Iman1234", "Polis Evo", "2022-01-18", "21:00", "02", "d03;d04;d05;d06;d07", 5, 0, 0, "4;5;2;1", "2022-01-17",156, "debit", "8462-8282-5665-6005");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("rony456", "Polis Evo", "2022-01-18", "21:00", "02", "h02;h03;h04", 3, 0, 0, "2;3;3;3", "2022-01-16",102, "debit", "9426-6227-2608-8198");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("rony456", "Polis Evo", "2022-01-18", "21:00", "02", "f01;f02;f03;f04", 4, 0, 0, "4;5;5;6;3", "2022-01-18",172, "credit", "2222-7556-7768-8888");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("hx02", "Till We Meet Again", "2022-01-19", "09:00", "01", "e02;e03;e04;e05;e06", 5, 0, 0, "1;1;1", "2022-01-15",146, "credit", "8628-7765-7565-6505");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("jasonwong", "Till We Meet Again", "2022-01-19", "09:00", "01", "c03;c04;c05;c06;c07", 3, 2, 0, "4", "2022-01-14",121, "credit", "7052-3542-5757-6605");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("xxuan02", "Till We Meet Again", "2022-01-19", "09:00", "01", "h01;h02;h03;h04", 4, 0, 0, "4;5", "2022-01-13",132, "debit", "0620-7060-7007-8005");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("imEinstein", "Till We Meet Again", "2022-01-19", "10:00", "02", "d03;d04;d05;d09;d10", 3, 2, 0, "2;3;4", "2022-01-12",124, "debit", "3602-0502-7707-0105");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Pyrexia02", "Till We Meet Again", "2022-01-19", "10:00", "02", "c03;c04;c05;c06;c07", 5, 0, 0, "5", "2022-01-16",132, "credit", "7332-3363-7363-3135");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("waytheking", "Till We Meet Again", "2022-01-19", "10:00", "02", "b03;b04;b05;b06;b07", 3, 2, 0, "4", "2022-01-15",89, "debit", "3442-2542-2747-2145");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("rony456", "Hi, Mom", "2022-01-19", "11:00", "05", "a03;a04;a05;a06;a07;a08;a09;a10", 8, 0, 0, "3", "2022-01-14",318, "debit", "7121-1512-1222-2102");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("tanhuihui", "Hi, Mom", "2022-01-19", "11:00", "05", "d03;d04;d05;d06", 2, 2, 0, "2", "2022-01-14",212, "debit", "4652-5563-3447-4404");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("prettygirl", "Hi, Mom", "2022-01-19", "11:00", "05", "d13;d14;d15;e11;e12;e13;e14;e15", 5, 3, 0, "1", "2022-01-18",108, "credit", "3623-7363-7327-8225");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("JingYiIsTall", "Hi, Mom", "2022-01-19", "12:00", "04", "f03;f04;f05;f06;f07;f08;f09", 3, 2, 2, "1;5;6", "2022-01-12",232, "debit", "3324-4542-2747-4133");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Jacqueline0124", "Hi, Mom", "2022-01-19", "12:00", "04", "e05;e06;e07;e08;e09;e10", 5, 0, 0, "4;5;5;6", "2022-01-12",178, "debit", "7542-7353-7231-3345");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("may may", "Hi, Mom", "2022-01-19", "12:00", "04", "b03;b04;b05;b06", 2, 2, 0, "3;3;3", "2022-01-16",180, "debit", "1022-8372-3937-9405");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Najihal12", "Olabola", "2022-01-19", "13:00", "03", "e13;e14;e15;e06;e07;e08;e09;e10", 6, 2, 0, "4;5;3", "2022-01-11",314, "debit", "4102-0302-0707-4995");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("may may", "Olabola", "2022-01-19", "13:00", "03", "c07;c08;c09;c10", 2, 2, 0, "1;1;1;3", "2022-01-14",154, "credit", "9152-7332-9737-3909");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("rony456", "Olabola", "2022-01-19", "13:00", "03", "b03;b04;b05;b06;b07", 3, 2, 0, "1;1", "2022-01-13",157, "debit", "8188-7652-4534-2245");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("ChenKang", "Olabola", "2022-01-19", "14:00", "06", "e03;e04;e05;e06;e07;e08;e09;e10", 6, 2, 0, "4;5", "2022-01-12",272, "credit", "4646-7275-3778-2025");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("prettygirl", "Olabola", "2022-01-19", "14:00", "06", "a03;a04;a05;a06", 2, 2, 0, "3;6;7", "2022-01-14",103, "debit", "7467-7776-3434-3677");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Georgie", "Olabola", "2022-01-19", "14:00", "06", "f03;f04;f05;f06;f07;f08;f09;f10", 4, 4, 0, "6", "2022-01-13",202, "credit", "9022-3532-5367-3775");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("MuhammadAfiq", "Your Name", "2022-01-19", "15:00", "08", "c07;c08;c09;c10", 2, 2, 0, "4;6", "2022-01-14",132, "debit", "9192-9338-7797-3909");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("waytheking", "Your Name", "2022-01-19", "15:00", "08", "b03;b04;b05;b06", 2, 2, 0, "4;3", "2022-01-16",92, "debit", "1192-3332-3536-7488");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("xxuan02", "Your Name", "2022-01-19", "15:00", "08", "d03;d04;d05;d06;d07;d08;d09;d10", 5, 3, 0, "4;5;3", "2022-01-11",132, "debit", "1292-8382-8787-7477");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("hx02", "Your Name", "2022-01-19", "16:00", "07", "a07;a08;a09;a10", 2, 2, 0, "3;4", "2022-01-01",112, "credit", "6172-8932-7557-7455");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("may may", "Your Name", "2022-01-19", "16:00", "07", "b03;b04;b05;b06", 2, 2, 0, "1;2;3", "2022-01-13",104, "debit", "1177-4472-4754-5635");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("Danny1212", "Your Name", "2022-01-19", "16:00", "07", "c07;c08;c09;c10", 4, 0, 0, "1;1", "2022-01-12",114, "credit", "5132-3334-4734-3606");






/* movies */
INSERT INTO movies(m_title, m_reldate, synopsis, adultp, studentp, childrenp) VALUES("Spider-Man: No Way Home", "2021-12-17", "With Spider-Man's identity now revealed, Peter asks Doctor Strange for help. When a spell goes wrong, dangerous foes from other worlds start to appear, forcing Peter to discover what it truly means to be Spider-Man.", 28, 18, 20);
INSERT INTO movies(m_title, m_reldate, synopsis, adultp, studentp, childrenp) VALUES("Shang-Chi and the Legend of the Ten Rings", "2021-11-17", "Martial-arts master Shang-Chi confronts the past he thought he left behind when he's drawn into the web of the mysterious Ten Rings organization.", 28, 18, 20);
INSERT INTO movies(m_title, m_reldate, synopsis, adultp, studentp, childrenp) VALUES("Avengers: Endgame", "2021-12-23", "After Thanos, an intergalactic warlord, disintegrates half of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced allies and restore balance.", 28, 18, 20);
INSERT INTO movies(m_title, m_reldate, synopsis, adultp, studentp, childrenp) VALUES("Mulan", "2021-11-03", "A girl disguises as a male warrior and joins the imperial army in order to prevent her sick father from being forced to enlist as he has no male heir.", 28, 18, 20);
INSERT INTO movies(m_title, m_reldate, synopsis, adultp, studentp, childrenp) VALUES("Train to Busan", "2021-09-12", "Seok-woo and his daughter are on a train to Busan on the latter's birthday to see his wife. However, the journey turns into a nightmare when they are trapped amidst a zombie outbreak in South Korea.", 28, 18, 20);
INSERT INTO movies(m_title, m_reldate, synopsis, adultp, studentp, childrenp) VALUES("Aladdin", "2022-01-07", "Aladdin, a kind thief, woos Jasmine, the princess of Agrabah, with the help of Genie. When Jafar, the grand vizier, tries to usurp the king, Jasmine, Aladdin and Genie must stop him from succeeding.", 28, 18, 20);
INSERT INTO movies(m_title, m_reldate, synopsis, adultp, studentp, childrenp) VALUES("Polis Evo", "2021-10-23", "In Pahang, a shootout occurs between the Malaysian police and terrorist members of al-Minas. The shooting ends with the leader of al-Minas being heavily injured, while his brother Saif Hasyam, escapes and vowing revenge.", 28, 18, 20);
INSERT INTO movies(m_title, m_reldate, synopsis, adultp, studentp, childrenp) VALUES("Till We Meet Again", "2021-12-24", "The story of Ah Lun, who is struck dead by lightning, and loses his memory of his previous life. While taking on the job of the god of love with Pinky — binding couples together with red strings.", 28, 18, 20);
INSERT INTO movies(m_title, m_reldate, synopsis, adultp, studentp, childrenp) VALUES("Hi, Mom", "2021-10-22", "After her mother Li Huanying is fatally injured in a car accident in 2001, grief-stricken Jia Xiaoling finds herself transported back in time to the year 1981, where she becomes her mother's close friend.", 28, 18, 20);
INSERT INTO movies(m_title, m_reldate, synopsis, adultp, studentp, childrenp) VALUES("Olabola", "2021-10-15", "The film was inspired by the glories of the Malaysia national football team which successfully entered the 1980 Summer Olympics.", 28, 18, 20);
INSERT INTO movies(m_title, m_reldate, synopsis, adultp, studentp, childrenp) VALUES("Your Name", "2022-01-01", "Two teenagers share a profound, magical connection upon discovering they are swapping bodies. Things manage to become even more complicated when the boy and girl decide to meet in person.", 28, 18, 20);

/* casts */
INSERT INTO casts(m_title, c_name, c_char) VALUES("Spider-Man: No Way Home", "Tom Holland", "Peter Parker");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Spider-Man: No Way Home", "Zendaya", "Michelle MJ Jones");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Spider-Man: No Way Home", "Alfred Molina", "Dr. Otto Octavius");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Spider-Man: No Way Home", "Jacob Batalon", "Ned Leeds");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Spider-Man: No Way Home", "Jamie Foxx", "Electro");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Spider-Man: No Way Home", "Marisa Tomei", "Aunt May");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Spider-Man: No Way Home", "Tony Revolori", "Flash Thompson");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Spider-Man: No Way Home", "Benedict Cumberbatch", "Norman Osborn");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Spider-Man: No Way Home", "Benedict Wong", "Wong");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Shang-Chi and the Legend of the Ten Rings", "Simu Liu", "Xu Shang-Chi");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Shang-Chi and the Legend of the Ten Rings", "Awkwafina", "Katy");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Shang-Chi and the Legend of the Ten Rings", "Meng'er Zhang", "Xu Xialing");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Shang-Chi and the Legend of the Ten Rings", "Tony Leung", "Xu Wenwu");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Shang-Chi and the Legend of the Ten Rings", "Fala Chen", "Ying Li");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Avengers: Endgame", "Robert Downey Jr.", "Iron man");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Avengers: Endgame", "Chris Evans", "Captain America");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Avengers: Endgame", "Mark Ruffalo", "Hulk");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Avengers: Endgame", "Chris Hemsworth", "Thor");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Avengers: Endgame", "Scarlett Johansson", "Black Widow");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Mulan", "Yifei Liu", "Mulan");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Mulan", "Donnie Yen", "Commander Tung");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Mulan", "Tzi Ma", "Hua Zhou");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Mulan", "Yoson An", "Chen Honghui");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Mulan", "Gong Li", "Xianniang");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Train to Busan", "Gong Yoo", "Seok-woo");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Train to Busan", "Kim Su-an", "Su-an");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Train to Busan", "Ma Dong-seok", "Yoon Sang-hwa");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Train to Busan", "Jung Yu-mi", "Seong-kyeong");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Train to Busan", "Choi Woo-shik", "Min Yong-gu");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Aladdin", "Mena Massoud", "Aladdin");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Aladdin", "Will Smith", "Genie");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Aladdin", "Naomi Scott", "Jasmine");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Aladdin", "Marwan Kenzari", "Jafar");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Aladdin", "Navid Negahban", "The Sultan");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Polis Evo", "Shaheizy Sam", "Inspector Khai");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Polis Evo", "Zizan Razak", "Inspector Sani");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Polis Evo", "Raline Shah", "Rian");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Polis Evo", "Mike Lucock", "Najr");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Till We Meet Again", "Ko Chen‑tung", "Ah Lun");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Till We Meet Again", "Gingle Wang", "Pinky");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Till We Meet Again", "Vivian Sung", "Xiao Mi");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Till We Meet Again", "Umin Boya", "Ghost Head");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Till We Meet Again", "Marcus Chang", "Xiao Mi's friend");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Hi, Mom", "Jia Ling", "Jia Xiaoling");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Hi, Mom", "Shen Teng", "Shen Guanglin");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Hi, Mom", "Zhang Xiaofei", "Li Huanying");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Hi, Mom", "Chen He", "Leng Te");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Hi, Mom", "Ding Jiali", "Bao Yumei");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Olabola", "JC Chee", "Chow Kwok Keong");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Olabola", "Muhd Luqman Hafidz bin Mohd Fauzi", "Ahmad Ali");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Olabola", "Sarankumar A/L Manokaran", "Muthu Kumar");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Olabola", "Bront Palarae", "Rahman");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Olabola", "Marianne Tan Poh Yee", "Marianne");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Your Name", "Ryunosuke Kamiki", "Taki Tachibana");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Your Name", "Mone Kamishiraishi", "Mitsuha Miyamizu");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Your Name", "Ryo Narita", "Katsuhiko");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Your Name", "Aoi Yūki", "Sayaka Natori");
INSERT INTO casts(m_title, c_name, c_char) VALUES("Your Name", "Nobunaga Shimazaki", "Tsukasa Fujii");



/* datetimeloc *//*                                                    1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30   31   32  */
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, i10, i11, i12, i13, g14, g15, h13, h14, i14, i15, i16) VALUES("Spider-Man: No Way Home", "2022-01-18", "08:00", "01", 80, 1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, g01, g02, g03, g04, g05, g06, g07, f03, f04, f05, f06, f07, f08, e05, e06, e07, e08, e09, e10) VALUES("Spider-Man: No Way Home", "2022-01-18", "09:00", "05", 80, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, c02, c03, c04, c05, c06, c07, c08, d04, d05, d06, d07, d08, e05, e06, e07, e08, e09, e10)VALUES("Shang-Chi and the Legend of the Ten Rings", "2022-01-18", "10:00", "02", 80,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, a02, a03, a04, a05, a06, g02, g03, g04, g05, g06, g07, f07, f08, f09, f10, f11, e01, e02, e03, e04, e05)VALUES("Shang-Chi and the Legend of the Ten Rings", "2022-01-18", "11:00", "04", 80,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, d01, d02, d03, d04, d05, d06, d07, d08, f07, f08, f09, f10, f11, f12, f13, e01, e02, e03, e04, e05) VALUES("Avengers: Endgame", "2022-01-18", "12:00", "03", 80,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, e10, e11, e12, e13, e14, e15, h11, h12, h13, h14, h15, f11, f12, f13, h07, h08)VALUES("Avengers: Endgame", "2022-01-18", "13:00", "06", 80, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, a09, a10, a11, a12, a13, a14, a15, c03, c04, c05, c06, c07, c08, c09, c10, g03, g04, g05, g06, h03, h04, h05, h06) VALUES("Mulan", "2022-01-18", "14:00", "07", 80,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, e13, e14, e15, e16, f07, f08, f09, f10, c13, c14, c15, a06, a07, d02, d03, e05, e06, e07, e08, e09, e10) VALUES("Mulan", "2022-01-18", "15:00", "08", 80, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, h03, h04, h05, h06, h07, h08, h09, h10, a03, a04, a05, a06, a07, a08, a09, f03, f04, f05, f06, f07, f08, f09, f10) VALUES("Train to Busan", "2022-01-18", "16:00", "06", 80, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, c13, c14, c15, c03, c04, c05, c06, c07, d03, d04, d05, d06, d07, d08, d09, d10) VALUES("Train to Busan", "2022-01-18", "17:00", "09", 80, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, d09, d10, d03, d04, d05, d06, f01, f02, f03, f04) VALUES("Aladdin", "2022-01-18", "18:00", "10", 80,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, e01, e02, e03, e04, e05, d03, d04, d05, c03, c04) VALUES("Aladdin", "2022-01-18", "19:00", "01", 80,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, b02, b03, a03, a04, a05, a06, a07, a08, a09, d09, d10) VALUES("Polis Evo", "2022-01-18", "20:00", "03", 80,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, h02, h03, h04, f01, f02, f03, f04, d03, d04, d05, d06, d07) VALUES("Polis Evo", "2022-01-18", "21:00", "02", 80,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, e02, e03, e04, e05, e06, c03, c04, c05, c06, c07, h01, h02, h03, h04) VALUES("Till We Meet Again", "2022-01-19", "09:00", "01", 80,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, d03, d04, d05, d09, d10, c03, c04, c05, c06, c07, b03, b04, b05, b06, b07) VALUES("Till We Meet Again", "2022-01-19", "10:00", "02", 80,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, a03, a04, a05, a06, a07, a08, a09, a10, d03, d04, d05, d06, d13, d14, d15, e11, e12, e13, e14, e15) VALUES("Hi, Mom", "2022-01-19", "11:00", "05", 80,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, f03, f04, f05, f06, f07, f08, f09, e05, e06, e07, e08, e09, e10, b03, b04, b05, b06) VALUES("Hi, Mom", "2022-01-19", "12:00", "04", 80,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, e13, e14, e15, e06, e07, e08, e09, e10, c07, c08, c09, c10, b03, b04, b05, b06, b07) VALUES("Olabola", "2022-01-19", "13:00", "03", 80, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, e03, e04, e05, e06, e07, e08, e09, e10, a03, a04, a05, a06, f03, f04, f05, f06, f07, f08, f09, f10) VALUES("Olabola", "2022-01-19", "14:00", "06", 80,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, c07, c08, c09, c10, b03, b04, b05, b06, d03, d04, d05, d06, d07, d08, d09, d10) VALUES("Your Name", "2022-01-19", "15:00", "08", 80, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, a07, a08, a09, a10, b03, b04, b05, b06, c07, c08, c09, c10) VALUES("Your Name", "2022-01-19", "16:00", "07", 80, 1,1,1,1,1,1,1,1,1,1,1,1);


SELECT * FROM casts;
SELECT * FROM datetimeloc;
SELECT * FROM movies;
/*
SELECT * FROM information_schema.tables WHERE TABLE_SCHEMA='FOPGSC';

DELETE FROM fnb WHERE f_name='Coca-Cola';
SELECT * FROM fnb;

 - movies ==5
 - datetimeloc ==5
 +casts
 - history every customer 3
*/
