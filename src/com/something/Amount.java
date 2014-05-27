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
}