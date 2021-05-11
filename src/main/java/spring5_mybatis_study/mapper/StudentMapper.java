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

}
