package semiproject.listener.model.vo;

import java.sql.Date;
import java.util.Arrays;

public class FindListener {

	private String[] listType;
	private String[] listGen;
	private String[] listField;
	private int[] listAge;
	private int[] listPrice;
	public String[] getListType() {
		return listType;
	}
	public void setListType(String[] listType) {
		this.listType = listType;
	}
	public String[] getListGen() {
		return listGen;
	}
	public void setListGen(String[] listGen) {
		this.listGen = listGen;
	}
	public String[] getListField() {
		return listField;
	}
	public void setListField(String[] listField) {
		this.listField = listField;
	}
	public int[] getListAge() {
		return listAge;
	}
	public void setListAge(int[] listAge) {
		this.listAge = listAge;
	}
	public int[] getListPrice() {
		return listPrice;
	}
	public void setListPrice(int[] listPrice) {
		this.listPrice = listPrice;
	}
	@Override
	public String toString() {
		return "FindListener [listType=" + Arrays.toString(listType) + ", listGen=" + Arrays.toString(listGen)
				+ ", listField=" + Arrays.toString(listField) + ", listAge=" + Arrays.toString(listAge) + ", listPrice="
				+ Arrays.toString(listPrice) + "]";
	}
	
	
	
}
