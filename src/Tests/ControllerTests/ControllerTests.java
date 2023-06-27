package Tests.ControllerTests;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Controller.FrontController;

public class ControllerTests {

	@Test
	public void test1_FrontController() {
		FrontController fcontroller = new FrontController();
		assertNotNull(fcontroller);  //null의 여부확인
		fcontroller.execute("/book",1,null);
		fcontroller.execute("/member",2,null);
		fcontroller.execute("/lend",3,null);
		fcontroller.execute("/dfsfsdfsdfsfdfs",4,null);
	}
	@Test
	public void test2_FrontController_SubController_Init() {
		FrontController fcontroller = new FrontController();
		assertNotNull(fcontroller);  //null의 여부확인
//		fcontroller.execute("/book",1,null);	//1 select
		Map<String,Object> param = new HashMap();
		param.put("bookname","이것이 자바다");
		param.put("publisher", "한빛미디어");
//		fcontroller.execute("/book",2,param);	//2 insert
		fcontroller.execute("/member",3,null);
		fcontroller.execute("/lend",4,null);
//		fcontroller.execute("/dfsfsdfsdfsfdfs",4,null);
	}
	@Test
	public void test2_FrontController_SubController_Param(){
		FrontController fcontroller = new FrontController();
		assertNotNull(fcontroller);  //null의 여부확인
//		fcontroller.execute("/book",1,null);	//1 select
		
		Map<String,Object> param = new HashMap();	
		param.put("bookcode",1234);
		param.put("bookname","이것이 자바다");
		param.put("publisher", "한빛미디어");
		param.put("isbn", "111-1111");
		fcontroller.execute("/book",2,param);
	}
	@Test
	public void test3_FrontController_SubController_Param() {
		FrontController fcontroller = new FrontController();
		Map<String,Object> param = new HashMap();
		param.put("id", "유진 기욤미");
		param.put("pw", "경민 예뿌니");
		param.put("username", "성진 멍청이");
		param.put("role", "영민 바보");
		fcontroller.execute("/member", 2, param);
	}
}
