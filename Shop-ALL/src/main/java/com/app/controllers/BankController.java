package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.NetBankingDaoIntf;

import pojos.BankAccount;

@RestController
@RequestMapping("/accts")
public class BankController {
	@Autowired
	private NetBankingDaoIntf dao;

	@GetMapping("/{custId}/{pin}")
	public ResponseEntity<?> fetchAccountSummary(@PathVariable int custId, @PathVariable String pin) {
		System.out.println("in fetch " + custId + " " + pin);
		try {
			BankAccount a = dao.fetchAccountSummary(custId, pin);
			return new ResponseEntity<BankAccount>(a, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<String>("Fetching a/c info failed " + e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public ResponseEntity<String> createAccount(@RequestBody BankAccount a) {
		System.out.println("in create a/c "+a);
		try {
			return new ResponseEntity<String>(dao.createAccount(a), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<String>("Creating a/c info failed " + e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
	@DeleteMapping("/{custId}/{pin}")
	public ResponseEntity<String> deleteAccount(@PathVariable int custId, @PathVariable String pin) {
		System.out.println("in del " + custId + " " + pin);
		try {
			BankAccount a = dao.fetchAccountSummary(custId, pin);
		    String status=dao.closeAccount(a)	;
			return new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<String>("Closing  a/c info failed " + e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/{amount}")
	public ResponseEntity<?> updateAccount(@RequestBody BankAccount a,@PathVariable double amount) {
		System.out.println("in update a/c "+a);
		try {
			a.setBalance(a.getBalance()+amount);
			return new ResponseEntity<BankAccount>(dao.updateAccount(a), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<String>("Updating a/c info failed " + e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}


}
