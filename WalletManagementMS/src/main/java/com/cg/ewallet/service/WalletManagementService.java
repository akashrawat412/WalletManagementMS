package com.cg.ewallet.service;


import com.cg.ewallet.exception.WalletNotFoundException;

public interface WalletManagementService {
	
	public abstract String addAmountToWallet(long mob,double amount) throws WalletNotFoundException;	
	public abstract double getBalanceByMobileNumber(long mobileNumber) throws WalletNotFoundException;
	public abstract String transferFunds(long mob1,long mob2,double amount) throws WalletNotFoundException;
	public abstract String mobileRecharge(long mob, long mob2, double amount) throws WalletNotFoundException;
}