package spring5_mybatis_study.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_mybatis_study.dto.Student;
import spring5_mybatis_study.resulthandler.StudentResultHandler;
import spring5_mybatis_study.service.StudentService;

@Service // 이렇게하면 자동으로 Bean이 생성된다 대신 ContextRoot에 가서 이 패키지 주소 추가해저ㅜ야한다
public class StudentServiceImpl implements StudentService {
	private final String namespace = "spring5_mybatis_study.mapper.StudentMapper"; // 여기에 있는거 . selectStudentForMap 할거당

	@Autowired
	private SqlSession sqlSession; // 쿼리날리려면 필요하다

	// ResultSet 처리방식의 재정의
	@Override
	public Map<Integer, String> selectStudentForMap(int studId) {
		Map<Integer, String> map = new HashMap<>();
		StudentResultHandler resultHandler = new StudentResultHandler(map);

		sqlSession.select(namespace + ".selectStudentForMap", studId, resultHandler);// 셀렉트를 통해서도 메서드 수행할수있다.
		return map;
	}

	@Override
	public Map<Integer, Student> selectStudentForMap2(int studId) {
		Map<Integer, Student> map = new HashMap<>();

		ResultHandler<Student> handler = new ResultHandler<Student>() {

			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) { // 익명클래스 일회용
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student);

			}
		};
		sqlSession.select(namespace + ".selectStudentForMap", studId, handler);
		return map;
	}

	@Override
	public Map<Integer, Student> selectStudentForMap() {
		Map<Integer, Student> map = new HashMap<>();

		ResultHandler<Student> handler = new ResultHandler<Student>() {

			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) { // 익명클래스 일회용
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student);

			}
		};
		//list<Student> 원래결관느 요건데 -> handler 얘가  낚아채서 -> Map<Integer, Student>Map 의 결괄르 재정의해서  이렇게 던져주겠다ㅏ  ->  
		sqlSession.select(namespace + ".selectStudentForMap",  handler);
		return map;
	}

}
