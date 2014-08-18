package com.something;

public class BankAccount {

	private Money money;
	private boolean active;

	public BankAccount() {
		money = new Money(new Amount());
		active = false;
	}

	public BankAccount(double accountOpeningAmount) {
		final Amount newAmount = new Amount(accountOpeningAmount);
		money = new Money(newAmount);
		active = true;
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

	public boolean isActive() {
		return active;
	}
}
