package com.nb.kata1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestExecutor1 {

	@Test
	public void Test1() throws Exception {
		StringCalculator cal = new StringCalculator();
		int case1 = cal.Add("");
		assertEquals(0, case1);
		int case2 = cal.Add("1");
		assertEquals(1, case2);
		int case3 = cal.Add("1,3");
		assertEquals(4, case3);
	}

	@Test
	public void NewLineTestCase() throws Exception {
		StringCalculator cal = new StringCalculator();
		int case4 = cal.Add("1\n2,3,\n\n\n\n\n\n\n4");
		assertEquals(10, case4);
		int case5 = cal.Add("1\n\n2,3,4\n5");
		assertEquals(15, case5);
	}

	@Test
	public void CustomDelimiterTestCase() throws Exception {
		StringCalculator cal = new StringCalculator();
		int case6 = cal.Add("//***\n1***2***3");
		assertEquals(6, case6);

	}

	@Test
	public void SingleNegativValueTestCase() throws Exception {
		try {
			StringCalculator cal = new StringCalculator();
			int case7 = cal.Add("//##\n1##2##-111");
		} catch (CheckNegativeNumberException e) {
			assertEquals("Negative not allowed[-111]", e.getMessage());
		}

	}

	@Test
	public void MultipleNegativValueTestCase() throws Exception {

		try {
			StringCalculator cal = new StringCalculator();
			int case8 = cal.Add("//##\n1##-2##-5");
		} catch (CheckNegativeNumberException e) {
			assertEquals("Negative not allowed[-2, -5]", e.getMessage());
		}

	}

}
