package com.nb.kata1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestExecutor1 {

	@Test
	public void Test1() {
		StringCalculator cal = new StringCalculator();
		int case1 = cal.Add("");
		assertEquals(0, case1);
		int case2 = cal.Add("1");
		assertEquals(1, case2);
		int case3 = cal.Add("1,3");
		assertEquals(4, case3);
	}

}
