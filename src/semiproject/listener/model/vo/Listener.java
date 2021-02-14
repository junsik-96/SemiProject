package semiproject.listener.model.vo;

import java.sql.Date;
import java.util.Arrays;

public class Listener {


	private String listId;
	private String listGen;
	private String listPro;
	private String listField;
	private String type;
	private int listAmt;
	private String listIsTrue;
	private int listLikely;
	private int listResCnt;
	private Date listRegDate;
	private String listSchool;
	private String listClass;
	private String[] listLicense;
	private String[] listJob;
	private String listName;
	private String listPhone;
	private String listEmail;
	private Date listBirth;
	
	
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public String getListId() {
		return listId;
	}
	public void setListId(String listId) {
		this.listId = listId;
	}
	public String getListGen() {
		return listGen;
	}
	public void setListGen(String listGen) {
		this.listGen = listGen;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Date getListRegDate() {
		return listRegDate;
	}
	public void setListRegDate(Date listRegDate) {
		this.listRegDate = listRegDate;
	}
	public String getListSchool() {
		return listSchool;
	}
	public void setListSchool(String listSchool) {
		this.listSchool = listSchool;
	}
	public String getListClass() {
		return listClass;
	}
	public void setListClass(String listClass) {
		this.listClass = listClass;
	}
	public String[] getListLicense() {
		return listLicense;
	}
	public void setListLicense(String[] listLicense) {
		this.listLicense = listLicense;
	}
	public String[] getListJob() {
		return listJob;
	}
	public void setListJob(String[] listJob) {
		this.listJob = listJob;
	}
	
	
	public String getListPhone() {
		return listPhone;
	}
	public void setListPhone(String listPhone) {
		this.listPhone = listPhone;
	}
	public String getListEmail() {
		return listEmail;
	}
	public void setListEmail(String listEmail) {
		this.listEmail = listEmail;
	}
	public Date getListBirth() {
		return listBirth;
	}
	public void setListBirth(Date listBirth) {
		this.listBirth = listBirth;
	}
	@Override
	public String toString() {
		return "Listener [listId=" + listId + ", listGen=" + listGen + ", listPro=" + listPro + ", listField="
				+ listField + ", type=" + type + ", listAmt=" + listAmt + ", listIsTrue=" + listIsTrue + ", listLikely="
				+ listLikely + ", listResCnt=" + listResCnt + ", listRegDate=" + listRegDate + ", listSchool="
				+ listSchool + ", listClass=" + listClass + ", listLicense=" + Arrays.toString(listLicense)
				+ ", listJob=" + Arrays.toString(listJob) + ", listName=" + listName + ", listPhone=" + listPhone
				+ ", listEmail=" + listEmail + ", listBirth=" + listBirth + "]";
	}
	
	
	
	

	
	
}	