package com.navkar.billGeneratorPojo;

public class LineItemBO {

	public int SrNo;
	
	public String particular;
	
	public QuantityBO quantity;
	
	@Override
	public String toString() {
		return "LineItemBO [SrNo=" + SrNo + ", particular=" + particular + ", quantity=" + quantity + ", amount="
				+ amount + "]";
	}

	public int getSrNo() {
		return SrNo;
	}

	public void setSrNo(int srNo) {
		SrNo = srNo;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public QuantityBO getQuantity() {
		return quantity;
	}

	public void setQuantity(QuantityBO quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double amount;
	
}
