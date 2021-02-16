package semiproject.review.model.vo;

import java.sql.Date;

public class CounsReview {
	
	private String counsIdx;
	private String counsListId;
	private String counsUserId;
	private String counsReview;
	private Date counsDate;
	
	
	public String getCounsIdx() {
		return counsIdx;
	}
	public void setCounsIdx(String counsIdx) {
		this.counsIdx = counsIdx;
	}
	public String getCounsListId() {
		return counsListId;
	}
	public void setCounsListId(String counsListId) {
		this.counsListId = counsListId;
	}
	public String getCounsUserId() {
		return counsUserId;
	}
	public void setCounsUserId(String counsUserId) {
		this.counsUserId = counsUserId;
	}
	public String getCounsReview() {
		return counsReview;
	}
	public void setCounsReview(String counsReview) {
		this.counsReview = counsReview;
	}
	public Date getCounsDate() {
		return counsDate;
	}
	public void setCounsDate(Date counsDate) {
		this.counsDate = counsDate;
	}
	
	
	
	
	@Override
	public String toString() {
		return "CounsReview [counsIdx=" + counsIdx + ", counsListId=" + counsListId + ", counsUserId=" + counsUserId
				+ ", counsReview=" + counsReview + ", counsDate=" + counsDate + "]";
	}
	
	
	
	
	
	
	
}
