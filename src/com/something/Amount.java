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

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Amount)) return false;

		Amount amount = (Amount) o;

		if(value != null ? !value.equals(amount.value) : amount.value != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return value != null ? value.hashCode() : 0;
	}
}