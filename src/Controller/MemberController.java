package Controller;

import java.util.Map;

import Domain.Common.Dto.MemberDto;

public class MemberController {
//	1 Select(전체조회), 2 Insert, 3 Update, 4 Delete , 5 로그인, 6 로그아웃
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
			String id = (String)param.get("id");
			String pw = (String)param.get("pw");
			String username = (String)param.get("username");
			String role = (String)param.get("role");
//		2 입력값 검증
			if(id==null||pw==null||username==null||role==null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return ;
			}
//		3 서비스 실행
			MemberDto dto = new MemberDto(id,pw,username,role);
			System.out.println("Dto : " + dto);
//		4 View로 전달
			System.out.println("Member_Insert Block!");
		}
		else if(serviceNo==3) {
//		1 파라미터 추출
			String id = (String)param.get("id");
			String pw = (String)param.get("pw");
//		2 입력값 검증
			if(id==null||pw==null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return ;
			}
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
		else if(serviceNo==5) {
//			1 파라미터 추출
			String id = (String)param.get("id");
			String pw = (String)param.get("pw");
//			2 입력값 검증
			if(id==null||pw==null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return ;
			}
//			3 서비스 실행
			MemberDto dto = new MemberDto(id,pw,null,null);
//			4 View로 전달
		}
		else if(serviceNo==6) {
//			1 파라미터 추출
			String id = (String)param.get("id");
			String pw = (String)param.get("pw");
//			2 입력값 검증
			if(id==null||pw==null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return ;
			}
//			3 서비스 실행
//			4 View로 전달
		}
	}
}
