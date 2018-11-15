package com.cg.pp.service;

import java.util.Map;

import com.cg.pp.dto.Customer;
import com.cg.pp.dto.CustomerData;
import com.cg.pp.exception.CustomerException;

public interface CustomerService {
	public Map<Integer,CustomerData> printTransaction(int cId);
	public int withdraw(int cId,int money);
	public int fundTransfer(int cId,int tId,int fMoney);
	public boolean createAccount(int custId,Customer cust);
	public int showBalance(int cId);
	public int deposit(int cId,int money);
	public Map<Integer,Customer> showCustomer();
	public boolean checkId(String cId) throws CustomerException;
	public boolean checkInt(String str) throws CustomerException;
	public boolean validateName(String str) throws CustomerException;
	public boolean validatePass(String pass)throws CustomerException;
	public boolean valdateMobile(String mobNo)throws CustomerException;
	public boolean validateAdhar(String adhrCard)throws CustomerException;
	public boolean validateAccType(String accType)throws CustomerException;
	public boolean checkPassword(String accNo, String pass)throws CustomerException;
}
