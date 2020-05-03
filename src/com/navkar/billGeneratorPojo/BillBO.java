package com.navkar.billGeneratorPojo;

import java.util.Date;
import java.util.List;


public class BillBO {
	
	public String billId;
	
	public String companyName;
	
	public Date billdate;
	
	public List<LineItemBO> lineItems;
	
	public Double advance;
	
	public Double balance;
	
	public Double totalAmount;

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getBilldate() {
		return billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	public List<LineItemBO> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItemBO> lineItems) {
		this.lineItems = lineItems;
	}

	public Double getAdvance() {
		return advance;
	}

	public void setAdvance(Double advance) {
		this.advance = advance;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "BillBO [billId=" + billId + ", companyName=" + companyName + ", billdate=" + billdate + ", lineItems="
				+ lineItems + ", advance=" + advance + ", balance=" + balance + ", totalAmount=" + totalAmount + "]";
	}
	
	
}
