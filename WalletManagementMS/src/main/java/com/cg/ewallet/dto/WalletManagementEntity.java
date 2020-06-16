/****************************************************************************************************************************
 - File Name      : Wallet Management Entity
 - Author           : Akash Singh Rawat
 - Creation Date    : 11-06-2020
 - Description      : This is an Entity Class of WalletManagementService which maps the instance variable with Hotel table columns.
  ****************************************************************************************************************************/
package com.cg.ewallet.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="wallet_management")
public class WalletManagementEntity {
	@Id
	@Column(name="mobilenumber")
	@Min(7000000000L)
	@Max(9999999999L)
	private long mobileNumber;
	
	@NotBlank(message = "Account Holder name is mandatory")
	@NotNull(message = "Account Holder name is mandatory")
	@Column(name = "name")
	@Pattern(regexp ="(^[a-zA-Z]+$)", message = "Account Holder name can only be in alphabets.")	
	private String name;
	
	@Size(min = 12, max = 30)
	@Column(name = "email")
	@NotBlank(message = "email address is mandatory")
	@NotNull(message = "email address is mandatory")
	private String email;
	
	@NotNull(message="Balance can't be null.")
	@Min(value=0, message="Balance should be positive.")
	@Column(name="balance")
	private double balance;
	
	@Size(min = 8, max = 30)
	@Column(name = "password")
	@NotBlank(message = "Password is mandatory")
	@NotNull(message = "Password is mandatory")
	private String password;
	
	public WalletManagementEntity(long mobileNumber, String name, String email, double balance, String password) {
		super();
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.password = password;
	}
	public WalletManagementEntity() {
		super();
		
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "WalletManagementEntity [mobileNumber=" + mobileNumber + ", name=" + name + ", email=" + email
				+ ", balance=" + balance + ", password=" + password + "]";
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
