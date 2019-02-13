package com.transerainc.adaws.security;

//import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tnguyen
 *
 */
class AuthenticationDateTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationDateTest.class);

	private static final String SAMPLE_AUTHENTICATION_DATE_VALUE = "2017-12-08T19:28:52.716Z[Etc/UTC]";
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z[Etc/UTC]'");
	
	@Test
	void test() {
		try {
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date formattedDate = sdf.parse(SAMPLE_AUTHENTICATION_DATE_VALUE);
			Calendar cal = Calendar.getInstance();
			cal.setTime(formattedDate);
			LOGGER.info("Year = {}", cal.get(Calendar.YEAR));
			LOGGER.info("Calendar: {}", cal);
			Assert.assertTrue(cal.get(Calendar.YEAR) == 2017);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.error("ParseException for authentication date: {}", SAMPLE_AUTHENTICATION_DATE_VALUE);
		}
	}

}
