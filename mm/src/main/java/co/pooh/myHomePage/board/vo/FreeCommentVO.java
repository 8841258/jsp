package co.pooh.myHomePage.board.vo;

import java.sql.Date;

public class FreeCommentVO {
	private int freeNO;
	private int freeCno;
	private String freeCcontent;
	private String freeCwriter;
	private Date freeCdate;
	
	public int getFreeNO() {
		return freeNO;
	}
	public void setFreeNO(int freeNO) {
		this.freeNO = freeNO;
	}
	public int getFreeCno() {
		return freeCno;
	}
	public void setFreeCno(int freeCno) {
		this.freeCno = freeCno;
	}
	public String getFreeCcontent() {
		return freeCcontent;
	}
	public void setFreeCcontent(String freeCcontent) {
		this.freeCcontent = freeCcontent;
	}
	public String getFreeCwriter() {
		return freeCwriter;
	}
	public void setFreeCwriter(String freeCwriter) {
		this.freeCwriter = freeCwriter;
	}
	public Date getFreeCdate() {
		return freeCdate;
	}
	public void setFreeCdate(Date freeCdate) {
		this.freeCdate = freeCdate;
	}
	
	
	
}
