package Domain.Common.Dto;

import java.util.Date;

public class LendDto {
	private int lend;
	private int bookcode;
	private int islend;
	private String id;
	private Date lendDate;
	private Date returnDate; // 7일후 반납예정일 계산

//	생성자
	public LendDto() {
	}

//	인자 받는 생성자
	public LendDto(int lend, int bookcode, int islend, String id, Date lendDate, Date returnDate) {
		super();
		this.lend = lend;
		this.bookcode = bookcode;
		this.islend = islend;
		this.id = id;
		this.lendDate = lendDate;
		this.returnDate = returnDate;
	}

//	toString
	@Override
	public String toString() {
		return "LendDto [lend=" + lend + ", bookcode=" + bookcode + ", islend=" + islend + ", id=" + id + ", lendDate="
				+ lendDate + ", returnDate=" + returnDate + "]";
	}

//	getter and setter
	public int getLend() {
		return lend;
	}

	public void setLend(int lend) {
		this.lend = lend;
	}

	public int getBookcode() {
		return bookcode;
	}

	public void setBookcode(int bookcode) {
		this.bookcode = bookcode;
	}

	public int getIslend() {
		return islend;
	}

	public void setIslend(int islend) {
		this.islend = islend;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLendDate() {
		return lendDate;
	}

	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}
