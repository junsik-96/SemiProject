package semiproject.board.model.vo;

import java.sql.Date;

public class Notice {
	
	private int nIdx;
	private String userId;
	private String content;
	private Date regDate;
	
	public int getnIdx() {
		return nIdx;
	}
	public void setnIdx(int nIdx) {
		this.nIdx = nIdx;
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
		return "Notice [nIdx=" + nIdx + ", userId=" + userId + ", content=" + content + ", regDate=" + regDate + "]";
	}
	
	
}
