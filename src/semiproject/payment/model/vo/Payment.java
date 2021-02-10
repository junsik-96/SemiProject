package semiproject.payment.model.vo;

import java.sql.Date;

public class Payment {
	
	private int pm_idx;
	private int res_idx;
	private String pm_state;
	private Date pm_date;
	private int amount;
	
	public int getPm_idx() {
		return pm_idx;
	}
	
	public void setPm_idx(int pm_idx) {
		this.pm_idx = pm_idx;
	}
	
	public int getRes_idx() {
		return res_idx;
	}
	
	public void setRes_idx(int res_idx) {
		this.res_idx = res_idx;
	}
	
	public String getPm_state() {
		return pm_state;
	}
	
	public void setPm_state(String pm_state) {
		this.pm_state = pm_state;
	}
	
	public Date getPm_date() {
		return pm_date;
	}
	
	public void setPm_date(Date pm_date) {
		this.pm_date = pm_date;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Payment [pm_idx=" + pm_idx + ", res_idx=" + res_idx + ", pm_state=" + pm_state + ", pm_date=" + pm_date
				+ ", amount=" + amount + "]";
	}
	
	
}
