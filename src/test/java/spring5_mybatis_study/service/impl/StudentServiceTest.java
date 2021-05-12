package spring5_mybatis_study.service.impl;

import java.util.Map;
import java.util.Map.Entry;

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
import spring5_mybatis_study.dto.Student;
import spring5_mybatis_study.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {
	protected static final Log log = LogFactory.getLog(StudentServiceTest.class);

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Autowired
	private StudentService service;

	@Test
	public void test01SelectStudentForMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<Integer, String> map = service.selectStudentForMap(1);

		Assert.assertNotNull(map);

		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.printf("key(%s) - value(%s)%n", entry.getKey(), entry.getValue());
		}

	}

	@Test
	public void test02SelectStudentForMa2p() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<Integer, Student> map = service.selectStudentForMap2(1);
		Assert.assertNotNull(map);
		for (Entry<Integer, Student> entry : map.entrySet()) {
			System.out.printf("key(%s) - value(%s)%n", entry.getKey(), entry.getValue());
		}
	}
}