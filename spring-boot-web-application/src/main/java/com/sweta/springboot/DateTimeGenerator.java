package com.sweta.springboot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeGenerator {

	public static String getDateTime() {
		// TODO Auto-generated method stub
		LocalDateTime localDateTime = LocalDateTime.now();
		String date = localDateTime.format(DateTimeFormatter.ofPattern("YYYYMMdd_HHmm"));
		String filename = "FXData_"+date+".csv";
		return filename;
	}
}
