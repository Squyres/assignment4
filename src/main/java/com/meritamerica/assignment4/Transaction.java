package com.meritamerica.assignment4;

public abstract class Transaction {
	private BankAccount sourceAccount;
	private BankAccount targetAccount;
	private double amount;
	private String reason;
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
		
	}

	public void setTransactionDate(java.util.Date date) {

	}

	public String writeToString() {

	}

	public static Transaction readFromString(String transactionDataString) {

	}

	public abstract void process() throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		
	}

	public boolean isProcessedByFraudTeam() {

	}

	public void setProcessedByFraudTeam(boolean isProcessed) {

	}

	public String getRejectionReason() {

	}

	public void setRejectionReason(String reason) {
		this.reason = reason;
	}

}
