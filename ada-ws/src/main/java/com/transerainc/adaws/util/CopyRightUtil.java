package com.transerainc.adaws.util;

import org.apache.commons.lang3.BooleanUtils;

/**
 * Helper class for the copyright page
 * Date of Creation: Date: Mar 19, 2009<br>
 * File Name : CopyRightUtil.java<br>
 *
 * @author <a href=jasmin@transerainc.com>Jasmin Menezes</a>
 * @version $Revision: 1.3 $
 */
public class CopyRightUtil {

	 public static Boolean getCompany() {
	        return BooleanUtils.toBoolean(System.getProperties().getProperty("bcc.data.center"))
	                ? true : false;
	    }
}
