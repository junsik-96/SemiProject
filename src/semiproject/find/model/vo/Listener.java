package semiproject.find.model.vo;

public class Listener {


	private String listId;
	private String listNum;
	private String listGen;
	private String listEmail;
	private String listPro;
	private String listField;
	private String listType;
	private String listName;
	private int listAmt;
	private String listIsTrue;
	private int listLikely;
	private int listResCnt;
	
	public String getListId() {
		return listId;
	}
	
	public void setListId(String listId) {
		this.listId = listId;
	}
	
	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getListNum() {
		return listNum;
	}
	
	public void setListNum(String listNum) {
		this.listNum = listNum;
	}
	
	public String getListGen() {
		return listGen;
	}
	
	public void setListGen(String listGen) {
		this.listGen = listGen;
	}
	
	public String getListEmail() {
		return listEmail;
	}
	
	public void setListEmail(String listEmail) {
		this.listEmail = listEmail;
	}
	
	public String getListPro() {
		return listPro;
	}
	
	public void setListPro(String listPro) {
		this.listPro = listPro;
	}
	
	public String getListField() {
		return listField;
	}
	
	public void setListField(String listField) {
		this.listField = listField;
	}
	
	public String getListType() {
		return listType;
	}
	
	public void setListType(String listType) {
		this.listType = listType;
	}
	
	public int getListAmt() {
		return listAmt;
	}
	
	public void setListAmt(int listAmt) {
		this.listAmt = listAmt;
	}
	
	public String getListIsTrue() {
		return listIsTrue;
	}
	
	public void setListIsTrue(String listIsTrue) {
		this.listIsTrue = listIsTrue;
	}
	
	public int getListLikely() {
		return listLikely;
	}
	
	public void setListLikely(int listLikely) {
		this.listLikely = listLikely;
	}
	
	
	
	public int getListResCnt() {
		return listResCnt;
	}

	public void setListResCnt(int listResCnt) {
		this.listResCnt = listResCnt;
	}

	@Override
	public String toString() {
		return "Listener [listId=" + listId + ", listNum=" + listNum + ", listGen=" + listGen + ", listEmail="
				+ listEmail + ", listPro=" + listPro + ", listField=" + listField + ", listType=" + listType
				+ ", listName=" + listName + ", listAmt=" + listAmt + ", listIsTrue=" + listIsTrue + ", listLikely="
				+ listLikely + ", listResCnt=" + listResCnt + "]";
	}

	


	
}
