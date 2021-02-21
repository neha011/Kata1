package com.nb.kata1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	static int count = 0;

	public int Add(String numbers) throws Exception {
		count++;
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

	private int calculateSum(String num) throws CheckNegativeNumberException {
		String[] arrOfStr = null;
		int sum = 0;
		List<String> negativelist = new ArrayList<String>();

		if (!num.startsWith("//")) {
			/*
			 * Logic for breaking string into numbers. When delimier is , OR \n . Negative
			 * limit is given to eliminate size constraint and handle unknown amount of
			 * numbers.
			 */
			arrOfStr = num.split(",|\n", -1);

		} else {
			// To get list of multiple delimiters
			List<String> listdelim = new ArrayList<String>();
			for (int i = 0; i <= num.length() - 1; i++) {
				if (num.charAt(i) == '[') {
					String customdelimiter = FindDelimiter(num.substring(i));
					listdelim.add(customdelimiter);
				}

			}

			// Support different delimiters - “//[delimiter]\n[numbers…]”
			for (int j = 0; j < listdelim.size(); j++) {
				num = num.replace(listdelim.get(j), ",");
			}

			arrOfStr = num.split(",|\n|[|]", -1);
		}
		// calculating sum of numbers obtained after recognizing the delimiters.
		boolean hasnegative = false;
		for (String strNum : arrOfStr) {
			// checking for Negative numbers.
			if (!strNum.isEmpty() && strNum.contains("-")) {
				negativelist.add(strNum);
				hasnegative = true;
			} else if (!strNum.isEmpty() && strNum.matches("[0-9]*")) {
				int convertNum = Integer.parseInt(strNum);
				if (convertNum <= 1000) {
					sum = sum + convertNum;
				} else {
					// IgnoreCode
				}

			}
		}
		if (hasnegative) {
			throw new CheckNegativeNumberException("Negative not allowed" + negativelist);
		}
		return sum;

	}

	public String FindDelimiter(String num) {

		Pattern pattern = Pattern.compile("\\[(.*?)]", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(num);
		boolean matchfound = matcher.find();
		String delimiter = null;
		if (matchfound) {
			delimiter = matcher.group(1);

			return delimiter;
		} else
			return null;

	}

	public int GetCalledCount() {
		return count;
	}
}
