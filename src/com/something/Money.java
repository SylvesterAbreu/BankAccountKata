package com.something;

public class Money {

	private Amount currentAmount = new Amount();

	public Money(Amount initialAmount) {
		this.currentAmount = initialAmount;
	}

	public Amount currentAmount() {
		return currentAmount;
	}

	public void addAmount(Amount amount) {
		if(amount.value() > 0) {
			addNewAmount(amount);
		}
	}

	private void addNewAmount(Amount amount) {
		final double newAmount = this.currentAmount.value() + amount.value();
		this.currentAmount = new Amount(newAmount);
	}

	public void removeAmount(Amount amountToBeWithdrew) {
		if(amountToBeWithdrew.value() < 0.0)
			return;
		final double amountAfterWithdraw = currentAmount.value() - (amountToBeWithdrew.value());
		currentAmount = new Amount(amountAfterWithdraw);
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Money)) return false;

		Money money = (Money) o;

		if(!currentAmount.equals(money.currentAmount)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return currentAmount.hashCode();
	}
}
