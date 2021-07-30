package co.pooh.myHomePage.board.vo;

import java.sql.Date;

public class FreeBoardVO {
	private String freeTitle;
	private Date freeDate;
	private String freeWriter;
	private String freeContent;
	private String freeComment;
	private int hit;
	
	public String getFreeTitle() {
		return freeTitle;
	}
	public void setFreeTitle(String freeTitle) {
		this.freeTitle = freeTitle;
	}
	public Date getFreeDate() {
		return freeDate;
	}
	public void setFreeDate(Date freeDate) {
		this.freeDate = freeDate;
	}
	public String getFreeWriter() {
		return freeWriter;
	}
	public void setFreeWriter(String freeWriter) {
		this.freeWriter = freeWriter;
	}
	public String getFreeContent() {
		return freeContent;
	}
	public void setFreeContent(String freeContent) {
		this.freeContent = freeContent;
	}
	public String getFreeComment() {
		return freeComment;
	}
	public void setFreeComment(String freeComment) {
		this.freeComment = freeComment;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
