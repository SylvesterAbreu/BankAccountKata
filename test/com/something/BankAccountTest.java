package com.something;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class BankAccountTest {

	@Test
	public void
	shouldHaveZeroBalanceWhenCreated() {
		final BankAccount bankAccount = new BankAccount();
		final Amount amount = bankAccount.currentBalance();

		assertThat(amount.value(), is(0.0));
	}

	@Test
	public void
	shouldBeAbleToAcceptPositiveDeposits() {
		final BankAccount bankAccount = new BankAccount();
		final Amount positiveDeposit = new Amount(24.99);
		bankAccount.deposit(positiveDeposit);

		final Amount newAmount = bankAccount.currentBalance();

		assertThat(newAmount.value(), is(24.99));
	}

	@Test
	public void
	shouldBeAbleToIgnoreNegativeDeposits() {
		final BankAccount bankAccount = new BankAccount();
		final Amount negativeDeposit = new Amount(-34.76);
		bankAccount.deposit(negativeDeposit);

		final Amount currentBalance = bankAccount.currentBalance();

		assertThat(currentBalance.value(), is(0.0));
	}

	@Test
	public void
	shouldIgnoreNegativeWithDrawsWhereAfterWardsCurrentBalanceIsPositive() {
		final BankAccount bankAccount = new BankAccount(30.00);
		final Amount negativeWithdraw = new Amount(-20.99);
		bankAccount.withdraw(negativeWithdraw);

		final Amount currentBalance = bankAccount.currentBalance();

		assertThat(currentBalance.value(), is(30.0));
	}

	@Test
	public void
	shouldBeAbleToDeclineNegativeWithdraws() {
		fail();
	}
}
