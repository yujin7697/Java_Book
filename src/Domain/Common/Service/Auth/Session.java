package Domain.Common.Service.Auth;

public class Session{
	private String s_id;
	private String id;
	private String role;
//	디폴트 생성자
	public Session(){}
	
//	모든 인자 생성자
	public Session(String s_id, String id, String role) {
		super();
		this.s_id = s_id;
		this.id = id;
		this.role = role;
	}
	
//	getter and setter
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
//	toString
	@Override
	public String toString() {
		return "Session [s_id=" + s_id + ", id=" + id + ", role=" + role + "]";
	}
	
	
}
