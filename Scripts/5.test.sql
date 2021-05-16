select * from addresses;
select * from course_enrollment ;
select * from courses ;
select * from tutors ;
select * from students;
select * from students;

desc user_pics;
delete from tutors where tutor_id =5;
delete from courses where course_id in(14,15,16,17,18,19);

select  stud_id, name, email, dob, phone  from students  where stud_id =1; /*이렇게 검ㅅ개하면 dto에서 쪼개져있는데 ㅎsql에서 한번에보겧가ㅣ*/
/* 전화번호 쪼개서 보기 */
select  stud_id,name,email,dob, 
substring(phone,1,3)as f,  /*1번자리부터 3개 5번자리부터 3개 9번자리부터 4개*/
substring(phone,5,3)as m ,
substring(phone,9,4)as l 
from students  where stud_id =1;
/**/
select stud_id,name,email,phone,dob,	/*학생*/
a.addr_id, street,city,state,zip,country	/*주소*/
from students s 
join addresses a 
on s.addr_id =a.addr_id 
where stud_id=1;


/* 교수가 강의하고있는 과목정보 출력*/
select
	t.tutor_id,
	t.name as tutor_name,
	email,
	c.course_id,
	c.name,
	description,
	start_date,
	end_date
from
	tutors t
left outer join courses c on
	t.tutor_id = c.tutor_id
where
	t.tutor_id = 1;
	

/**/
select * from user_pics;

/*ppt 159쪽~  검색조건 주기 where로*/

select course_id, name, description, start_date, end_date, tutor_id from courses
where course_id=1;

select course_id, name, description, start_date, end_date, tutor_id from courses
where name like '%java%';

select course_id, name, description, start_date, end_date, tutor_id from courses
where start_date >='2013-02-01';

select course_id, name, description, start_date, end_date, tutor_id from courses
where end_date <='2013-07-01';

select course_id, name, description, start_date, end_date, tutor_id from courses
where start_date >='2013-02-01' and end_date <='2013-07-01';

/* forEㅁch와  ㄱ밭다*/

select course_id, name, description, start_date, end_date, tutor_id from courses
where course_id in (1,2); /*여기서 매개변수 여러개 넣기 해보기!! 괄호도 같이넣어저ㅜ야한다*/

insert  () () ()  
insert into courses (course_id,name,description,start_date,end_date,tutor_id) values 1,2,3,4,5,6,)


select * from courses;


INSERT INTO courses
(name, description, start_date, end_date, tutor_id)
VALUES(8,'test', 'test', '2013-03-01','2013-03-01', 1);

INSERT INTO COURSES (COURSE_ID,NAME,DESCRIPTION,START_DATE,END_DATE,TUTOR_ID) VALUES
(11,'Quickstart Core Java','Core Java Programming','2013-03-01','2013-04-15',1);

DELETE FROM courses
WHERE course_id in (8,7,6);


/*insert tutor*/
insert into tutors(tutor_id, name, email,phone,addr_id)
values (5,'kim','test@naver.com','111-111-1111',1);

/* delete tutor*/
 delete from tutors where tutor_id =5;
 
select t.tutor_id,
		t.name as tutor_name, email, c.course_id,
		c.name,
		description,
		start_date, end_date
		from tutors t left outer join
		courses c on
		t.tutor_id=c.tutor_id;
