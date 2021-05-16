package spring5_mybatis_study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring5_mybatis_study.dto.Course;
import spring5_mybatis_study.dto.Tutor;
import spring5_mybatis_study.mapper.CourseMapper;
import spring5_mybatis_study.mapper.TutorMapper;

@Service
public class TutorAndCourseService {

	//dao 두개다 가져오기
	@Autowired
	private TutorMapper tMapper;

	@Autowired
	private CourseMapper cMapper;

	//한세트로 묶어주기
	@Transactional // @Transactional //aop를 이용할 경우 생략인데 aop가 더 귀찮다. 애노테이션이 편하다
	public void trJoinTutorAndCourse(Tutor tutor, Course course) {
		int res = tMapper.insertTutor(tutor);
		res += cMapper.insertCourse(course);
		if (res != 2)
			throw new RuntimeException();
	}

	@Transactional // aop를 이용할 경우 생략할수있다
	public void trRemoveTutorAndCourse(int tutorId, int courseId) {
		int res = cMapper.deleteCourse(courseId);
		res += tMapper.deleteTutor(tutorId);
		if (res != 2)
			throw new RuntimeException();
	}
}