package com.something;

public class Money {

	private Amount currentAmount;

	public Money(Amount initialAmount) {
		this.currentAmount = initialAmount;
	}

	public Amount currentAmount() {
		return currentAmount;
	}

	public void addAmount(Amount amount) {
		if(amount.value() < 0) {
			return;
		}
		addNewAmount(amount);
	}

	private void addNewAmount(Amount amount) {
		final double newAmount = this.currentAmount.value() + amount.value();
		this.currentAmount = new Amount(newAmount);
	}

	public void removeAmount(Amount amountToBeWithdrew) {
		if(amountToBeWithdrew.value() < 0.0) {
			return;
		}
		removeNewAmount(amountToBeWithdrew);
	}

	private void removeNewAmount(Amount amountToBeWithdrew) {
		final double amountAfterWithdraw = currentAmount.value() - (amountToBeWithdrew.value());
		currentAmount = new Amount(amountAfterWithdraw);
	}
}
