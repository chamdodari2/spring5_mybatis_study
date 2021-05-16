package spring5_mybatis_study.mapper;

import java.util.Arrays;
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
import spring5_mybatis_study.dto.Address;
import spring5_mybatis_study.dto.Course;
import spring5_mybatis_study.dto.PhoneNumber;
import spring5_mybatis_study.dto.Tutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorMapperTest {
	private static final Log log = LogFactory.getLog(TutorMapperTest.class);

	@Autowired
	private TutorMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test1SelectTutorByTutorId() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Tutor findTutor = new Tutor();
		findTutor.setTutorId(1);
		Tutor tutor = mapper.selectTutorByTutorId(findTutor);
		Assert.assertEquals(tutor.getTutorId(), findTutor.getTutorId());

		log.trace(tutor.getTutorId() + ":" + tutor.getName());
		log.debug(tutor.toString());// 로그내용 나오는거

		List<Course> list = tutor.getCourses();
//		Assert.assertNotNull(list); 
		list.stream().forEach(System.out::println);

	}
	@Test
	public void test2InsertTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Address address = new Address(); 
		address.setAddrId(2); // 집주소 2 넣기
		PhoneNumber phone = new PhoneNumber("010-2222-2222");

		Tutor tutor = new Tutor(5, "kim", "test@naver.com", phone, address); // 생성자에 적힌 순서대로 넣어야한당 ㅠ
		int res = mapper.insertTutor(tutor);		
		Assert.assertEquals(2, res);
	}

	
	@Test
	public void test4InsertTutorAndDeleteTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Address address = new Address(); 
		address.setAddrId(2); // 집주소 2 넣기
		PhoneNumber phone = new PhoneNumber("010-2222-2222");

		Tutor tutor = new Tutor(5, "kim", "test@naver.com", phone, address); // 생성자에 적힌 순서대로 넣어야한당 ㅠ
		int res = mapper.insertTutor(tutor);	
		
//		Tutor findTutor = mapper.selectTutorByTutorId(tutor);
//		System.out.println("findTutor>>>"+findTutor);
//		log.debug(findTutor.toString());// toString 해줘야 다 보인당
		res += mapper.deleteTutor(tutor.getTutorId());
		System.out.println("res>>>>"+res);
		Assert.assertEquals(2, res);
	}

	@Test
	public void Test3DeleteTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int deleteTutor = mapper.deleteTutor(5);
		Assert.assertSame(1, deleteTutor);
		
	}
	
	

}
