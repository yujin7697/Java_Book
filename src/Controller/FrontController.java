package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {
	
	Map<String,Object> map = new HashMap();
//	초기값 설정
//	사용자 요구사항 API Controller에 맞게 저장
//	/req_bookinfo에 대한 요구사랑 BookController 전달
	private void init() {
//		도서정보 요구사항 - Controller Mapping
//		/RequestUri ServiceNo Param
		map.put("/book", new BookController());
		map.put("/member", new MemberController());
		map.put("/lend", new LendController());	
		
	}
	public FrontController(){
		init();
	}
//	request에 맞는 Controller를 추출, 해당 컨트롤러 실행
//	request, ServiceNo(1 select, 2 insert, 3 update, 4 delete) , Param
	public void execute(String request, int ServiceNo, Map<String,Object> param) {
		Object controller = map.get(request);
		if(controller instanceof BookController) {
			
			BookController down = (BookController)controller;
			down.execute(ServiceNo,param);
			System.out.println("BOOKCONTROLLER!");
		}
		else if(controller instanceof LendController) {
			LendController down = (LendController)controller;
			down.execute(ServiceNo,param);
			System.out.println("LENDCONTROLLER!");
		}
		else if(controller instanceof MemberController) {
			MemberController down = (MemberController)controller;
			down.execute(ServiceNo,param);
			System.out.println("MEMBERCONTROLLER!");
		}
		else {
			System.out.println("Request ERROR!");
		}
	}
}
