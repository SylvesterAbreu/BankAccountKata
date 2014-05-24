package java.calistenics.bankAccount;

public class Money {

	private Amount currentAmount = new Amount();

	public Money(Amount intialAmount) {
		this.currentAmount = intialAmount;
	}

	public Amount currentAmount(){
		return currentAmount;
	}

	public void addAmount(Amount amount) {
		if (amount.value() > 0) {
			final double newAmount = this.currentAmount.value() + amount.value();
			this.currentAmount = new Amount(newAmount);
		}
	}

	public void removeAmount(Amount withdrawAmount) {
		final double amountAfterWithdraw = currentAmount.value() - withdrawAmount.value();
		if (amountAfterWithdraw > 0)
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
