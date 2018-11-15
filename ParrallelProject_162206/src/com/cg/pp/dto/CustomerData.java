package com.cg.pp.dto;

public class CustomerData {
	
	private int custmerId;
	
	private int balMoney;
	private int transaction;
	private TransactionType transType;
	private String comment;
	public CustomerData(int custmerId, int balMoney, int transaction,
			TransactionType transType, String comment) {
		super();
		this.custmerId = custmerId;
		this.balMoney = balMoney;
		this.transaction = transaction;
		this.transType = transType;
		this.comment = comment;
	}
	public int getCustmerId() {
		return custmerId;
	}
	public void setCustmerId(int custmerId) {
		this.custmerId = custmerId;
	}
	public int getBalMoney() {
		return balMoney;
	}
	public void setBalMoney(int balMoney) {
		this.balMoney = balMoney;
	}
	public int getTransaction() {
		return transaction;
	}
	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}
	public TransactionType getTransType() {
		return transType;
	}
	public void setTransType(TransactionType transType) {
		this.transType = transType;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Account No.=" + custmerId + ", Balance="
				+ balMoney + ", Transaction=" + transaction  + ", Transaction Type=" + comment + "]";
	}
	

	
}
