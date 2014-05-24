package java.calistenics.bankAccount;

public class BankAccount {

	private Money money = new Money(new Amount());

	public Amount currentBalance() {
		final Amount currentBalance = money.currentAmount();

		return currentBalance;
	}

	public void withdraw(Amount amount) {
		money.removeAmount(amount);
	}

	public void deposit(Amount amount) {
		money.addAmount(amount);
	}
}
