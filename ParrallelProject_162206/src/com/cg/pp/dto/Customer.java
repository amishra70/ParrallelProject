package com.cg.pp.dto;



public class Customer {
	
	private int custId;
	private String custName;
	private String openingBalance;
	private String mobNo;
	private String adhrCard;
	AccountType accountType ;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public Customer(int custId, String custName, String openingBalance,
			String mobNo, String adhrCard, AccountType accountType,
			String password) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.openingBalance = openingBalance;
		this.mobNo = mobNo;
		this.adhrCard = adhrCard;
		this.accountType = accountType;
		this.password = password;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getAdhrCard() {
		return adhrCard;
	}
	public void setAdhrCard(String adhrCard) {
		this.adhrCard = adhrCard;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", openingBalance=" + openingBalance + ", mobNo=" + mobNo
				+ ", adhrCard=" + adhrCard + "]"+password;
	}

	
}
