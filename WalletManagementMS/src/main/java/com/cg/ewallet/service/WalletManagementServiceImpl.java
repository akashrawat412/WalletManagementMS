/****************************************************************************************************************************
- File Name      	: WalletManagementServiceImpl
- Author           : Akash Singh Rawat
- Creation Date    : 11-06-2020
- Description      : This is a service class which contains the business logic of Wallet Management Service
 ****************************************************************************************************************************/

package com.cg.ewallet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ewallet.dao.WalletManagementRepository;
import com.cg.ewallet.dto.WalletManagementEntity;
import com.cg.ewallet.exception.WalletNotFoundException;


@Service
public class WalletManagementServiceImpl implements WalletManagementService {

	
	
	@Autowired
    private WalletManagementRepository repository;
	
	/****************************************************************************************************************************
	 * - Method Name : addAmountToWallet
	 * - Input Parameters : long mobile number, double amount
	 * - Return type : String 
	 * - Author : Akash Singh Rawat
	 * - Creation Date : 11-6-2020 -
	 * Description : Method to add amount to a specific registered wallet.
	 * 
	 ****************************************************************************************************************************/
	@Override
	public String addAmountToWallet(long mob,double amount) throws WalletNotFoundException{
		
		Optional<WalletManagementEntity> optional = repository.findById(mob);
		if(optional.isPresent())
		{
		WalletManagementEntity wallet=optional.get();
		wallet.setBalance(wallet.getBalance()+amount);
		repository.save(wallet);
		return "Yayy!!Amount added Successfully to Wallet";
		}
		else
		{
			throw new WalletNotFoundException("SAD!!You don't have a registered Payment Wallet Account.");
		}
}
	/****************************************************************************************************************************
	 * - Method Name : getBalanceByMobileNumber
	 * - Input Parameters : long mobile number, double balance
	 * - Return type : Double Balance 
	 * - Author : Akash Singh Rawat
	 * - Creation Date : 11-6-2020 -
	 * Description : Method to check the Wallet Balance of a Registered Wallect account..
	 * 
	 ****************************************************************************************************************************/
	@Override
	public double getBalanceByMobileNumber(long mob) throws WalletNotFoundException
	{
		Optional<WalletManagementEntity> wallet = repository.findById(mob);
		if(wallet.isPresent()) {
			return wallet.get().getBalance();
		}
		else {
			
			throw new WalletNotFoundException("Heyy there!!!Wallet not found for given Mobile Number");
		}
	}
	
	/****************************************************************************************************************************
	 * - Method Name : transferFunds
	 * - Input Parameters : long mobile number, double balance
	 * - Return type : String 
	 * - Author : Akash Singh Rawat
	 * - Creation Date : 11-6-2020 -
	 * Description : Method to transfer funds from one registered wallet account to another registered wallet account.
	 * 
	 ****************************************************************************************************************************/
	@Override
	public String transferFunds(long mob1, long mob2, double amount) throws WalletNotFoundException {
		Optional<WalletManagementEntity> optional1 = repository.findById(mob1);
		WalletManagementEntity wallet1 = optional1.get();
		Optional<WalletManagementEntity> optional2 = repository.findById(mob2);
		

		
		if((optional1.isPresent())&& (optional2.isPresent()))
		{
			if(wallet1.getBalance()>amount)
	{   
				WalletManagementEntity wallet2=optional2.get();
		wallet1.setBalance(wallet1.getBalance()-amount);
		wallet2.setBalance(wallet2.getBalance()+amount);
		repository.save(wallet1);
		repository.save(wallet2);
		return "Hurray!!!Money Transferred Successfully";
	}
			else
				return"Oops!!!!Insufficient Funds to Transfer.";
				
			}
		else
		{
			throw new WalletNotFoundException("Sorry, Wallet not found for given Mobile Number");
		}
		
	}
	
	/****************************************************************************************************************************
	 * - Method Name : mobileRecharge
	 * - Input Parameters : long mobile number, double amount
	 * - Return type : String 
	 * - Author : Akash Singh Rawat
	 * - Creation Date : 11-6-2020 -
	 * Description : Method to Re-charge any mobile number.
	 * 
	 ****************************************************************************************************************************/
	@Override
	public String mobileRecharge(long mob, long mob2, double amount) throws WalletNotFoundException
	{     
		Optional<WalletManagementEntity> optional = repository.findById(mob);
		WalletManagementEntity wallet = optional.get();
		if(optional.isPresent())
		{ if(wallet.getBalance()> amount) 
		    {
			wallet.setBalance(wallet.getBalance()-amount);
			repository.save(wallet);
			return "Ta-da!!Recharge done successfully.Enjoy talking and Internet Plan.";
		    }
		else {
			return "Oops!!!!Insufficient Balance";
		}
		}
		else
		{
		throw new WalletNotFoundException("Heyy THERE!!!You are not a registered Wallet account holder.");
		}
		
	}


}