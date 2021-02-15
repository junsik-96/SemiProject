package semiproject.calendar.model.vo;

public class Calendar {
	
	private String resListId;
	private String resUserId;
	private String resDate;
	
	
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
	public String getResDate() {
		return resDate;
	}
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}
	
	
	@Override
	public String toString() {
		return "Calendar [resListId=" + resListId + ", resUserId=" + resUserId + ", resDate=" + resDate + "]";
	}
	
	
	
	
}
