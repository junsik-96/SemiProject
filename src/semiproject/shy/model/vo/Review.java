package semiproject.shy.model.vo;

import java.sql.Date;

public class Review {
	
	private int rvIdx;
	private String rvListId;
	private Date rvResDate;
	private String review;
	private String rvUserId;
	private String rating;
	
	
	public Review() {
		// TODO Auto-generated constructor stub
	}


	public int getRvIdx() {
		return rvIdx;
	}


	public void setRvIdx(int rvIdx) {
		this.rvIdx = rvIdx;
	}


	public String getRvListId() {
		return rvListId;
	}


	public void setRvListId(String rvListId) {
		this.rvListId = rvListId;
	}


	public Date getRvResDate() {
		return rvResDate;
	}


	public void setRvResDate(Date rvResDate) {
		this.rvResDate = rvResDate;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public String getRvUserId() {
		return rvUserId;
	}


	public void setRvUserId(String rvUserId) {
		this.rvUserId = rvUserId;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Review [rvIdx=" + rvIdx + ", rvListId=" + rvListId + ", rvResDate=" + rvResDate + ", review=" + review
				+ ", rvUserId=" + rvUserId + ", rating=" + rating + "]";
	}


	

	
	
}
