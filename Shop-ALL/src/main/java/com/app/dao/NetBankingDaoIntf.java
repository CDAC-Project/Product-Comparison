package com.app.dao;

import pojos.BankAccount;

public interface NetBankingDaoIntf {
	BankAccount fetchAccountSummary(int id,String pin);
	String createAccount(BankAccount a);
	BankAccount updateAccount(BankAccount a);
	String closeAccount(BankAccount a);
	
}
