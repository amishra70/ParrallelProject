package com.cg.pp.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.cg.pp.dto.AccountType;
import com.cg.pp.dto.Customer;
import com.cg.pp.dto.CustomerData;
import com.cg.pp.exception.CustomerException;
import com.cg.pp.service.CustomerService;
import com.cg.pp.service.CustomerServiceImpl;

public class UIMain {
	static Scanner sc = null;
	static CustomerService cService = null;
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(
			System.in));
	static int max = 1000000;
	static int min = 10000;
	static int range = max - min + 1;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);
		cService = new CustomerServiceImpl();
		while (true) {
			System.out.println("Welcome to XYZ Bank:\n"
					+ " Press 1 to Create Account\t"
					+ " Press 2 to Other Banking Activity\n"
					+ "Press 3 to Exit.");

			System.out.print("Enter Your Choice: ");
			String choice = sc.next();
			switch (Integer.parseInt(choice)) {
			case 1:
				createAccount();
				break;
			case 2:
				furtherActivity();
				break;
			case 7:
				showCustomer();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("You have entered wrong input");
				break;

			}
		}
	}

	private static void furtherActivity() {
		while(true){
		System.out.print("Please Enter your Account No.: ");
		String accNo = sc.next();
		try{
		if(cService.checkId(accNo)){
			while(true){
			System.out.print("Please Enter your Password: ");
			String pass = sc.next();
			try{
			if(cService.checkPassword(accNo,pass)){
				Inside_Loop: while (true) {
				int cId=Integer.parseInt(accNo);
			    System.out.println("Press 1 to Show Balance\t"
					+ " Press 2 to Deposit \t\t\t" + "Press 3 to Withdraw \n"
					+ " Press 4 to Fund Transfer \t\t"
					+ "Press 5 to Print Transaction\n"
					+ "Press 6 to go back to previous Menu.");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				showBalance(cId);
				break;
			case 2:
				deposit(cId);
				break;
			case 3:
				withdraw(cId);
				break;
			case 4:
				fundTransfer(cId);
				break;
			case 5:
				printTransaction(cId);
				break;
			case 6:
				break Inside_Loop;
			default:
				System.out.println("You have entered wrong input");
			}
			}break;
			}
			}catch(CustomerException e){
				System.out.println(e.getMessage());
			}
		}
		}
		}catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		}
	}

	private static void showCustomer() {
		Map<Integer, Customer> mmm = cService.showCustomer();
		Iterator<Customer> it = mmm.values().iterator();
		Customer cust = null;
		while (it.hasNext()) {
			cust = (Customer) it.next();
			System.out.println(cust);
		}

	}

	private static void printTransaction(int cId) {
		Map<Integer, CustomerData> mmm = cService.printTransaction(cId);
		Iterator<CustomerData> it = mmm.values().iterator();
		CustomerData cust = null;
		while (it.hasNext()) {
			cust = (CustomerData) it.next();
			// System.out.println(cust);
			System.out.println(cust);
		}

	}

	private static void fundTransfer(int cId) {
		while (true) {
		System.out.println("Enter the Amount of fund you want to transfer: ");
		String amnt = sc.next();
		try {
		if (cService.checkInt(amnt)) {
			while (true) {
			System.out.println("Enter the Account No. you want to transfer the fund: ");
			String acnt = sc.next();
			try {
			if (cService.checkId(acnt)) {
				int rValue = cService.fundTransfer(cId,Integer.parseInt(acnt),Integer.parseInt(amnt));
				if (rValue == 1) {
					System.out.println("Some Error Occured.");
				}
				else if (rValue == 0) {
					System.out.println(amnt+ "debited from your account "+ cId
											+ " and credited to Account No. "+ acnt);
				} 
				else if (rValue == -1) {
					System.out.println("You do not have enough balance.");
				}
				break;
			}
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
			}
			break;
		}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		}
	}

	private static void withdraw(int cId) {
		while(true){
		System.out.println("Enter the Amount you want to withdraw: ");
		String wMoney = sc.next();
		try{
			if(cService.checkInt(wMoney)){
		
		int rValue = cService.withdraw(cId, Integer.parseInt(wMoney));
		if (rValue == 1) {
			System.out.println("Some Error Occured.");
		} else if (rValue == 0) {
			System.out.println(wMoney + "debited from your account");
		} else if (rValue == -1) {
			System.out.println("You do not have enough balance.");
		}
			}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		}
	}

	private static void deposit(int cId) {
		while(true){
		System.out.println("Enter the Amount you want to deposit: ");
		String dMoney = sc.next();
		try {
			if(cService.checkInt(dMoney)){
			int rValue = cService.deposit(cId, Integer.parseInt(dMoney));
			if (rValue == 1) {
				System.out.println("Some Error Occured.");
			} else if (rValue == 0) {
				System.out.println(dMoney + "credited to your account");
			}
			}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		}
	}

	private static void showBalance(int cId) {
		int flag = cService.showBalance(cId);
		System.out.println("Your Available balance is: " + flag + "/-");

	}

	private static void createAccount() throws Exception {
		while (true) {
			System.out.print("Please enter Your Name: ");
			String cName = buffer.readLine();
			try {
			if (cService.validateName(cName)) {
				while (true) {
				System.out.print("Enter Aadhar Card Number: ");
				String adhrCard = buffer.readLine();
				try{
				if (cService.validateAdhar(adhrCard)) {
					while (true) {
					System.out.print("Enter Your Mobile No.: ");
					String mobNo = buffer.readLine();
					try {
					if (cService.valdateMobile(mobNo)) {
						while(true){
						System.out.print("Enter the Opening Amount: ");
						String openingAmount = buffer.readLine();
						try{
						if (cService.checkInt(openingAmount)) {
							while(true){
							System.out.println("Enter a password: ");
							String pass = buffer.readLine();
							try{
							if (cService.validatePass(pass)) {
								while(true){
								System.out.println("Enter Account Type: ");
								System.out.print("Press 1 for Saving Account & Press 2 for Current Account: ");
								String accType = buffer.readLine();
								AccountType accT = null;
								try{
								if (cService.validateAccType(accType)) {
									switch(accType){
									case "1":
										accT = AccountType.Saving;
										break;
									case "2":
										accT = AccountType.Current;
										break;
									}
									int rand = (int) (Math.random() * range)+ min;
									Customer cust1 = new Customer(rand, cName,openingAmount, mobNo,adhrCard,accT, pass);
									//Customer cust1 = null;
									boolean flag = cService.createAccount(rand, cust1);
									if (flag) {
										System.out.println("Data Added.to"+ rand);
									} 
									else {
										System.out.println("Shit Happened.");
									}
									break;
								}
								}catch(CustomerException e){
									System.out.println(e.getMessage());
								}
								}
								break;
								}
							}catch(CustomerException e){
								System.out.println(e.getMessage());
							}
							}break;
						}
						}catch(CustomerException e){
							System.out.println(e.getMessage());
						}
						}break;
					}
					} 
					catch (CustomerException e) {
						System.out.println(e.getMessage());
					}
					}
					break;
				}
				}catch (CustomerException e) {
					System.out.println(e.getMessage());
				}
				}
				break;
			}
			} 
			catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
