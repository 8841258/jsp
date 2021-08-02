package co.pooh.myHomePage.board.vo;

import java.sql.Date;

public class FreeBoardVO extends FreeCommentVO {
	private int freeNo;
	private String freeTitle;
	private Date freeDate;
	private String freeWriter;
	private String freeContent;
	private String freeCnum;
	private int hit;
	private String freeFile;
	
	public String getFreeFile() {
		return freeFile;
	}

	public void setFreeFile(String freeFile) {
		this.freeFile = freeFile;
	}

	public FreeBoardVO() {}

	public int getFreeNo() {
		return freeNo;
	}

	public void setFreeNo(int freeNo) {
		this.freeNo = freeNo;
	}

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

	public String getFreeCnum() {
		return freeCnum;
	}

	public void setFreeCnum(String freeCnum) {
		this.freeCnum = freeCnum;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
}
