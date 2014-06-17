package com.something;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AmountTest {

	@Test
	public void isEqualToAnotherInstanceWithSameAmount() throws Exception {
		final Amount oneThousand = new Amount(1000.0);
		final Amount anotherOneThousand = new Amount(1000.0);

		assertThat(oneThousand, is(equalTo(anotherOneThousand)));
	}

	@Test
	public void hasZeroAsValueWhenNoValueProvided() throws Exception {
		final Amount newAmount = new Amount();

		assertThat(newAmount.value(), is(equalTo(0.0)));
	}

	@Test
	public void isGreaterThanAnotherInstanceWithSmallerAmount() throws Exception {
		final Amount fiveThousand = new Amount(5000.0);
		final Amount oneThousand = new Amount(1000.0);

		assertThat(fiveThousand.isGreaterThan(oneThousand), is(true));
	}

	@Test
	public void isLessThanAnotherInstanceWithBiggerAmount() throws Exception {
		final Amount oneThousand = new Amount(1000.0);
		final Amount fiveThousand = new Amount(5000.0);

		assertThat(oneThousand.isGreaterThan(fiveThousand), is(false));
	}

	@Test
	public void isEqualToAnotherInstanceWithEqualAmount() throws Exception {
		final Amount oneThousand = new Amount(1000.0);
		final Amount anotherOneThousand = new Amount(1000.0);

		assertThat(oneThousand.equals(anotherOneThousand), is(true));
	}

	@Test
	public void isDifferentToAnotherInstanceWithDifferentAmount() throws Exception {
		final Amount oneThousand = new Amount(1000.0);
		final Amount fiveThousand = new Amount(5000.0);

		assertThat(oneThousand.equals(fiveThousand), is(false));
	}

	@Test
	public void sumsAmounts() throws Exception {
		final Amount oneThousand = new Amount(1000.0);
		final Amount fiveThousand = new Amount(5000.0);
		final Amount sixThousand = new Amount(6000.0);

		assertThat(oneThousand.plus(fiveThousand), is(equalTo(sixThousand)));
	}

	@Test
	public void subtractsAmounts() throws Exception {
		final Amount oneThousand = new Amount(1000.0);
		final Amount fiveThousand = new Amount(5000.0);
		final Amount fourThousand = new Amount(4000.0);

		assertThat(fiveThousand.minus(oneThousand), is(equalTo(fourThousand)));
	}

	@Test
	public void returnsAbsoluteValue() throws Exception {
		final Amount minusOneThousand = new Amount(-1000.0);
		final Amount absoluteValue = new Amount(1000.0);

		assertThat(absoluteValue, is(equalTo(minusOneThousand.absoluteValue())));
	}

	@Test
	public void returnsNegativeValue() throws Exception {
		final Amount oneThousand = new Amount(1000.0);
		final Amount minusOneThousand = new Amount(-1000.0);

		assertThat(minusOneThousand, is(equalTo(oneThousand.negativeValue())));
	}

	@Test
	public void returnsMoneyRepresentation() throws Exception {
		final Amount oneThousand = new Amount(1000.00);

		assertThat("1000.00", is(equalTo(oneThousand.moneyRepresentation())));
	}
}