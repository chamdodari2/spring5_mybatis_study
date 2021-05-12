package spring5_mybatis_study.service;

import java.util.Map;

import spring5_mybatis_study.dto.Student;

public interface StudentService {
	
	Map<Integer, Student> selectStudentForMap();
	
	Map<Integer,String> selectStudentForMap(int studId);//아이디와 그에 해당하는 이름 나올거
	Map<Integer,Student> selectStudentForMap2(int studId);//아이디와 그에 해당하는 객체 나올거

}
