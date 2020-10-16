package com.casestudy.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter

public class Loan {
	private long loanNo;
	private String borrowerName;
	private String dob;
	private String propertyAddress;
	private double cost;
	private String floodRisk;
	
	public long getLoanNo() {
		return loanNo;
	}
	public void setLoanNo(long loanNo) {
		this.loanNo = loanNo;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getFloodRisk() {
		return floodRisk;
	}
	public void setFloodRisk(String floodRisk) {
		this.floodRisk = floodRisk;
	}
	

}
