package spring5_mybatis_study.mapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_study.config.ContextRoot;
import spring5_mybatis_study.dto.UserPic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
public class UserPicMapperTest {
	protected static final Log log = LogFactory.getLog(UserPicMapperTest.class);

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Autowired
	private UserPicMapper mapper;

//	@Test
//	public void test1InsertUserPic() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		UserPic userPic = new UserPic();
//		userPic.setId(2);
//		userPic.setName("LeeYouYong");
//		userPic.setBio("put some Lengthy bio here");
//		userPic.setPic(getPicFile());
//		int result = mapper.insertUserPic(userPic);
//		Assert.assertSame(1, result);
//
//	}

	private byte[] getPicFile() {
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir") + "\\images\\유인영.jpg");// 현재 수행되고있는 경로를 가져온다. user.dir)
																					// //파일추저도 있지만 그냥 이주소로 픽스한다
		System.out.println(file.getPath());
		try (InputStream is = new FileInputStream(file)) {

			pic = new byte[is.available()]; // 해당 바이트의 배열이 생성된다 예) 216바이트의 배열
			is.read(pic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	@Test
	public void test2GetUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		// userPic 테이블의 이미지파일을 프로젝트폴더/pics 경로에 로드할거다
		///////////////////////////////////////////////////////////////////
		UserPic userPic = mapper.getUserPic(1);  // userPic는 dto가 넘어가는것 . (매개변수가 없는거)오버로딩을 해야함
		if (userPic.getPic() != null) {
			System.out.println(userPic.toString());
			File file = getPicFile(userPic);
			log.debug("file path " + file.getAbsolutePath());
		}
		System.out.println("성공?");
		System.out.println();
		Assert.assertNotNull(userPic); // 널이아니면 성공

	}

	private File getPicFile(UserPic userPic) {
		// 존재하지 않는다면 pics 라는 폴더를 만든다음 임지ㅣ를 가져다붙여라
		File pics = new File(System.getProperty("user.dir") + "\\pics\\");
		if (!pics.exists()) {
			pics.mkdir();
		}
		File file = new File(pics, userPic.getName() + ".jpg");
		try (FileOutputStream output = new FileOutputStream(file)) {
			output.write(userPic.getPic());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

//	@Test
//	public void test3DeleteUserPic() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		int res = mapper.deleteUserPic(2);
//		Assert.assertEquals(1, res);
//		

//
//	}

}
