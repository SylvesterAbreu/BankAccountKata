package com.something;

public class TransferMoney {

	public boolean from(BankAccount currentBankAccount, BankAccount newBankAccount, Amount amountToBeTransferred) {
		if (amountToBeTransferred.value() > 0)
			transfer(currentBankAccount, newBankAccount, amountToBeTransferred);
		return false;
	}

	private boolean transfer(BankAccount currentBankAccount, BankAccount newBankAccount, Amount amountToBeTransferred) {
		final Amount currentBankAccountAmount = currentBankAccount.currentBalance();
		if (currentBankAccountAmount.isGreaterThan(amountToBeTransferred)) {
			return finaliseTransfer(currentBankAccount, newBankAccount, amountToBeTransferred);
		}
		return false;
	}

	private boolean finaliseTransfer(BankAccount currentBankAccount, BankAccount newBankAccount, Amount amountToBeTransferred) {
		currentBankAccount.withdraw(amountToBeTransferred);
		newBankAccount.deposit(amountToBeTransferred);
		return true;
	}
}
