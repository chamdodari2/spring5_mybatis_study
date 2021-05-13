package spring5_mybatis_study.mapper;

import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Course;
import spring5_mybatis_study.dto.Student;

public interface CourseMapper {
	
	//동적 sql- if 조건//
	List<Course> selectCoursesByCondition(Map<String,Object> map);
	//동적 sql- choose 조건//
	List<Course> selectCaseCourses(Map<String,Object> map);
	
	//동적 sql- where조건
	List<Course> selectWhereCourses(Map<String,Object> map);
	
	
	//동적 sql - trim 조건
	List<Course> selectTrimCourses(Map<String,Object> map);
	
	//동적 sql- foreach 루프
	List<Course> selectCourseForeachByTutors(Map<String,Object> map);
	
	//foreach
	int insertCourses(Map<String,Object> map);
	int deleteCourses(Map<String, Object> map);
	int updateSetStudent(Student student);
	
	
}
