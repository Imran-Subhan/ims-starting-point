package com.qa.ims.utils;

import java.util.Scanner;

public class Utils {

	public static final String MYSQL_URL = "34.105.133.143:3306";
	public static final Scanner SCANNER = new Scanner(System.in);

	private Utils() {

	}

	public static String getInput() {
		return SCANNER.nextLine();
	}
	public static int getintInput() {
		return SCANNER.nextInt();
	}
	public static Long getLongInput() {
		return SCANNER.nextLong();
}
}
