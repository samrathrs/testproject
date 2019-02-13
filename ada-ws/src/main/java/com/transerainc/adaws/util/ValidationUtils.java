package com.transerainc.adaws.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    // default valid DN regexp
    public static final String VALID_DN = "([0-9a-zA-Z]+[-._])*[0-9a-zA-Z]+";

    private static Pattern dnPattern = Pattern.compile(VALID_DN);

    public static boolean isValidDn(final String dn) {
        final Matcher matcher = dnPattern.matcher(dn);
        return matcher.matches();
    }

    public static boolean isEmpty(final String s) {
        return s == null || s.trim().equals("");
    }

    public static boolean containsChars(final String s, final char[] arr) {
        for (final char c : arr) {
            if (s.indexOf(c) > -1) { return true; }
        }
        return false;
    }

    public static boolean isEmpty(final char[] c) {
        return c == null || c.length < 1;
    }
}
