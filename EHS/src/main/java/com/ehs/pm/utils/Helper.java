package com.ehs.pm.utils;

public final class Helper {
	private Helper() {

	}

	public static String getFormattedName(final String firstName, final String middleName, final String lastName) {
		StringBuilder sb = new StringBuilder();
		if (lastName != null && lastName.trim().length() > 0) {
			sb.append(lastName);
			sb.append(" ");
		}
		if (middleName != null && middleName.trim().length() > 0) {
			sb.append(middleName);
			sb.append(" ");
		}

		if (firstName != null && firstName.trim().length() > 0) {
			sb.append(firstName);
			sb.append(" ");
		}
		return sb.toString();
	}
}
