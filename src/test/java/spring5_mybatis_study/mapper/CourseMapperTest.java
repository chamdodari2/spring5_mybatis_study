package spring5_mybatis_study.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_study.config.ContextRoot;
import spring5_mybatis_study.dto.Course;
import spring5_mybatis_study.dto.PhoneNumber;
import spring5_mybatis_study.dto.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest {

	protected static final Log log = LogFactory.getLog(CourseMapperTest.class);

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Autowired
	private CourseMapper mapper;

	@Test
	public void test01SelectCoursesByCondition() {

		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		System.out.println("map >>>" + map);
		List<Course> list = mapper.selectCoursesByCondition(map); // 매개변수로 1번 넣어줬는데 ㅠ
		System.out.println("list>>> " + list);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CourseName", "%Java%");
		List<Course> list = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test03SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", cal.getTime());
		List<Course> list = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test04SelectCaseCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchBy", "Tutor");
		map.put("tutorId", 1);
		List<Course> list = mapper.selectCaseCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		map.replace("searchBy", "CourseName");
		map.remove("tutorId");
		map.put("CourseName", "%Java%");
		list = mapper.selectCaseCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test05SelectWhereCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> list = mapper.selectWhereCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);

		map.put("tutorId", 1);
		list = mapper.selectWhereCourses(map);
		list.stream().forEach(System.out::println);

		map.clear();
		map.put("endDate", new Date());
		list = mapper.selectWhereCourses(map);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test06selectTrimCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);

		map.put("tutorId", 1);
		list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);

		map.clear();
		map.put("courseName", "%Java%");
		System.out.println("과목명에 들어가냐 이단어 >> " + map);
		list = mapper.selectTrimCourses(map);
		System.out.println("map>>>" + list);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);

		map.clear();
		map.put("tutorId", 1);
		list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test07SelectCoursesForeachByTutors() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Integer> tutorIds = new ArrayList<Integer>();
		tutorIds.add(1);
		tutorIds.add(2);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorIds", tutorIds);

		List<Course> list = mapper.selectCourseForeachByTutors(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);

	}

//	@Test
//	public void test08insertCourses() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//
//		List<Course> tutors = new ArrayList<Course>();
//
//		tutors.add(new Course(17, "mysql", "database", new Date(), new Date(), 1));
//		tutors.add(new Course(18, "mysql", "database", new Date(), new Date(), 1));
//		tutors.add(new Course(19, "mariaDb", "database", new Date(), new Date(), 2));
//		System.out.println("tutors >>> " + tutors);
//		Map<String, Object> map = new HashMap<String, Object>();
//
//		map.put("tutors", tutors);
//		System.out.println("map>>>" + map);
//		int res = mapper.insertCourses(map);
//		Assert.assertEquals(3, res);
//	}

	@Test
	public void test09DeleteCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Integer> courseIds = Arrays.asList(4, 12, 13);// 외래키걸려있어서 쓰고있는 앞번호는 지울수없당..

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courseIds", courseIds);
		System.out.println("map>> " + map);
		int res = mapper.deleteCourses(map);
		Assert.assertEquals(3, res);
	}

	@Test
	public void test14UpdateSetStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		student.setPhone(new PhoneNumber("987-654-3211"));
		student.setDob(new Date());
		int result = mapper.updateSetStudent(student);
		Assert.assertSame(1, result);
		student.setPhone(new PhoneNumber("123-123-1234"));
		student.setDob(new GregorianCalendar(1988, 04, 25).getTime());
		result = mapper.updateSetStudent(student);
		Assert.assertSame(1, result);
	}

	@Test
	public void test10insertCourseAndDeleteCourse() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Course course = new Course(7, "oracle", "database", new Date(), new Date(), 4);
		int res = mapper.insertCourse(course);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 4);
		List<Course> list = mapper.selectCoursesByCondition(map);
		list.stream().forEach(System.out::println);
		res += mapper.deleteCourse(course.getCourseId());
		Assert.assertEquals(2, res);
	}

}
