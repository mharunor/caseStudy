package com.casestudy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Loan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Loan {
	
	  @Id
	  //@GeneratedValue
	  @Column(name = "loan_no")
	  private long loanNo;
	  
	  @Column(name = "borrower_name")
	  private String borrowerName;

	  @Column(name = "dob")
	  private String dob;

	  @Column(name = "property_address")
	  private String propertyAddress;
	  
	  @Column(name = "cost")
	  private double cost;
	  
	  @Column(name="flood_risk")
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
