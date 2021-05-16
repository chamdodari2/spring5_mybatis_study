package spring5_mybatis_study.mapper;

import static org.junit.Assert.fail;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_study.config.ContextRoot;
import spring5_mybatis_study.dto.CourseState;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseStateMapperTest {

	protected static final Log log = LogFactory.getLog(CourseStateMapperTest.class);
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Autowired
	private CourseMapper mapper;
	
	public void testGetCourseCountByTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CourseState state
	}

}
