package com.something;

public class BankAccount {

	private Money money;

	public BankAccount() {
		money = new Money(new Amount());
	}

	public BankAccount(double accountOpeningAmount) {
		final Amount newAmount = new Amount(accountOpeningAmount);
		money = new Money(newAmount);
	}

	public Amount currentBalance() {
		final Amount currentBalance = money.currentAmount();

		return currentBalance;
	}

	public void deposit(Amount amount) {
		money.addAmount(amount);
	}

	public void withdraw(Amount amount) {
		money.removeAmount(amount);
	}
}
