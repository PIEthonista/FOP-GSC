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
INSERT INTO customer(c_name, c_email, c_uname, c_pswd, c_phno) VALUES('Tan Hui Xin', 'huixin@gmail.com', 'hx02', 'ronytanyikhai', '0189237564');

/* staff */
INSERT INTO staff VALUES(1,'Ang Tan Fong', 'angtf@gmail.com', 'AngTF', 'wasd', '0123456789');
INSERT INTO staff VALUES(2,'Root', 'no_email', 'root', 'qwerty', '0000000000');

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
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("rony456", "Spider-Man: No Way Home", "2022-01-18", "08:00", "01", "g14;g15;h14;h15", 4, 0, 0, "1;4;5;5;6", "2022-01-15", 141, "debit", "9087-4562-1328-5336");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("waytheking", "Spider-Man: No Way Home", "2022-01-18", "08:00", "01", "i15;i16;i17", 2, 0, 1, "1;4;8;9", "2022-01-17",102, "debit", "3067-5164-1178-5135");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("waytheking", "Spider-Man: No Way Home", "2022-01-18", "08:00", "01", "i15;i16;i17", 2, 0, 1, "1;4;8;9", "2022-01-17",102, "debit", "3067-5164-1178-5135");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("waytheking", "Spider-Man: No Way Home", "2022-01-18", "08:00", "01", "i15;i16;i17", 2, 0, 1, "1;4;8;9", "2022-01-17",102, "debit", "3067-5164-1178-5135");
INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES("waytheking", "Spider-Man: No Way Home", "2022-01-18", "08:00", "01", "i15;i16;i17", 2, 0, 1, "1;4;8;9", "2022-01-17",102, "debit", "3067-5164-1178-5135");



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

/* datetimeloc *//*                                                    1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30   31   32   33 */
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, i02, i04, i05, i10, i11, i12, i13, j05, j06, j10, j11, h04, h05, h06, h07, h08, h11, h12, f09, f10, f11, g14, g15, h14, h15, h01, h02, h03, e04, e05, e07, d12, d13) VALUES("Spider-Man: No Way Home", "2021-12-17", "08:00", "01", 80, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity, j05, j06, j07, i06, i10, i11, i12, i13, j10, j11, j12, j13, i14, j14, j15) VALUES("Spider-Man: No Way Home", "2021-12-17", "10:00", "05", 80, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity) VALUES("Spider-Man: No Way Home", "2021-12-17", "12:00", "13", 80);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity) VALUES("Spider-Man: No Way Home", "2021-12-17", "14:00", "09", 80);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity) VALUES("Spider-Man: No Way Home", "2021-12-17", "16:00", "07", 80);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity) VALUES("Spider-Man: No Way Home", "2021-12-17", "20:00", "01", 80);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity) VALUES("Spider-Man: No Way Home", "2021-12-17", "22:00", "02", 80);
INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity) VALUES("Spider-Man: No Way Home", "2021-12-17", "24:00", "06", 80);
/*
SELECT * FROM information_schema.tables WHERE TABLE_SCHEMA='FOPGSC';

DELETE FROM fnb WHERE f_name='Coca-Cola';
SELECT * FROM fnb;

 - movies ==5
 - datetimeloc ==5
 +casts
 - history every customer 3
*/
