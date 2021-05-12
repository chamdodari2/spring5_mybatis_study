package spring5_mybatis_study.mapper;

import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Student;

public interface StudentMapper {
	Student selectStudentById(Student student);

	Student selectStudentByIdWithResultMap(Student student); // withResultMap을 사용하겠당

	List<Student> selectStudentByAll();

	int insertStudent(Student student);

	int deleteStudent(int id);

	int updateStudent(Student student);

	List<Map<String, Object>> selectStudentByAllForHashMap();

	Student selectStudentByIdAssociation(Student student);

	int insertEnumStudent(Student student);

	// 여러개의 입력 파라미터 전달
	Student selectStudentByMap(Map<String, String> map);

	List<Student> selectAllStudentByMap(Map<String, String> map);

///* ResultSet 처리방식의 재정의 */

	Map<Integer, Student> selectStudentForMap(Student student);

}
