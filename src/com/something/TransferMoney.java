package com.something;

public class TransferMoney {
	public boolean from(BankAccount currentBankAccount, BankAccount newBankAccount, Amount amountToBeTransfered) {
		if (amountToBeTransfered.value() > 0)
			if (currentBankAccount.currentBalance().isGreaterThan(amountToBeTransfered)) {
				currentBankAccount.withdraw(amountToBeTransfered);
				newBankAccount.deposit(amountToBeTransfered);
				return true;
			}
		return false;
	}
}
