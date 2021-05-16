package spring5_mybatis_study.mapper;

import spring5_mybatis_study.dto.CourseState;

public interface CourseStateMapper {
	//procedure
//	Map<String, Object> getCourseCountByTutor(Map<String, Object> param); //앞에 이렇게 나왔다는건 리저트핸들러 쓰겠다는뜻
//	Map<String, Object> getCourseCountByTutor2(Map<String,Object> param); //앞에 이렇게 나왔다는건 리저트핸들러 쓰겠다는뜻
//	
//	
//	
	CourseState getCourseCountByTutor(int param);

}
