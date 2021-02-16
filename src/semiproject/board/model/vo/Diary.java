package semiproject.board.model.vo;

import java.sql.Date;

public class Diary {
	
	private int drIdx;
	private String userId;
	private String title;
	private String content;
	private Date regDate;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDrIdx() {
		return drIdx;
	}
	public void setDrIdx(int drIdx) {
		this.drIdx = drIdx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Diary [drIdx=" + drIdx + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}
	
	
	
	
}
