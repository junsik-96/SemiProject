package semiproject.reservation.model.vo;

import java.sql.Date;

public class Reservation {

	private int resIdx;
	private String resListId;
	private String resUserId;
	private Date resDate;
	private String resState;
	private int resAmt;
	private Date resConsult;

	public int getResIdx() {
		return resIdx;
	}

	public void setResIdx(int resIdx) {
		this.resIdx = resIdx;
	}

	public String getResListId() {
		return resListId;
	}

	public void setResListId(String resListId) {
		this.resListId = resListId;
	}

	public String getResUserId() {
		return resUserId;
	}

	public void setResUserId(String resUserId) {
		this.resUserId = resUserId;
	}

	public Date getResDate() {
		return resDate;
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}

	public String getResState() {
		return resState;
	}

	public void setResState(String resState) {
		this.resState = resState;
	}

	public int getResAmt() {
		return resAmt;
	}

	public void setResAmt(int resAmt) {
		this.resAmt = resAmt;
	}

	public Date getResConsult() {
		return resConsult;
	}

	public void setResConsult(Date resConsult) {
		this.resConsult = resConsult;
	}

	@Override
	public String toString() {
		return "Reservation [resIdx=" + resIdx + ", resListId=" + resListId + ", resUserId=" + resUserId + ", resDate="
				+ resDate + ", resState=" + resState + ", resAmt=" + resAmt + ", resConsult=" + resConsult + "]";
	}
	
	
	
}