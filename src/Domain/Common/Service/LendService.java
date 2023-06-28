package Domain.Common.Service;

import Domain.Common.Dao.LendDao;
import Domain.Common.Dto.BookDto;
import Domain.Common.Dto.LendDto;
import Domain.Common.Dto.MemberDto;

public class LendService {
	
	public MemberService memService;
	BookService bookService;
	LendDao dao;
	public LendService(){
		memService = new MemberService();
		bookService = new BookService();
		dao = new LendDao();
	}

	public boolean reqLend(String sid, String userid, int bookcode) throws Exception{
//		사서로그인확인, Role받기
		String role = memService.getRole(sid);
		if(role.equals("ROLE_MEMBER")) {
			System.out.println("[WARNNING] 사서만 로그인할 수 있습니다.");
			return false;
		}
//		회원존재유무 확인
		MemberDto dto = memService.memberSearchOne(role,userid);
		
		if(dto!=null) {
//			도서존재유무 확인
			BookDto bdto = bookService.getBook(bookcode);
			if(bdto!=null) {
//				도서가 있다면 대여중인 상태인지 확인(LendDao 이용해서 대여중인 책이 있는지 조회)
				LendDto ldto = null;
				
				ldto = dao.select(bookcode);
			
				if(ldto==null) {
//					도서가 대여가능한 상태라면
					dao.insert(new LendDto(0,bookcode,userid,null,null));
					System.out.println("[INFO] 도서대여 완료되었습니다.");
					return true;
				}
				System.out.println("[WARNNING] 요청한 도서는 대여중입니다.");
				return false;
			}
			System.out.println("[WARNNING] 해당 도서는 존재하지 않습니다.");
			return false;
		}
		System.out.println("[WARNNING] 해당 회원은 존재하지 않습니다.");
		return false;
		
//		도서가 있다면 대여중인 상태인지 확인
		
//		대여가능 상태라면 대여진행
		
	}
}
