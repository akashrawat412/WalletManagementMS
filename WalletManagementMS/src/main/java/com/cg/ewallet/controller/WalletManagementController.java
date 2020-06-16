
/****************************************************************************************************************************
 - File Name      : Wallet Management Controller
 - Author           : Akash Singh Rawat
 - Creation Date    : 11-06-2020
 - Description      : This is an end point controller to consume Wallet Management Services.
  ****************************************************************************************************************************/


package com.cg.ewallet.controller;



import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ewallet.exception.WalletNotFoundException;
import com.cg.ewallet.service.WalletManagementServiceImpl;

@RestController
@Validated
public class WalletManagementController {
    
	@Autowired
	private WalletManagementServiceImpl service;
	
	
	/****************************************************************************************************************************
	 - Method Name      : addAmountToWallet
	 - Input Parameters : long mobileNumber, double amount
	 - Return type      : ResponseEntity<String>
	 - Author           : Akash Singh Rawat
	 - Creation Date    : 11-06-2020
	 - Description      : Method for Updating the EXISTING wallet account balance.
	 -End point URL     : http://localhost:9095/addAmountToWallet/{mob}/{amount}
	  ****************************************************************************************************************************/ 
        
	@PutMapping("/addAmountToWallet/{mob}/{amount}")
		public ResponseEntity<String> addAmountToWallet(@PathVariable("mob") Long mob,@PathVariable("amount") Double amount)
				throws WalletNotFoundException
		
		{
			return ResponseEntity.ok(service.addAmountToWallet( mob, amount));
		}
		
	    /****************************************************************************************************************************
		 - Method Name      : getBalanceByMobileNumber
		 - Input Parameters : long mobileNumber
		 - Return type      : ResponseEntity<Double>
		 - Author           : Akash Singh Rawat
		 - Creation Date    : 11-06-2020
		 - Description      : Method for checking a registered wallet Balance.
		 -End point URL     : http://localhost:9095/getBalance/{mob}
		  ****************************************************************************************************************************/ 
	    
		@GetMapping("/getBalance/{mob}")
		public ResponseEntity<Double> getBalanceByMobileNumber(@PathVariable("mob") Long mob)
				throws WalletNotFoundException
		{
			return ResponseEntity.ok(service.getBalanceByMobileNumber( mob));
		}
		
		
		
		/****************************************************************************************************************************
		 - Method Name      : transferMoney
		 - Input Parameters : long mobileNumbers, double amount
		 - Return type      : ResponseEntity<String>
		 - Author           : Akash Singh Rawat
		 - Creation Date    : 11-06-2020
		 - Description      : Method for transferring funds from a registered wallet account to another registered wallet account.
		 -End point URL     : http://localhost:9095/transferMoney/{mob1}/{mob2}/{amount}
		  ****************************************************************************************************************************/ 
		@PutMapping("/transferMoney/{mob1}/{mob2}/{amount}")
		public ResponseEntity<String> transferMoney( @PathVariable("mob1") Long mob1,@PathVariable("mob2") Long mob2,@PathVariable("amount") Double amount)
				throws WalletNotFoundException 
		{
			return ResponseEntity.ok(service.transferFunds(mob1, mob2, amount));
		}
		
		/****************************************************************************************************************************
		 - Method Name      : mobileRecharge
		 - Input Parameters : long mobileNumbers, double amount
		 - Return type      : ResponseEntity<String>
		 - Author           : Akash Singh Rawat
		 - Creation Date    : 11-06-2020
		 -End point URL     : http://localhost:9095/mobileRecharge/{mob}/{mob2}/{amount}
		  ****************************************************************************************************************************/
		@PutMapping("/mobileRecharge/{mob}/{mob2}/{amount}")
		public ResponseEntity<String> mobileRecharge(@PathVariable("mob") long mob,@Min(7000000000L)@Max(9999999999L) @PathVariable("mob2") long mob2, @PathVariable("amount") double amount)
		throws WalletNotFoundException
		{
			return ResponseEntity.ok(service.mobileRecharge(mob, mob2, amount));
		}
}
