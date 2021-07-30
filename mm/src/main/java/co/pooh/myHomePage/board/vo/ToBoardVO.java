package co.pooh.myHomePage.board.vo;

import java.sql.Date;

public class ToBoardVO {
	private Date toDate;
	private String toWriter;
	private String toContent;
	private String toLike;
	
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
	public String getToLike() {
		return toLike;
	}
	public void setToLike(String toLike) {
		this.toLike = toLike;
	}
	
	
}
