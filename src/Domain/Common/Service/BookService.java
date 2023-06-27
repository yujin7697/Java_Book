package Domain.Common.Service;

import java.util.List;

import Domain.Common.Dao.BookDao;
import Domain.Common.Dto.BookDto;

public class BookService {
	
	private BookDao dao;
	public BookService(){
		dao = new BookDao();
	}
//	도서조회하기
	public List<BookDto> getAllBook() throws Exception{
		System.out.println("BOOKService's getAllBook()");
		return dao.select();
	}
//	도서등록하기
	public boolean addBook(BookDto dto) throws Exception{
		System.out.println("BOOKService's addBook()");
		int result = dao.insert(dto);
		if(result>0) return true;
		return false;
	}
//	도서수정하기
	public boolean updateBook(BookDto dto) throws Exception{
		System.out.println("BOOKService's updateBook()");
		int result = dao.update(dto);
		if(result>0) return true;
		return false;
	}
//	도서삭제하기
	public boolean removeBook(int bookcode) throws Exception{
		System.out.println("BOOKService's removeBook()");
		int result = dao.delete(bookcode);
		if(result>0) return true;
		return false;
	}
}
