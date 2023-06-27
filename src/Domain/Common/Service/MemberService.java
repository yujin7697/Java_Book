package Domain.Common.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import Domain.Common.Dao.MemberDao;
import Domain.Common.Dto.MemberDto;
import Domain.Common.Service.Auth.Session;

public class MemberService {
	
	public Map<String,Session> sessionMap;
	
	private MemberDao dao;
	
	public MemberService() {
		dao = new MemberDao();
		sessionMap = new HashMap();
	}
	
//	회원 가입하기
	boolean memberJoin(MemberDto dto) throws Exception{
		int result = dao.insert(dto);
		if(result>0) return true;
		return false;
	}
//	회원 조회하기(전체)
	List<MemberDto> memberSearch() throws Exception{
		return dao.select();
	}
//	회원 조회하기(한 회원)
	MemberDto memberSearch(String id) throws Exception{
		return dao.select(id);
	}
//	회원 정보수정
	boolean memberUpdate(MemberDto dto) throws Exception{
		int result = dao.update(dto); 
		if(result>0) return true;
		return false;
	}
//	회원 삭제하기
	boolean memberDelete(String id) throws Exception{
		int result = dao.delete(id);
		if(result>0) return true;
		return false;
	}
//	로그인
	public String login(String id, String pw) throws Exception{
//		1 ID/PW 체크 -> Dao 전달받은 id와 일치하는 정보를 가져와서 pw일치 확인
		MemberDto dbDto = dao.select(id);
		if(dbDto == null) {
			System.out.println("[ERROR] Login Fail... 아이디가 일치하지 않습니다.");
			return null;
		}
		if(!pw.equals(dbDto.getPw())) {
			System.out.println("[ERROR] Login Fail... 패스워드가 일치하지 않습니다.");
			return null;
		}
//		2 해당 사용자에 대한 정보를(Session)을 MemberService에 저장
		String sid = UUID.randomUUID().toString();
		Session session = new Session(sid,dbDto.getId(),dbDto.getRole());
		sessionMap.put(sid, session);
//		3 세션에 대한 정보를 클라이언트가 접근할 수 있도록 하는 세션 구별 Id(Session Cookie) 전달
		return sid;
	}
//	로그아웃
	public String logout(String id) {
		return null;
	}
}
