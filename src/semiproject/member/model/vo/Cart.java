package semiproject.member.model.vo;

import java.sql.Date;

public class Cart {
	
	private int cartIdx;
	private String userId;
	private String listId;
	private Date regDate;
	
	public int getCartIdx() {
		return cartIdx;
	}
	public void setCartIdx(int cartIdx) {
		this.cartIdx = cartIdx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getListId() {
		return listId;
	}
	public void setListId(String listId) {
		this.listId = listId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Cart [cartIdx=" + cartIdx + ", userId=" + userId + ", listId=" + listId + ", regDate=" + regDate + "]";
	}
	
	

}
