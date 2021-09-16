show databases ;
use test_db;
create table if not exists tb_empl
(
    id int(11),
    name varchar(25),
    deptId int(11),
    salary float
);

show tables ;

use test;

alter table students rename tb_student_info;

show tables ;

desc tb_student_info;

show create table tb_student_info;

alter table tb_student_info character set gb2312 default collate gb2312_chinese_ci;

use test_db;

describe tb_empl;

alter table tb_empl
add col1 varchar(11) first ;

alter table tb_empl
change col1 col3 varchar(30);

alter table tb_empl
modify name varchar(30);

alter table tb_empl
add col2 varchar(11) after name;

describe tb_empl;

alter table tb_empl
drop col2;

use test_db;

create table tb_emp3
(
    id int(11),
    name varchar(25),
    deptId int(11),
    salary float
);

show tables ;

drop table tb_emp3;

show tables ;

create table tb_emp4
(
    id int(11) primary key ,
    name varchar(22),
    location varchar(50)
);

create table tb_emp5
(
    id int(11) primary key ,
    name varchar(25),
    deptId int(11),
    salary float,
    constraint fk_emp4_emp5 foreign key (deptId) references tb_emp4(id)
);

show create table tb_emp5;

drop table tb_emp4;

alter table tb_emp5 drop foreign key fk_emp4_emp5;

show tables ;

use test;

describe tb_student_info;

create table student
(
    id int(4),
    name varchar(20),
    sex char(1)
);

describe student;

alter table student
add age int(4);

use test_db;

show tables ;

create table if not exists tb_emp3
(
    id int(11) primary key ,
    name varchar(25),
    deptId int(11),
    salary float
);

describe tb_emp3;

create table if not exists tb_emp4
(
    id int(11),
    name varchar(25),
    deptId int(11),
    salary float,
    primary key (id)
);

describe tb_emp4;

show tables ;

drop table if exists tb_emp5;

create table if not exists tb_emp5
(
    name varchar(25),
    deptId int(11),
    salary float,
    primary key (name, deptId)
);

describe tb_emp5;

drop table if exists tb_emp2;

create table if not exists tb_emp2
(
    id int(11) not null ,
    name varchar(30),
    deptId int(11),
    salary float
);

describe tb_emp2;

alter table tb_emp2 add primary key(id);

alter table tb_emp2 drop primary key ;

create table tb_student(
    id int(4) primary key auto_increment,
    name varchar(25) not null
);

describe tb_student;

insert into tb_student(name) values ('Java'), ('MySQL'), ('Python');

select * from tb_student;

create table if not exists tb_student2 (
    id int not null auto_increment,
    name varchar(20) not null ,
    primary key (id)
) auto_increment=100;

insert into tb_student2(name) values ('java');

select * from tb_student2;

create table if not exists tb_student3(
    id int primary key auto_increment,
    name varchar(20) unique key ,
    age int default null
);

describe tb_student3;

insert into tb_student3 values (1, 1, 1);

select * from tb_student3;

insert into tb_student3 values (null, 1, 1);

insert into tb_student3 (name, age)
values (2, 3);

create table if not exists tb_dept1(
    id int(11) primary key ,
    name varchar(22) not null ,
    location varchar(50)
);

show tables ;

create table if not exists tb_emp6(
    id int(11) primary key ,
    name varchar(25),
    deptId int(11),
    salary float,
    constraint fk_emp_dept1 foreign key (deptId) references tb_dept1(id)
);

describe tb_emp6;

show create table tb_emp2;

alter table tb_emp2
add constraint fk_tb_dept1
foreign key (deptId)
references tb_dept1(id);

describe tb_emp2;

alter table tb_emp2
drop foreign key fk_tb_dept1;

show tables ;

create table if not exists tb_dept2(
    id int(11) primary key ,
    name varchar(22) unique ,
    location varchar(50)
);

describe tb_dept2;

alter table tb_dept1
add constraint unique_name unique (name);

describe tb_dept1;

show create table tb_dept1;

alter table tb_dept1
drop index unique_name;

create table if not exists tb_emp7(
    id int(11) primary key ,
    name varchar(25),
    deptId int(11),
    salary float,
    check ( salary > 0 and salary < 100),
    foreign key (deptId) references tb_dept1(id)
);

describe tb_emp7;

show create table tb_emp7;

alter table tb_emp7
add constraint check_id
check ( id > 0 );

alter table tb_emp7
drop constraint check_id;

create table if not exists tb_dept3(
    id int(11) primary key ,
    name varchar(22),
    location varchar(50) default 'Beijing'
);

describe tb_dept3;

alter table tb_dept3
change column location
location varchar(50) default 'Shanghai';

alter table tb_dept3
change column location
location varchar(50) default null;

create table if not exists tb_dept4(
    id int(11) primary key ,
    name varchar(22) not null ,
    location varchar(50)
);

