package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.BookDto;

public class BookDao {
	private String id;
	private String pw;
	private String url;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BookDao() {
		id = "root";
		pw = "1234";
		url = "jdbc:mysql://localhost:3306/bookdb";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,id,pw);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//	CURD
	public int insert(BookDto dto) throws Exception{
		pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
		pstmt.setInt(1, dto.getBookcode());
		pstmt.setString(2, dto.getBookname());
		pstmt.setString(3, dto.getPublisher());
		pstmt.setString(4, dto.getIsbn());
		
		return pstmt.executeUpdate();
	}
	public List<BookDto> select() throws Exception{
		List<BookDto> list = new ArrayList();
		BookDto dto = null;
		pstmt=conn.prepareStatement("select * from tbl_book");
		rs=pstmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				dto=new BookDto();
				dto.setBookcode(rs.getInt("bookcode"));
				dto.setBookname(rs.getString("bookname"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
				list.add(dto);
			}
		}
		return list;
	}
	public List<BookDto> select(int bookcode) throws Exception{
		List<BookDto> list = new ArrayList();
		BookDto dto = null;
		pstmt=conn.prepareStatement("select * from tbl_book where bookcode=?");
		pstmt.setInt(1, bookcode);
		rs=pstmt.executeQuery();
		if(rs!=null) {
				rs.next();
				dto=new BookDto();
				dto.setBookcode(rs.getInt("bookcode"));
				dto.setBookname(rs.getString("bookname"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
				list.add(dto);
			
		}
		return list;
	}
	public List<BookDto> select(String keyword){
		return null;
	}
	public List<BookDto> select(String keyfield, String keyword){
		return null;
	}
	public int update(BookDto dto) throws Exception{
		pstmt = conn.prepareStatement("update tbl_book set bookname=?,publisher=?,isbn=?where bookcode=?");
		pstmt.setString(1, dto.getBookname());
		pstmt.setString(2, dto.getPublisher());
		pstmt.setString(3, dto.getIsbn());
		pstmt.setInt(4, dto.getBookcode());
		
		return pstmt.executeUpdate();
	}
	public int delete(int bookcode) throws Exception{
		pstmt = conn.prepareStatement("delete from tbl_book where bookcode=?");
		pstmt.setInt(1, bookcode);
		
		return pstmt.executeUpdate();
	}
}
