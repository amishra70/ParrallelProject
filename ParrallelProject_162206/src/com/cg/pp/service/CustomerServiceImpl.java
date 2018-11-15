package com.cg.pp.service;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import com.cg.pp.dao.CustomerDao;
import com.cg.pp.dao.CustomerDaoImpl;
import com.cg.pp.dto.Customer;
import com.cg.pp.dto.CustomerData;
import com.cg.pp.exception.CustomerException;

public class CustomerServiceImpl implements CustomerService {
	static CustomerDao cDao = null;

	public CustomerServiceImpl() {
		
		cDao = new CustomerDaoImpl();
	}

	

	@Override
	public boolean createAccount(int custId, Customer cust) {

		return cDao.createAccount(custId, cust);
	}

	@Override
	public Map<Integer, CustomerData> printTransaction(int cId) {
		return cDao.printTransaction(cId);
	}

	@Override
	public int withdraw(int cId, int money) {
		return cDao.withdraw(cId, money);
	}

	@Override
	public int showBalance(int cId) {
		return cDao.showBalance(cId);
	}

	@Override
	public int deposit(int cId, int money) {
		return cDao.deposit(cId, money);
	}

	@Override
	public Map<Integer, Customer> showCustomer() {
		return cDao.showCustomer();
	}



	@Override
	public int fundTransfer(int cId, int tId, int fMoney) {
		return cDao.fundTransfer(cId, tId, fMoney);
	}



	@Override
	public boolean checkId(String cId) throws CustomerException {
		Map<Integer,Customer> hMap = cDao.showCustomer();
		Iterator<Customer> it = hMap.values().iterator();
		Customer temp = null;
		while(it.hasNext()){
			temp = (Customer) it.next();
			if(temp.getCustId() == Integer.parseInt(cId)){
				return true;
			}
		}
		throw new CustomerException("Wrong Input. The Account no.does not exit.");
	}



	@Override
	public boolean checkInt(String str) throws CustomerException {
		String myPattern = "[1-9][0-9]+";
		if(Pattern.matches(myPattern,str)){
			return true;
		}
		else{
			throw new CustomerException("Wrong Input. Please Enter a "
					+ "valid number eg. 2541");
		}
	}



	@Override
	public boolean validateName(String str) throws CustomerException {
		String myPattern =  "[A-Z][a-z]+";
		String myPattern1 =  "[A-Z][a-z]+[ ][A-Z][a-z]+";
		String myPattern2 = "[A-Z][a-z]+[ ][A-Z][a-z]+[ ][A-Z][a-z]+"; 
		if(Pattern.matches(myPattern,str)){
			return true;
		}
		else if(Pattern.matches(myPattern1,str)){
			return true;
		}
		else if(Pattern.matches(myPattern2,str)){
			return true;
		}
		else{
			throw new CustomerException("Invalid Name should start with Capital"
					+ " and should contain char only");
		}
		
	}



	@Override
	public boolean validatePass(String pass) throws CustomerException {
		String myPattern = "[0-9]+";
		if(Pattern.matches(myPattern,pass)){
			return true;
		}
		else{
			throw new CustomerException("Wrong Input. Please Enter a "
					+ "valid number eg. 2541");
		}
	}



	@Override
	public boolean valdateMobile(String mobNo) throws CustomerException {
		String myPattern = "[6-9][0-9]{9}";
		if(Pattern.matches(myPattern,mobNo)){
			return true;
		}
		else{
			throw new CustomerException("Wrong Input.You can only enter number "
					+ "and Mobile No.can only start from 6-9 and can contain 10 digits only");
		}
	}



	@Override
	public boolean validateAdhar(String adhrCard) throws CustomerException {
		String myPattern = "[0-9]{12}";
		if(Pattern.matches(myPattern,adhrCard)){
			return true;
		}
		else{
			throw new CustomerException("Wrong Input. You can only enter number "
					+ "and Aadhar Card contains 12 digits only");
		}
	}



	@Override
	public boolean validateAccType(String accType) throws CustomerException {
		String myPattern = "[1-2]";
		if(Pattern.matches(myPattern,accType)){
			return true;
		}
		else{
			throw new CustomerException("Wrong Input. You can only enter 1 or 2.");
		}
	}



	@Override
	public boolean checkPassword(String accNo, String pass) throws CustomerException {
		
		Map<Integer,Customer> hMap = cDao.showCustomer();
		Iterator<Customer> it = hMap.values().iterator();
		Customer temp = null;
		while(it.hasNext()){
			temp = (Customer) it.next();
			if((temp.getCustId() == Integer.parseInt(accNo))&&
					(temp.getPassword().equals(pass))){
				return true;
			}
		}
		throw new CustomerException("Wrong Input. The Account no. and Password does not match.");
	}

}
