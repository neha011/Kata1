package com.nb.kata1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String[] arrOfStr = null;
		int sum = 0;

		if (!num.startsWith("//")) {
			/*
			 * Logic for breaking string into numbers. When delimier is , OR \n . Negative
			 * limit is given to eliminate size constraint and handle unknown amount of
			 * numbers.
			 */
			arrOfStr = num.split(",|\n", -1);

		} else {
			// Support different delimiters - “//[delimiter]\n[numbers…]”
			String customdelimiter = FindDelimiter(num);
			String Temp = num.replace(customdelimiter, ",");
			arrOfStr = Temp.split(",|\n", -1);
		}
		// calculating sum of numbers obtained after recognizing the delimiters.
		for (String strNum : arrOfStr) {
			if (!strNum.isEmpty() && strNum.matches("\\d")) {
				sum = sum + Integer.parseInt(strNum);
			}
		}
		return sum;

	}

	public String FindDelimiter(String num) {

		Pattern pattern = Pattern.compile("//(.*?)\n", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(num);
		boolean matchfound = matcher.find();
		String delimiter = null;
		if (matchfound) {
			delimiter = matcher.group(1);

			return delimiter;
		} else
			return null;

	}
}