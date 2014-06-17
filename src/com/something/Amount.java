package com.something;

public class Amount {

	private Double value;

	public Amount() {
		this.value = 0.0;
	}

	public Amount(Double value) {
		this.value = value;
	}

	public Double value() {
		return this.value;
	}

	public Boolean isGreaterThan(Amount comparableAmount) {
		return value > comparableAmount.value;
	}

	public Amount plus(Amount amount) {
		final Double newValue = this.value + amount.value;
		return new Amount(newValue);
	}

	public Amount minus(Amount amount) {
		final Double newValue = value - amount.value;
		return new Amount(newValue);
	}

	public Amount absoluteValue() {
		return new Amount(Math.abs(value));
	}

	public Amount negativeValue() {
		double negativeValue = value;
		if (value > 0) {
			negativeValue *= -1;
		}
		return new Amount(negativeValue);
	}

	public String moneyRepresentation() {
		return value.toString() + "0";
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;

		if(notInstanceOfAmount(o))
			return false;

		if(valuesAreNotValid(o))
			return false;

		return true;
	}

	private boolean notInstanceOfAmount(Object o) {
		return !(o instanceof Amount);
	}

	private boolean valuesAreNotValid(Object o) {
		Amount amount = (Amount) o;
		return notNull(Amount.this) ? valuesAreNotEqual(amount) : notNull(amount);
	}

	private boolean valuesAreNotEqual(Amount amount) {
		return !value.equals(amount.value);
	}

	private boolean notNull(Amount amount) {
		return amount.value != null;
	}

	@Override
	public int hashCode() {
		return notNull(Amount.this) ? value.hashCode() : 0;
	}
}