package spring5_mybatis_study.mapper;

import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Course;

public interface CourseMapper {
	
	//동적 sql- if 조건//
	List<Course> selectCoursesByCondition(Map<String,Object> map);
	//동적 sql- choose 조건//
	List<Course> selectCaseCourses(Map<String,Object> map);
	
	//동적 sql- where조건
	List<Course> selectWhereCourses(Map<String,Object> map);
}
