package Tests.DaoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import Domain.Common.Dao.BookDao;
import Domain.Common.Dao.MemberDao;
import Domain.Common.Dto.BookDto;
import Domain.Common.Dto.MemberDto;

public class DaoTests {

	@Test
	public void BookDaoTest1() {
		BookDao dao = new BookDao();
		//객체연결 여부 확인 Test함수
		assertNotNull(dao);
	}
	
	@Test
	public void BookDaoTest2_insert() throws Exception {
		BookDao dao = new BookDao();
		assertNotNull(dao);
		int result=dao.insert(new BookDto(1,"JAVA의정석","A출판사","1111"));
		assertEquals(1,result); //기대값,실제값
	}
	@Test
	public void BookDaoTest3_insert_post100() throws Exception {
		BookDao dao = new BookDao();
		assertNotNull(dao);
		int result=0;
		for(int i=1;i<100;i++) {
			result+=dao.insert(new BookDto(1+i,"JAVA의정석"+i,"A출판사","1111"+i));
		}
		assertEquals(99,result); //기대값,실제값
		
	}
	@Test
	public void BookDaoTest4_select() throws Exception {
		BookDao dao = new BookDao();
		assertNotNull(dao);
		
		List<BookDto> list = dao.select();		
		assertNotNull(list);
		list.stream().forEach((dto)->{System.out.println(list);});
//		assertEquals(99,result); //기대값,실제값
		
	}
//	MemberDao ----------------------------------------------------------------------------
	@Test
	public void MemberDaoTest1_insert() throws Exception{
		MemberDao dao = new MemberDao();
		assertNotNull(dao);
		int result=dao.insert(new MemberDto("user1","1111","홍길동","Role_User"));
		assertEquals(1,result); //기대값,실제값
	}
	@Test
	public void MemberDaoTest2_update() throws Exception{
		MemberDao dao = new MemberDao();
		assertNotNull(dao);
		int result=dao.update(new MemberDto("user1","1234","hongGilDong","Role_Member"));
		assertEquals(1,result); //기대값,실제값
	}
	@Test
	public void MemberDaoTest2_delete() throws Exception{
		MemberDao dao = new MemberDao();
		assertNotNull(dao);
		int result=dao.delete("user1");
		assertEquals(1,result); //기대값,실제값
	}
	

}