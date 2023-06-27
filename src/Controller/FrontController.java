package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {
	
	Map<String,Object> map = new HashMap();
//	초기값 설정
//	사용자 요구사항 API Controller에 맞게 저장
//	/req_bookinfo에 대한 요구사랑 BookController 전달
	void init() {
//		도서정보 요구사항 -Controller Mapping
		map.put("/book_select", new BookController());
		map.put("/book_insert", new BookController());		
		map.put("/book_update", new BookController());		
		map.put("/book_delete", new BookController());	
		
		map.put("/Member_select", new MemberController());
		map.put("/Member_insert", new MemberController());		
		map.put("/Member_update", new MemberController());		
		map.put("/Member_delete", new MemberController());	
		
		map.put("/lend_select", new LendController());
		map.put("/lend_insert", new LendController());		
		map.put("/lend_update", new LendController());		
		map.put("/lend_delete", new LendController());	
	}
	public FrontController(){
		init();
	}
//	request에 맞는 Controller를 추출, 해당 컨트롤러 실행
	public void execute(String request,Object[] param) {
		Object controller = map.get(request);
		if(controller instanceof BookController) {
			System.out.println("BOOKCONTROLLER!");
		}
		else if(controller instanceof LendController) {
			System.out.println("LENDCONTROLLER!");
		}
		else if(controller instanceof MemberController) {
			System.out.println("MEMBERCONTROLLER!");
		}
		else {
			System.out.println("Request ERROR!");
		}
	}
}
