package test.calistenics.bankaccount;

import org.junit.Test;

import java.calistenics.bankAccount.Amount;
import java.calistenics.bankAccount.BankAccount;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BankAccountTest {

	@Test
	public void aBankAccountShouldBeEmptyWhenCreated() {
		final BankAccount bankAccount = new BankAccount();
		final Amount bankAccountBalance = bankAccount.currentBalance();
		final double currentAmount = bankAccountBalance.value();

		assertThat(currentAmount, is(equalTo(0.0)));
	}

	@Test
	public void
	shouldBeAbleToAcceptPositiveDepositsWhereAfterWardsCurrentBalanceIsTen() {
		final BankAccount bankAccount = new BankAccount();
		final Amount newAmount = new Amount(56.87);
		bankAccount.deposit(newAmount);

		final Amount currentBalance = bankAccount.currentBalance();

		assertThat(currentBalance.value(), is(56.87));
	}

	@Test
	public void
	shouldBeAbleToAcceptPositiveWithDrawsWhereAfterWardsCurrentBalanceIsTen() {
		final BankAccount bankAccount = new BankAccount();

		final Amount amountDeposit = new Amount(1000.00);
		bankAccount.deposit(amountDeposit);

		final Amount amountWithdrawn = new Amount(100.00);
		bankAccount.withdraw(amountWithdrawn);

		final Amount currentBalance = bankAccount.currentBalance();

		assertThat(currentBalance.value(), is(56.87));
	}

	@Test
	public void
	shouldBeAbleToDeclineNegativeDeposits() {

	}
}
