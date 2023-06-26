package Domain.Common.Dto;

public class MemberDto {
	private String id;
	private String pw;
	private String username;
	private String role;
//	기본생성자
	public MemberDto(){}
//	모든인자 생성자
	public MemberDto(String id, String pw, String username, String role) {
		super();
		this.id = id;
		this.pw = pw;
		this.username = username;
		this.role = role;
	}
//	toString
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", username=" + username + ", role=" + role + "]";
	}
	
//	getter and setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
