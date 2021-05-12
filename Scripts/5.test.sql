select * from addresses;
select * from course_enrollment ;
select * from courses ;
select * from tutors ;
select * from students;


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


/**/
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