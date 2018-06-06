package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojos.BankAccount;

@Repository
@Transactional
public class NetBankingDaoImpl implements NetBankingDaoIntf {
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional(readOnly=true)
	public BankAccount fetchAccountSummary(int id1, String pin2) {
		String jpql = "select a from BankAccount a where a.acctId=:id and a.pin=:pin1";
		return sf.getCurrentSession().createQuery(jpql, BankAccount.class).setParameter("id", id1)
				.setParameter("pin1", pin2).getSingleResult();
	}

	@Override
	public String createAccount(BankAccount a) {
		sf.getCurrentSession().save(a);
		return "Bank A/C created with ID"+a.getAcctId();
	}

	@Override
	public BankAccount updateAccount(BankAccount a) {
		sf.getCurrentSession().update(a);
		return a;
	}

	@Override
	public String closeAccount(BankAccount a) {
		sf.getCurrentSession().delete(a);
		return "A/C with ID "+a.getAcctId()+ "closed successfully";
	}
	
}
