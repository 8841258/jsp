package co.pooh.myHomePage.board.vo;

import java.sql.Date;

public class FromBoardVO {
	private Date fromDate;
	private String fromWriter;
	private String fromContent;
	private int fromLike;
	private String fromComment;
	
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public String getFromWriter() {
		return fromWriter;
	}
	public void setFromWriter(String fromWriter) {
		this.fromWriter = fromWriter;
	}
	public String getFromContent() {
		return fromContent;
	}
	public void setFromContent(String fromContent) {
		this.fromContent = fromContent;
	}
	public int getFromLike() {
		return fromLike;
	}
	public void setFromLike(int fromLike) {
		this.fromLike = fromLike;
	}
	public String getFromComment() {
		return fromComment;
	}
	public void setFromComment(String fromComment) {
		this.fromComment = fromComment;
	}
	
	
}
