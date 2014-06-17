package com.something;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankAccountTest {

	@Test
	public void haveZeroBalanceWhenCreated() {
		final BankAccount bankAccount = new BankAccount();
		final Amount amount = bankAccount.currentBalance();

		assertThat(amount.value(), is(0.0));
	}

	@Test
	public void acceptsPositiveDeposits() {
		final BankAccount bankAccount = new BankAccount();
		final Amount positiveDeposit = new Amount(24.99);
		bankAccount.deposit(positiveDeposit);

		final Amount newAmount = bankAccount.currentBalance();

		assertThat(newAmount.value(), is(24.99));
	}

	@Test
	public void ignoresNegativeDeposits() {
		final BankAccount bankAccount = new BankAccount();
		final Amount negativeDeposit = new Amount(-34.76);
		bankAccount.deposit(negativeDeposit);

		final Amount currentBalance = bankAccount.currentBalance();

		assertThat(currentBalance.value(), is(0.0));
	}

	@Test
	public void acceptsPositiveWithdraws() {
		final BankAccount bankAccount = new BankAccount(200.00);
		final Amount positiveWithdraw = new Amount(24.99);
		bankAccount.withdraw(positiveWithdraw);

		final Amount balanceAfterWithdraw = bankAccount.currentBalance();

		assertThat(balanceAfterWithdraw.value(), is(175.01));
	}

	@Test
	public void ignoresNegativeWithdraws() {
		final BankAccount bankAccount = new BankAccount(200.00);
		final Amount negativeAmount = new Amount(-20.00);
		bankAccount.withdraw(negativeAmount);

		final Amount currentBalance = bankAccount.currentBalance();

		assertThat(currentBalance.value(), is(200.0));
	}
}
