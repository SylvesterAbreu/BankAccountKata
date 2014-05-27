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
	shouldAcceptPositiveDeposits() {
		final BankAccount bankAccount = new BankAccount();
		final Amount positiveDeposit = new Amount(24.99);
		bankAccount.deposit(positiveDeposit);

		final Amount newAmount = bankAccount.currentBalance();

		assertThat(newAmount.value(), is(24.99));
	}

	@Test
	public void
	shouldIgnoreNegativeDeposits() {
		final BankAccount bankAccount = new BankAccount();
		final Amount negativeDeposit = new Amount(-34.76);
		bankAccount.deposit(negativeDeposit);

		final Amount currentBalance = bankAccount.currentBalance();

		assertThat(currentBalance.value(), is(0.0));
	}

	@Test
	public void
	shouldIgnoreNegativeWithdraws() {
		fail();
	}
}
