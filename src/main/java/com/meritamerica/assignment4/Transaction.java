package com.meritamerica.assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Transaction {
	private BankAccount sourceAccount;
	private BankAccount targetAccount;
	private double amount;
	private String reason;
	private Date transactionDate;
	public BankAccount getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(BankAccount sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public BankAccount getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(BankAccount targetAccount) {
		this.targetAccount = targetAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public java.util.Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(java.util.Date date) {
		transactionDate = date;
	}

	public String writeToString() {

	}

	public static Transaction readFromString(String transactionDataString) throws ParseException {
		String [] tran = transactionDataString.split(",");
    	SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
    	int source = Integer.parseInt(tran[0]);
    	int target = Integer.parseInt(tran[1]);
    	double amount = Double.parseDouble(tran[2]);
    	Date accountOpenedOn = date.parse(tran[3]);
    	boolean isDeposit = false;
    	if(amount > 0) {
    		isDeposit = true;
    	}
    	if(source == -1) {
    		source = target;
    	}
    	if(isDeposit) {
    		TransferTransaction newTT = new TransferTransaction(MeritBank.getBankAccount(source), MeritBank.getBankAccount(target), amount);
    		newTT.setTransactionDate(accountOpenedOn);
    		return newTT;
    	} else {
    		WithdrawTransaction newWT = new WithdrawTransaction(MeritBank.getBankAccount(target), amount);
    		newWT.setTransactionDate(accountOpenedOn);
    		newWT.setSourceAccount(MeritBank.getBankAccount(source));
    		return newWT;
    	}
	}

	public abstract void process() throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		
	}

	public boolean isProcessedByFraudTeam() {

	}

	public void setProcessedByFraudTeam(boolean isProcessed) {

	}

	public String getRejectionReason() {
		return
	}

	public void setRejectionReason(String reason) {
		this.reason = reason;
	}

}
