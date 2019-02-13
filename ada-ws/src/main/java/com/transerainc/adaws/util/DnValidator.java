package com.transerainc.adaws.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DnValidator {

    private String prefix = "";

    private Pattern fullPattern = null;
    private String stripChars = "";

    private String filteredDn = null;

    public DnValidator() {
        super();
    }

    public void setPrefix(final String prefix) {
        this.prefix = prefix == null ? "" : prefix;
    }

    public void setRegex(final String regex) {
        if (regex == null) {
            fullPattern = null;
        } else {
            fullPattern = Pattern.compile(regex);
        }
    }

    public String getRegexPattern() {
        return fullPattern.pattern();
    }

    public void setStripCharacters(final String stripChars) {
        this.stripChars = stripChars == null ? "" : stripChars;

    }

    public DnValidator validateDn(final String dn) {
        filteredDn = null;

        if (fullPattern == null) {
            if (ValidationUtils.isValidDn(dn)) {
                filteredDn = dn;
            }
        } else {
            filteredDn = checkValidFullDn(dn);
            if (filteredDn == null) {
                filteredDn = checkValidPartialDn(dn);
            }
        }
        return this;
    }

    public boolean isValid() {
        return filteredDn != null;
    }

    public String getFilteredDn() {
        return filteredDn;
    }

    private String checkValidFullDn(String s) {
        s = stripCharacters(s);

        final Matcher matcher = fullPattern.matcher(s);
        return matcher.matches() ? s : null;
    }

    private String checkValidPartialDn(String s) {
        s = stripCharacters(prefix + s);

        final Matcher matcher = fullPattern.matcher(s);
        return matcher.matches() ? s : null;
    }

    private String stripCharacters(final String s) {
        final StringBuffer buf = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (stripChars.indexOf(s.charAt(i)) == -1) {
                buf.append(s.charAt(i));
            }
        }
        return buf.toString();
    }
}
