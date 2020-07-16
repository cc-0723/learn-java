CREATE TABLE users (
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(255) NOT NULL UNIQUE,
	nickname VARCHAR(255) NOT NULL,
	password VARCHAR(64) NOT NULL
);

CREATE TABLE articles (
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT NOT NULL,
	title VARCHAR(255) NOT NULL,
	content TEXT NOT NULL
);

CREATE TABLE comments (
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT NOT NULL,
	article_id INT NOT NULL,
	content VARCHAR(200) NOT NULL
);

CREATE TABLE like_relations (
	user_id INT NOT NULL,
	article_id INT NOT NULL,
	PRIMARY KEY (user_id, article_id)
);



insert into users(username,nickname,password) values('chengpeixing','peixin',123),
													('zhoulaoshi','xiaozhou',234),
													('xiaosingdang','xiaodingdang',456);


//查询最大id
select max(id) form users;

//按照发表时间列出所有文章标题
select title from articles order by id desc;

//只显示第二页，每页三个文章
select title form articles order by id desc limit 3 offset 3;

insert into articles(user_id,title,content) values
(1,'MySql','MySql233'),
(2,'xiaodingdang','123'),
(3,'Java','Java123');
				




create table classes(
	c_id int not null, 
	c_name varchar(25)
);

create table student(
	s_id int not null unique, 
	c_name varchar(20)
);

create table teacher(
	t_id int not null, 
	t_mane varchar(20)
);

create table course(
	course_id varchar(20) not null, 
	course_name varchar(25)
);

create table schedule(
	schedule_id int not null, 
	time datetime, 
	s_id int not null,
	 t_id int not null
);

create table score(
	c_id int not null, 
	course_id varchar(20) not null, 
	score int not null
);








CREATE TABLE classes (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100)
);

CREATE TABLE students (
  id INT PRIMARY KEY AUTO_INCREMENT,
  sn VARCHAR(100) NOT NULL UNIQUE,
  class_id INT NOT NULL,
  name VARCHAR(100)
);

CREATE TABLE teachers (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100)
);

CREATE TABLE courses (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100)
);

CREATE TABLE schedules (
  id INT PRIMARY KEY AUTO_INCREMENT,
  begin_at DATETIME NOT NULL,
  course_id INT NOT NULL,
  teacher_id INT NOT NULL,
  class_id INT NOT NULL
);

CREATE TABLE exams (
  id INT PRIMARY KEY AUTO_INCREMENT,
  student_id INT NOT NULL,
  course_id INT NOT NULL,
  score double NOT NULL
);


insert into classes (name) values("01班"),("02班"),("03班"),("04班"),("05班"),("06班");

insert into students (sn, class_id, name) values (20200101, 01, "张三"),
												(20200102, 01, "张三1"),
												(20200103, 01, "张三2"),
												(20200104, 01, "张三3"),
												(20200105, 01, "张三5"),
												(20200106, 01, "张三6"),
												(20200201, 02, "李四"),
												(20200202, 02, "李四1"),
												(20200203, 02, "李四2"),
												(20200204, 02, "李四3"),
												(20200205, 02, "李四4"),
												(20200206, 02, "李四5"),
												(20200301, 03, "王五"),
												(20200302, 03, "王五1"),
												(20200303, 03, "王五2"),
												(20200304, 03, "王五3"),
												(20200305, 03, "王五4"),
												(20200401, 04, "张大山"),
												(20200402, 04, "张大山1"),
												(20200403, 04, "张大山2"),
												(20200404, 04, "张大山3");
			

insert into teachers (name) values ("张老师"),("李老师"),("王老师"),("刘老师");

insert into courses (name) values ("数据结构"),
								("软件工程"),
								("软件构造"),
								("人工智能"),
								("离散数学"),
								("大学英语");
								
insert into schedules (begin_at, course_id, teacher_id, class_id) VALUES
("2020_3_1 08:00:00", 1, 1, 01),
("2020_3_1 09:00:00", 2, 2, 02),
("2020_3_1 10:00:00", 3, 3, 03),

("2020_3_2 14:00:00", 1, 1, 01),
("2020_3_2 15:00:00", 2, 3, 02),
("2020_3_2 16:00:00", 3, 3, 03),

("2020_3_3 14:00:00", 1, 1, 01),
("2020_3_3 15:00:00", 2, 2, 02),
("2020_3_3 16:00:00", 3, 3, 03),

("2020_3_4 08:00:00", 1, 1, 01),
("2020_3_4 09:00:00", 2, 3, 02),
("2020_3_4 10:00:00", 3, 3, 03);

insert into exams (student_id, course_id, score) VALUES
(1, 1 ,80),
(1, 2, 87),
(1, 3 ,85),
(2, 1 ,60),
(2, 2 ,66),
(2, 3 ,77),
(3, 1 ,82),
(3, 2, 77),
(3, 3 ,75),
(4, 1 ,90),
(4, 2 ,96),
(4, 3 ,67);






									
												









				
						
