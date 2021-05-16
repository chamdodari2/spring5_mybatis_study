-- procedure
select * 
from tutors t left join courses c on t.tutor_id = c.tutor_id ;





/*교수가 개설한 교과목 수를 구하시오 - 집단함수 ?*/
select t.name as tutor,count(c.name) as total
from tutors t left join courses c on t.tutor_id = c.tutor_id
group by t.name;



select t.name as tutor, count(c.name) as total
from tutors t left join courses c
on t.tutor_id = c.tutor_id 
where t.tutor_id =1;/*여기서 지정해줘서 밑에 그룹바이는 필요없다*/


group by t.tutor_id ;



/*프로시저 삭제*/
drop procedure if exists course_total;
/*프로시저 만들기*/
DROP PROCEDURE IF EXISTS course_total;

DROP PROCEDURE IF EXISTS mybatis_study.course_total;

DELIMITER $$
$$
CREATE PROCEDURE mybatis_study.course_total(in tutor_id int)/*매개변수로 정수형을 입력받는다*/
begin
	select t.name as tutor, count(c.name) as total /*결과가 tutor과 total로 출력될거다*/
	  from tutors t left join courses c
	    on t.tutor_id = c.tutor_id 
	 where t.tutor_id =t_id; /*where가 빠지고 그룹바이 들어가면 교수벼로 개설한 교과목 나올듯*/
	
END$$
DELIMITER ;



call course_total(1);

-- 그룹별로 만들기
DROP PROCEDURE IF EXISTS course_total_group;

DELIMITER $$
$$
CREATE PROCEDURE mybatis_study.course_total_group()/*매개변수 없이 할거다. 교수별로 개설한거 다 보려고*/
begin
	select t.name as tutor, count(c.name) as total /*결과가 tutor과 total로 출력될거다*/
	  from tutors t left join courses c
	    on t.tutor_id = c.tutor_id 
	 group by t.tutor_id; /*where가 빠지고 그룹바이 들어가면 교수벼로 개설한 교과목 나올듯*/
	
END$$
DELIMITER ;

-- 영역지정후 알트 x

call course_total_group();

-- map 말고 dto로 만들면 더 편하지 않을까! mybatis에서 이르