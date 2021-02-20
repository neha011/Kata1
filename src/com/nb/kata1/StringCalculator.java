package com.nb.kata1;

public class StringCalculator {

	public int Add(String numbers) {
		// Create Temp variable to process Client Provided String Data.
		String num = numbers;
		// CASE 1: When String is empty.
		if (numbers.isEmpty()) {
			return 0;
		} else {
			// String is definitely not empty.
			return calculateSum(num);
		}

	}

	private int calculateSum(String num) {
		// Case 1 : Logic for breaking string into numbers and calculation of Sum.
		// Case 2 : -ve limit is given to eliminate size constraint and handle unknown
		// amt. of numbers.
		String[] arrOfStr = num.split(",", -1);
		int sum = 0;
		for (String strNum : arrOfStr) {
			sum = sum + Integer.parseInt(strNum);
		}
		return sum;

	}
}
