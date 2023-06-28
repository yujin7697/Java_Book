package Domain.Common.Service;

import java.util.List;

import Domain.Common.Dao.BookDao;
import Domain.Common.Dto.BookDto;

public class BookService {
	
	private BookDao dao;
	
	private static BookService instance;
	public static BookService getInstance() {
		if(instance == null) instance = new BookService();
		return instance;
	}
	
	private MemberService memberService;
	private BookService(){
		dao = BookDao.getInstance();
		memberService = MemberService.getInstance();
	}
//	도서조회하기 - 전체
	public List<BookDto> getAllBook() throws Exception{
		System.out.println("BOOKService's getAllBook()");
		return dao.select();
	}
//	도서조회하기 - 한건
	public BookDto getBook(int bookcode) throws Exception{
		System.out.println("BOOKService's getBook()");
		return dao.select(bookcode);
	}
//	도서등록하기(사서)
	public boolean addBook(BookDto dto,String sid) throws Exception{
		System.out.println("BOOKService's addBook()");
		String role = memberService.getRole(sid);
		
		if(role.equals("ROLE_MEMBER")) {	
			int result = dao.insert(dto);
			if(result>0) return true;
		}
		return false;
	}
//	도서수정하기
	public boolean updateBook(BookDto dto, String role) throws Exception{
		System.out.println("BOOKService's updateBook()");
		if(role.equals("ROLE_MEMBER")) {
			int result = dao.update(dto);
			if(result>0) return true;
		}
		return false;
	}
//	도서삭제하기
	public boolean removeBook(int bookcode,String sid) throws Exception{
		System.out.println("BOOKService's removeBook()");
		String role = memberService.getRole(sid);
		if(role.equals("ROLE_MEMBER")) {
			int result = dao.delete(bookcode);
			if(result>0) return true;
		}
		return false;
	}
}
