package semiproject.payment.model.vo;

import java.sql.Date;

public class Payment {
	
	private int pmIdx;
	private int resIdx;
	private String pmState;
	private Date pmDate;
	private int amount;
	public int getPmIdx() {
		return pmIdx;
	}
	public void setPmIdx(int pmIdx) {
		this.pmIdx = pmIdx;
	}
	public int getResIdx() {
		return resIdx;
	}
	public void setResIdx(int resIdx) {
		this.resIdx = resIdx;
	}
	public String getPmState() {
		return pmState;
	}
	public void setPmState(String pmState) {
		this.pmState = pmState;
	}
	public Date getPmDate() {
		return pmDate;
	}
	public void setPmDate(Date pmDate) {
		this.pmDate = pmDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [pmIdx=" + pmIdx + ", resIdx=" + resIdx + ", pmState=" + pmState + ", pmDate=" + pmDate
				+ ", amount=" + amount + "]";
	}
	
}