describe tb_dept4;

alter table tb_dept4
change column location
location varchar(50) not null ;

alter table tb_dept4
change column location
location varchar(50) null ;

create table if not exists tb_emp8(
    id int(11) primary key ,
    name varchar(22) unique ,
    deptId int(11) not null ,
    salary float default 0,
    check ( salary > 0 ),
    foreign key (deptId) references tb_dept1(id)
);

show tables ;

show create table tb_emp8;

create table temp(
    num int
);

insert into temp value (64);

select num, num+10, num-3+5, num+36.5 from temp;

select num, num*2, num/2, num/3, num%3 from temp;

select mod(num, 3) from temp;

select num, num/0, num%0 from temp;

use test_db;

show tables ;

create table if not exists tb_students_info(
    id int(11) primary key auto_increment,
    name varchar(25) not null ,
    deptId int(11),
    age int(4),
    sex char,
    height int(4),
    login_date date
);

insert into tb_students_info(name, deptid, age, sex, height, login_date) values ('Dany', 1, 25, 'F', 160, '2015-09-10');
insert into tb_students_info(name, deptid, age, sex, height, login_date) values ('Green', 3, 23, 'F', 158, '2016-10-22');
insert into tb_students_info(name, deptid, age, sex, height, login_date) values ('Henry', 2, 23, 'M', 185, '2015-05-31');
insert into tb_students_info(name, deptid, age, sex, height, login_date) values ('Jane', 1, 22, 'F', 162, '2016-12-20');
insert into tb_students_info(name, deptid, age, sex, height, login_date) values ('Jim', 1, 24, 'M', 175, '2016-01-05');
insert into tb_students_info(name, deptid, age, sex, height, login_date) values ('John', 2, 21, 'M', 172, '2015-11-11');
insert into tb_students_info(name, deptid, age, sex, height, login_date) values ('Lily', 6, 22, 'F', 165, '2016-02-26');
insert into tb_students_info(name, deptid, age, sex, height, login_date) values ('Susan', 4, 23, 'F', 170, '2015-10-01');
insert into tb_students_info(name, deptid, age, sex, height, login_date) values ('Thomas', 3, 22, 'M', 178, '2016-06-07');
insert into tb_students_info(name, deptid, age, sex, height, login_date) values ('Tom', 4, 23, 'M', 165, '2016-08-05');

select * from tb_students_info;

select id, name, height from tb_students_info;

use test;

show tables ;

select * from student;

describe student;

alter table student add primary key (id) ;

alter table student
change column id
id int(4) auto_increment;

alter table student
change column sex
stuno int(4) after age;


insert into student (name, age, stuno)
values ('zhangsan', 18, 23),
       ('lisi', 19, 24),
       ('wangwu', 18, 25),
       ('zhaoliu', 18, 26),
       ('zhangsan', 18, 27),
       ('wangwu', 20, 28);

select * from test.student;

select distinct age from student;

select distinct name, age from student;

select distinct * from student;

select count(distinct name, age) from student;

show tables ;

select * from tb_student_info;

use test_db;

show tables ;

select * from tb_students_info;

select stu.name, stu.height from tb_students_info as stu ;

select * from tb_students_info limit 3, 5;

select * from tb_students_info order by height desc ;

select name, height from tb_students_info order by height, name;

select name, age, height from tb_students_info where age > 21 or height >= 175;

select name from tb_students_info where name like '____y';

select name from tb_students_info where name like 't%';

select `name`, `login_date` from tb_students_info where login_date is not null;

select group_concat(name), sex from tb_students_info group by sex;

select age, sex, group_concat(name) from tb_students_info group by age, sex;

select * from tb_students_info;

create table tb_course(
    id int(4) primary key auto_increment,
    course_name varchar(25) not null
);

insert into tb_course(course_name)
values('java'),
       ('MySQL'),
       ('Python'),
       ('Go'),
       ('C++');

select * from tb_course;

select * from tb_course cross join tb_students_info where tb_students_info.deptId = tb_course.id;

select s.name, c.course_name from tb_students_info s inner join tb_course c on s.deptId = c.id;

show databases ;

use test_db;

insert into tb_course(course_name) values ('HTML');

select * from tb_course;

select * from tb_students_info;

select s.name, c.course_name from tb_students_info s left join tb_course c on s.deptId = c.id;

select name from tb_students_info
where deptId in (select id from tb_course where course_name = 'java');

create table tb_courses(
    course_id int not null auto_increment,
    course_name char(40) not null ,
    course_grade float not null ,
    course_info char(100) null ,
    primary key (course_id)
);

select * from tb_courses;

insert into tb_courses(course_id, course_name, course_grade, course_info)
VALUES (1, 'Network', 3, 'Computer Network');

