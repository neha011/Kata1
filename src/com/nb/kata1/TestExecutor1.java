package com.nb.kata1;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestExecutor1 {

	@Test
	public void Test1() throws Exception {
		StringCalculator cal = new StringCalculator();
		int case1 = cal.Add("");
		Assert.assertEquals(0, case1);
		int case2 = cal.Add("1");
		Assert.assertEquals(1, case2);
		int case3 = cal.Add("1,3");
		Assert.assertEquals(4, case3);
	}

	@Test
	public void NewLineTestCase() throws Exception {
		StringCalculator cal = new StringCalculator();
		int case4 = cal.Add("1\n2,3,\n\n\n\n\n\n\n4");
		Assert.assertEquals(10, case4);
		int case5 = cal.Add("1\n\n2,3,4\n5");
		Assert.assertEquals(15, case5);
	}

	@Test
	public void CustomDelimiterTestCase() throws Exception {
		StringCalculator cal = new StringCalculator();
		int case6 = cal.Add("//[***]\n1***2***3"); //any length delimiter
		Assert.assertEquals(6, case6);
		int case7 = cal.Add("//[;]\n1;2");        // single size delimiter
		Assert.assertEquals(3, case7);

	}

	@Test
	public void SingleNegativValueTestCase() throws Exception {
		try {
			StringCalculator cal = new StringCalculator();
			int case8 = cal.Add("//[##]\n1##2##-111");
		} catch (CheckNegativeNumberException e) {
			Assert.assertEquals("Negative not allowed[-111]", e.getMessage());
		}

	}

	@Test
	public void MultipleNegativValueTestCase() throws Exception {

		try {
			StringCalculator cal = new StringCalculator();
			int case9 = cal.Add("//[##]\n1##-2##-5");
		} catch (CheckNegativeNumberException e) {
			Assert.assertEquals("Negative not allowed[-2, -5]", e.getMessage());
		}

	}

	@Test
	public void GreaterThan_1000() throws Exception {
		StringCalculator cal = new StringCalculator();
		int case10 = cal.Add("1,23,1002");
		Assert.assertEquals(24, case10);
	}

	@Test
	public void DummyFailingTest() throws Exception {
		StringCalculator cal = new StringCalculator();
		int case11 = cal.Add("abcd");
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void MultipleDelimiters() throws Exception {
		StringCalculator cal = new StringCalculator();
		int case12 = cal.Add("//[*][%]\n1*2%3");  //multiple delimiters of single size
		Assert.assertEquals(6, case12);
		int case13 = cal.Add("//[**][%%]\n1**2%%3");  //multiple delimiters of multiple size
		Assert.assertEquals(6, case13);
	}

	@Test
	public void ZCountAdd() {
		StringCalculator cal = new StringCalculator();
		int actuatcount = cal.GetCalledCount();
		Assert.assertEquals(13, actuatcount);
	}
}
