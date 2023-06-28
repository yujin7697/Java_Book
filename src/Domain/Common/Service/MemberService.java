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
	public boolean memberJoin(MemberDto dto) throws Exception{
		int result = dao.insert(dto);
		if(result>0) return true;
		return false;
	}
//	회원 조회하기(전체) -- 사서
	public List<MemberDto> memberSearch(String role) throws Exception{
		if(role.equals("ROLE_MEMBER"))
			return dao.select();
		return null;
	}
//	회원 조회(한명) - 사서
	public MemberDto memberSearchOne(String role, String id) throws Exception{
		if(role.equals("ROLE_MEMBER"))
			return dao.select(id);
		return null;
	}
//	회원 조회하기(한 회원) -- 로그인한 회원만
	public MemberDto memberSearch(String id,String sid) throws Exception{
		Session session = sessionMap.get(sid);
		if(session!=null && session.getId().equals(id))
			return dao.select(id);
		return null;
	}
//	회원 정보수정 -- 본인확인
	public boolean memberUpdate(MemberDto dto, String sid) throws Exception{
		Session session = sessionMap.get(sid);
		if(session!=null && session.getId().equals(dto.getId())) {
			int result = dao.update(dto); 
			if(result>0) return true;	
		}
		return false;
	}
//	회원 삭제하기
	public boolean memberDelete(String id,String sid) throws Exception{
		Session session = sessionMap.get(sid);
		if(session!=null && session.getId().equals(id)){
			int result = dao.delete(id);
			if(result>0) return true;
		}
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
	public Boolean logout(String id,String sid) {
		Session session = sessionMap.get(sid);
		if(!session.getId().equals(id)) {
			System.out.println("[ERROR] ID가 일치하지 않습니다.");
			return false;
		}
		sessionMap.remove(sid);
		return true;
	}
//	역할 반환 함수
	public String getRole(String sid) {
		Session session = sessionMap.get(sid);
		if(session!=null) return session.getRole();
		return null;
			
	}
}
