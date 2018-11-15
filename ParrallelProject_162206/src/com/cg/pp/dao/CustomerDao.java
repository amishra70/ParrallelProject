package com.cg.pp.dao;

import java.util.Map;

import com.cg.pp.dto.Customer;
import com.cg.pp.dto.CustomerData;

public interface CustomerDao {
	public Map<Integer, CustomerData> printTransaction(int cId);

	public int withdraw(int cId, int money);

	public int fundTransfer(int cId,int tId,int fMoney);

	public boolean createAccount(int custId, Customer cust);

	public int showBalance(int cId);

	public int deposit(int cId, int money);
	public Map<Integer,Customer> showCustomer();
}
