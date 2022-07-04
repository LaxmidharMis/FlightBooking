package com.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class TestingDemoApplicationTests {
	private Calculator c = new Calculator();
	@Test
	void contextLoads() {
	}
	@Test
		void testSum() {
		// expected result
		int expectedResult = 50;
		// actual result
		int actualResult = c.doSum(12, 15, 23);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void TestProduct() {
		// expected result
		int expected = 20;
		int actual = c.doProduct(2, 10);

		assertThat(actual).isEqualTo(expected);
	}

}
