package com.cg.mps.DTO;

import java.time.LocalDate;

public class Customer 
{
	public int purchaseIdNumber;
	public String cname;
	public String mailId;
	public String phoneNo;
	public LocalDate ld;
	public int mobileId;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int purchaseIdNumber, String cname, String mailId,
			String phoneNo, LocalDate ld, int mobileId) {
		super();
		this.purchaseIdNumber = purchaseIdNumber;
		this.cname = cname;
		this.mailId = mailId;
		this.phoneNo = phoneNo;
		this.ld = ld;
		this.mobileId = mobileId;
	}
	@Override
	public String toString() {
		return "Customer [purchaseIdNumber=" + purchaseIdNumber + ", cname="
				+ cname + ", mailId=" + mailId + ", phoneNo=" + phoneNo
				+ ", ld=" + ld + ", mobileId=" + mobileId + "]";
	}
	public int getPurchaseIdNumber() {
		return purchaseIdNumber;
	}
	public void setPurchaseIdNumber(int purchaseIdNumber) {
		this.purchaseIdNumber = purchaseIdNumber;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public LocalDate getLd() {
		return ld;
	}
	public void setLd(LocalDate ld) {
		this.ld = ld;
	}
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
}
