package com.biubiuman.net.util;

import com.google.gson.Gson;

public class FormatUtil {
	public static <T> String formatPojo(T pojo) {
		Gson gson = new Gson();
		String tempString = "";
		tempString = gson.toJson(pojo);
		return tempString;
	}

	public static <T> T setPojo(T obj, String formatPojo) {
		Gson gson = new Gson();
		return (T) gson.fromJson(formatPojo, obj.getClass());
	}
}
