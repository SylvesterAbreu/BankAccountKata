package com.something;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AmountTest {

	@Test
	public void shouldBeEqualToAnotherInstanceWithAmount(){
		final Amount oneThousand = new Amount(1000.0);
		final Amount anotherOneThousand = new Amount(1000.0);

		assertThat(oneThousand, is(equalTo(anotherOneThousand)));
	}

	@Test
	public void shouldBeGreaterThanAnotherInstanceWithSmallerAmount(){
		final Amount fiveThousand = new Amount(5000.0);
		final Amount oneThousand = new Amount(1000.0);

		assertThat(fiveThousand.isGreaterThan(oneThousand), is(true));
	}

	@Test
	public void shouldBeLessThanAnotherInstanceWithBiggerAmount(){
/*
		final Amount oneThousand = new Amount(1000.0);
		final Amount fiveThousand = new Amount(5000.0);

		assertThat(oneThousand.isGreaterThan(fiveThousand), is(true));
*/
	}

	@Test
	public void shouldBeEqualToAnotherInstanceWithEqualAmount(){
/*
		final Amount oneThousand = new Amount(1000.0);
		final Amount fiveThousand = new Amount(5000.0);

		assertThat(oneThousand.isGreaterThan(fiveThousand), is(true));
*/
	}

	@Test
	public void shouldBeDifferentToAnotherInstanceWithDifferentAmount(){
/*
		final Amount oneThousand = new Amount(1000.0);
		final Amount fiveThousand = new Amount(5000.0);

		assertThat(oneThousand.isGreaterThan(fiveThousand), is(true));
*/
	}

	@Test
	public void shouldSumAmounts(){
/*
		final Amount oneThousand = new Amount(1000.0);
		final Amount fiveThousand = new Amount(5000.0);

		assertThat(oneThousand.isGreaterThan(fiveThousand), is(true));
*/
	}

	@Test
	public void shouldSubtractAmounts(){
/*
		final Amount oneThousand = new Amount(1000.0);
		final Amount fiveThousand = new Amount(5000.0);

		assertThat(oneThousand.isGreaterThan(fiveThousand), is(true));
*/
	}
}
