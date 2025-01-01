package com.logistics.utils;

public class StringFunctions {

	public boolean isNull(String str) {

		if (str != null && !str.equals("")) {
			str = str.trim();
			if (str != null && !str.equals("")) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}

	}

	public String replaceNull(String value) {
		if (!isNull(value)) {
			value = value.trim();
			if (!isNull(value)) {
				return value;
			} else {
				return "";
			}
		} else {
			return "";
		}

	}

}
