package semiproject.member.model.vo;

public class Likey {
	
	private int likeIdx;
	private String listId;
	private String userId;
	
	
	
	public int getLikeIdx() {
		return likeIdx;
	}
	public void setLikeIdx(int likeIdx) {
		this.likeIdx = likeIdx;
	}
	public String getListId() {
		return listId;
	}
	public void setListId(String listId) {
		this.listId = listId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Likey [likeIdx=" + likeIdx + ", listId=" + listId + ", userId=" + userId + "]";
	}
	
	
	

}
