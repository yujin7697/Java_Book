package Controller;

import java.util.Map;

public class MemberController {
//	1 Select(전체조회), 2 Insert, 3 Update, 4 Delete
	public void execute(int serviceNo, Map<String,Object> param) {
		if(serviceNo==1) {
//		1 파라미터 추출(생략)
//		2 입력값 검증(생략)
//		3 서비스 실행(서비스 모듈 작업 이후 처리)
//		4 View로 전달
			System.out.println("Member_Select Block!");
		}
		else if(serviceNo==2) {
//		1 파라미터 추출
//		2 입력값 검증
//		3 서비스 실행
//		4 View로 전달
			System.out.println("Member_Insert Block!");
		}
		else if(serviceNo==3) {
//		1 파라미터 추출
//		2 입력값 검증
//		3 서비스 실행
//		4 View로 전달
			System.out.println("Member_Update Block!");
		}
		else if(serviceNo==4) {
//		1 파라미터 추출
//		2 입력값 검증
//		3 서비스 실행
//		4 View로 전달
			System.out.println("Member_Delete Block!");
		}
	}
}
