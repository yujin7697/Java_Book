package Tests.ControllerTests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Controller.FrontController;

public class ControllerTests {

	@Test
	public void test1_FrontController() {
		FrontController fcontroller = new FrontController();
		assertNotNull(fcontroller);  //null의 여부확인
		fcontroller.execute("/book_select",null);
		fcontroller.execute("/Member_insert",null);
		fcontroller.execute("/lend_insert",null);
		fcontroller.execute("/dfsfsdfsdfsfdfs",null);
	}

}
