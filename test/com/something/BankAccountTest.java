package com.something;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BankAccountTest {

	@Test
	public void haveZeroBalanceWhenCreated() throws Exception {
		final BankAccount bankAccount = new BankAccount();
		final Amount amount = bankAccount.currentBalance();

		assertThat(amount.value(), is(0.0));
	}

	@Test
	public void acceptsPositiveDeposits() throws Exception {
		final BankAccount bankAccount = new BankAccount();
		final Amount positiveDeposit = new Amount(24.99);
		bankAccount.deposit(positiveDeposit);

		final Amount newAmount = bankAccount.currentBalance();

		assertThat(newAmount.value(), is(24.99));
	}

	@Test
	public void ignoresNegativeDeposits() throws Exception {
		final BankAccount bankAccount = new BankAccount();
		final Amount negativeDeposit = new Amount(-34.76);
		bankAccount.deposit(negativeDeposit);

		final Amount currentBalance = bankAccount.currentBalance();

		assertThat(currentBalance.value(), is(0.0));
	}

	@Test
	public void acceptsPositiveWithdraws() throws Exception {
		final BankAccount bankAccount = new BankAccount(200.00);
		final Amount positiveWithdraw = new Amount(24.99);
		bankAccount.withdraw(positiveWithdraw);

		final Amount balanceAfterWithdraw = bankAccount.currentBalance();

		assertThat(balanceAfterWithdraw.value(), is(175.01));
	}

	@Test
	public void ignoresNegativeWithdraws() throws Exception {
		final BankAccount bankAccount = new BankAccount(200.00);
		final Amount negativeAmount = new Amount(-20.00);
		bankAccount.withdraw(negativeAmount);

		final Amount currentBalance = bankAccount.currentBalance();

		assertThat(currentBalance.value(), is(200.0));
	}

	@Test
	public void transferMoneyFromOneBankAccountToAnotherExistingOne() throws Exception {
		final BankAccount currentBankAccount = new BankAccount();
		final Amount amount = new Amount(200.0);
		currentBankAccount.deposit(amount);

		final BankAccount newBankAccount = new BankAccount();
		final Amount amountToBeTransferred = new Amount(75.0);
		final TransferMoney transferMoney = new TransferMoney();

		transferMoney.from(currentBankAccount, newBankAccount, amountToBeTransferred);

		final Amount currentBankAccountBalance = currentBankAccount.currentBalance();
		final Amount newBalance = new Amount(125.);

		assertThat(currentBankAccountBalance.value(), is(equalTo(newBalance.value())));
	}
}