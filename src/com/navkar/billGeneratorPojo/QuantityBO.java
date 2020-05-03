package com.navkar.billGeneratorPojo;

public class QuantityBO {

	public String unit;
	
	public Double value;

	@Override
	public String toString() {
		return "QuantityBO [unit=" + unit + ", value=" + value + "]";
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
}
