package com.cg.pp.util;

import java.util.HashMap;
import java.util.Map;

import com.cg.pp.dto.Customer;
import com.cg.pp.dto.CustomerData;

public class CUtil {
	static int kk = 1;
	public static Map<Integer, Customer> map = new HashMap<Integer, Customer>();

	/* Customer Data */
	public static boolean addCustomer(int cId, Customer cust) {
		if (map.put(cId, cust) == null) {
			return true;
		}
		return false;
	}
	public static Map<Integer,Customer> fetchCustomer(){
		return map;
	}
	
	/* Customer Personal Data */
	public static Map<Integer, CustomerData> dMap = new HashMap<Integer, CustomerData>();
	public static boolean addCustomerData(CustomerData cData){
		if(dMap.put(kk++,cData)==null){
			return true;
		}
		return false;
	}
	public static Map<Integer, CustomerData> showCustomerData(){
		return dMap;
	}
}
