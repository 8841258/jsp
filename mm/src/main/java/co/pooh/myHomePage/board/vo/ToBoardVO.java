package co.pooh.myHomePage.board.vo;

import java.sql.Date;

public class ToBoardVO {
	private int toNo;
	private Date toDate;
	private String toWriter;
	private String toContent;
	private int toLike;
	
	public ToBoardVO () {}
	
	public int getToNo() {
		return toNo;
	}
	public void setToNo(int toNo) {
		this.toNo = toNo;
	}
	
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getToWriter() {
		return toWriter;
	}
	public void setToWriter(String toWriter) {
		this.toWriter = toWriter;
	}
	public String getToContent() {
		return toContent;
	}
	public void setToContent(String toContent) {
		this.toContent = toContent;
	}
	public int getToLike() {
		return toLike;
	}
	public void setToLike(int toLike) {
		this.toLike = toLike;
	}
	
	
}
