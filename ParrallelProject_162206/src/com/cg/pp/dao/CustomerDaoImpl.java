package com.cg.pp.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.cg.pp.dto.Customer;
import com.cg.pp.dto.CustomerData;
import com.cg.pp.dto.TransactionType;
import com.cg.pp.util.CUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Map<Integer, CustomerData> printTransaction(int cId) {
		int f = 1;
		Map<Integer, CustomerData> tMap = new HashMap<Integer, CustomerData>();
		Map<Integer, CustomerData> hMap = CUtil.showCustomerData();
		Iterator<CustomerData> it = hMap.values().iterator();
		CustomerData temp = null;
		while (it.hasNext()) {
			temp = (CustomerData) it.next();
			if (temp.getCustmerId() == cId) {
				tMap.put(f++, temp);
			}
		}

		return tMap;
	}

	@Override
	public int withdraw(int cId, int wMoney) {
		if (wMoney > 0) {
			Map<Integer, CustomerData> cMap = CUtil.showCustomerData();
			Iterator<CustomerData> it = cMap.values().iterator();
			CustomerData temp = null;
			int tmpMoney = 0;
			while (it.hasNext()) {
				temp = (CustomerData) it.next();
				if (temp.getCustmerId() == cId) {
					tmpMoney = temp.getBalMoney();
				}
			}
			if (wMoney > tmpMoney) {
				return -1;
			} else {
				tmpMoney = tmpMoney - wMoney;
				CustomerData cData = new CustomerData(cId, tmpMoney, wMoney,
						TransactionType.Withdrawl, "Self");
				boolean flag = CUtil.addCustomerData(cData);
				if (flag == true) {
					return 0;
				} else {
					return 1;
				}
			}
		}
		return 1;

	}

	@Override
	public int fundTransfer(int cId, int tId, int fMoney) {

		Map<Integer, CustomerData> cMap = CUtil.showCustomerData();
		Iterator<CustomerData> it = cMap.values().iterator();
		CustomerData temp = null;
		int tmpMoney = 0;
		int tmpMoney2 = 0;
		while (it.hasNext()) {
			temp = (CustomerData) it.next();
			if (temp.getCustmerId() == cId) {
				tmpMoney = temp.getBalMoney();
			} else if (temp.getCustmerId() == tId) {
				tmpMoney2 = temp.getBalMoney();
			}
		}
		if (fMoney > tmpMoney) {
			return -1;
		} else {
			tmpMoney -= fMoney;
			tmpMoney2 += fMoney;
			String str1 = "Transferred to Account No." + tId;
			String str2 = "Transferred from Account No." + cId;
			CustomerData cData = new CustomerData(cId, tmpMoney, fMoney,
					TransactionType.Fund, str1);
			CustomerData cData2 = new CustomerData(tId, tmpMoney2, fMoney,
					TransactionType.Fund, str2);
			boolean flag = CUtil.addCustomerData(cData);
			boolean flag2 = CUtil.addCustomerData(cData2);
			if (flag == true) {
				if (flag2 == true) {
					return 0;
				}
			}

			return 1;

		}
	}

	@Override
	public boolean createAccount(int custId, Customer cust) {
		if (CUtil.addCustomer(custId, cust) == true) {
			int dMoney = Integer.parseInt(cust.getOpeningBalance());
			String str = " Debited as Opening Balance";
			CustomerData cData = new CustomerData(custId, dMoney, dMoney,
					TransactionType.Deposit, str);
			CUtil.addCustomerData(cData);
			return true;
		}
		return false;
	}

	@Override
	public int showBalance(int cId) {
		Map<Integer, CustomerData> hMap = CUtil.showCustomerData();
		Iterator<CustomerData> it = hMap.values().iterator();
		CustomerData temp = null;
		int tmpMoney = 0;
		while (it.hasNext()) {
			temp = (CustomerData) it.next();
			if (temp.getCustmerId() == cId) {
				tmpMoney = temp.getBalMoney();
			}
		}
		return tmpMoney;
	}

	@Override
	public int deposit(int cId, int dMoney) {
		if (dMoney > 0) {
			Map<Integer, CustomerData> cMap = CUtil.showCustomerData();
			Iterator<CustomerData> it = cMap.values().iterator();
			CustomerData temp = null;
			int tmpMoney = 0;
			while (it.hasNext()) {
				temp = (CustomerData) it.next();
				if (temp.getCustmerId() == cId) {
					tmpMoney = temp.getBalMoney();
				}
			}
			tmpMoney += dMoney;
			CustomerData cData = new CustomerData(cId, tmpMoney, dMoney,
					TransactionType.Deposit, "Self");
			boolean flag = CUtil.addCustomerData(cData);
			if (flag == true) {
				return 0;
			} else {
				return 1;
			}
		}
		return 1;
	}

	@Override
	public Map<Integer, Customer> showCustomer() {

		return CUtil.fetchCustomer();
	}

}