insert into tb_courses(course_name, course_info, course_id, course_grade)
VALUES ('Database', 'MySQL', 2, 3);

insert into tb_courses
values (3, 'Java', 4, 'Java EE');

insert into tb_courses(course_name, course_grade, course_info)
values ('System', 3, 'Operation System');

create table if not exists tb_courses_new (
    course_id int not null auto_increment,
    course_name char(40) not null ,
    course_grade float not null ,
    course_info char(100) null ,
    primary key (course_id)
);

insert into tb_courses_new (course_id, course_name, course_grade, course_info)
select course_id, course_name, course_grade, course_info from tb_courses;

select * from tb_courses_new;

update tb_courses_new set course_grade = 4;

update tb_courses_new
set course_name='DB', course_grade=3.5
where course_id=2;

create view view_students_info
as select * from tb_students_info;

select * from view_students_info;

create view v_student_info
(s_id, s_name, d_id, s_age, s_sex, s_height, s_date)
as select id, name, deptId, age, sex, height, login_date from tb_students_info;

select * from v_student_info;

describe v_student_info;

create table studentinfo (
    id int(11) primary key ,
    name varchar(20),
    score decimal(4, 2),
    subject varchar(20),
    teacher varchar(20)
);

create view v_studentinfo as select name, score from studentinfo;

describe v_studentinfo;

show create view v_studentinfo;

select * from information_schema.VIEWS;

select * from tb_student;

create table if not exists tb_stu_info (
    id int not null ,
    name char(45) default null,
    dept_id int default null,
    height int default null,
    index (height)
);

describe tb_stu_info;

show create table tb_stu_info;

create table tb_stu_info_2 (
    id int not null ,
    name char(45) default null,
    dept_id int default null,
    age int default null,
    height int default null,
    unique index (height)
);

show create table tb_stu_info_2;

show index from tb_stu_info_2;

delimiter //
create procedure ShowStuInfo()
begin
    select * from tb_students_info;
end //

call ShowStuInfo();

create table if not exists studentinfo (
    id int not null ,
    name varchar(20) default null,
    score decimal(4, 2) default null,
    subject varchar(20) default null,
    teacher varchar(20) default null,
    primary key (id)
);

show create table studentinfo;

delimiter //
create procedure showstuscore()
begin
    select id, name, score from studentinfo;
end //

call showstuscore();

show create procedure showstuscore;

use test;

show tables ;

delimiter //
create function func_student(id int(11)) returns varchar(20)
comment '查询某个学生的姓名'
begin
    return (select name from student where student.id = id);
end //
delimiter ;

show function status like 'func_student';

select test.func_student(1);


use test_db;
delimiter ;
call ShowStuInfo();

create table if not exists t8(
    s1 int primary key
);

delimiter //
create procedure handlerdemo()
begin
    declare continue handler for sqlstate '23000' set @X2=1;
    set @X=1;
    insert into t8 values (1);
    set @X=2;
    insert into t8 values (1);
    set @X=3;
end //
delimiter ;

call handlerdemo();

delimiter //
create procedure processnames()
begin
    declare nameCursor cursor for select name from tb_student;
end //
delimiter ;

create table users (
    id bigint(20) unsigned not null auto_increment,
    user_name varchar(60),
    user_pass varchar(64),
    primary key (id)
);

insert into users values (null, 'sheng', 'sheng123');
insert into users values (null, 'yu', 'yu123');
insert into users values (null, 'ling', 'ling123');

delimiter //
create procedure pro_users ()
begin
    declare result varchar(100);
    declare no int;
    declare cur_1 cursor for select user_name from users;
    declare continue handler for not found set no = 1;
    set no = 0;
    open cur_1;
    while no = 0 do
        fetch cur_1 into result;
        update users set user_name = 'MySQL' where user_name = result;
        end while ;
    close cur_1;
end //

call pro_users();

select * from users;

show tables ;

select * from tb_emp8;

create trigger SumOfSalary before insert on tb_emp8 for each row
    set @sum = @sum + NEW.salary;

insert into tb_dept1 values (1, '张三', '北京');

set @sum=0;
insert into tb_emp8 values (1, 'A', 1, 1000), (2, 'B', 1, 500);
select @sum;

select * from tb_emp6;

describe tb_emp6;

show create table tb_emp6;

select * from tb_emp7;

create trigger double_salary
    after insert on tb_emp6
    for each row
    insert into tb_emp7
    values (NEW.id, NEW.name, deptId, 2*NEW.salary);

insert into tb_emp6 values (1, 'A', 1, 1000), (2, 'B', 1, 500);

select * from tb_emp6;

select * from tb_emp7;

show triggers ;

show create trigger double_salary;

SHOW VARIABLES LIKE 'event_scheduler';

SELECT @@event_scheduler;

SHOW PROCESSLIST;

select * from information_schema.EVENTS limit 1;











