/****************************************************************************************************************************
 - File Name      	: WalletManagementRepository
 - Author           : Akash Singh Rawat
 - Creation Date    : 11-06-2020
 - Description      : This is an interface for WalletManagementService which extends JpaRepository to perform all the basic crud operations
  ****************************************************************************************************************************/
package com.cg.ewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ewallet.dto.WalletManagementEntity;

public interface WalletManagementRepository extends JpaRepository<WalletManagementEntity, Long>{

	
} 
