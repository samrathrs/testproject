package com.transerainc.adaws.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtils {

	private static Logger LOGGER = LoggerFactory
			.getLogger(StringUtils.class.getName());

	public static final String NL = System.getProperty("line.separator");

	public static boolean getBoolean(final String s) {
		return "true".equalsIgnoreCase(s) || "1".equalsIgnoreCase(s)
				|| "yes".equalsIgnoreCase(s);
	}

	public static int getInt(final String s) {
		try {
			return Integer.parseInt(s);
		} catch (final NumberFormatException e) {
			LOGGER.warn("Invalid integer: " + s);
			return -1;
		}
	}

	public static String toString(final Object o) {
		if (o == null) {
			return "";
		}
		return o.toString();
	}

	public static String escapeXml(String str) {
		if (str == null) {
			return null;
		}

		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("'", "&apos;");
		return str;
	}

	public static String unescapeXml(String str) {
		if (str == null) {
			return null;
		}

		str = str.replaceAll("&apos;", "'");
		str = str.replaceAll("&#39;", "'");
		str = str.replaceAll("&quot;", "\"");
		str = str.replaceAll("&lt;", "<");
		str = str.replaceAll("&gt;", ">");
		str = str.replaceAll("&amp;", "&");
		return str;
	}

	public static boolean convertToBoolean(final String s) {
		return s == null ? false : Boolean.valueOf(s.trim()).booleanValue();
	}

	public static int convertToInt(String s, final int defaultIfFail) {
		int pVal = defaultIfFail;
		try {
			if (s != null) {
				pVal = Integer.parseInt(s.trim());
			}
		} catch (final NumberFormatException e) {
		}
		return pVal;
	}

	public static boolean isEmpty(final String s) {
		return s == null || s.trim().length() <= 0;
	}

	public static boolean isNotEmpty(final String s) {
		return !isEmpty(s);
	}

	public static boolean isValidFullUrl(final String s) {
		try {
			final URL url = new URL(s);
			return isNotEmpty(url.getHost());
		} catch (final MalformedURLException e) {
			return false;
		}
	}

	public static void printList(final List<?> list, final StringBuffer sb) {
		if (list == null || list.size() < 1) {
			sb.append("[]");
			return;
		}

		sb.append("[").append(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			sb.append(",").append(list.get(i) == null ? "null" : list.get(i));
		}
		sb.append("]");
	}

	public static String printList(final List<?> list) {
		final StringBuffer sb = new StringBuffer();
		printList(list, sb);
		return sb.toString();
	}

	public static String printList(final Object[] list) {
		final List<Object> l = new LinkedList<Object>();
		if (list != null) {
			for (final Object element : list) {
				l.add(element);
			}
		}
		return printList(l);
	}

	public static void printMap(final Map<String, String> map,
			final StringBuffer sb) {
		if (map == null) {
			sb.append("{}");
			return;
		}

		sb.append("{");
		for (final Iterator<Entry<String, String>> it = map.entrySet()
				.iterator(); it.hasNext();) {
			final Entry<String, String> entry = it.next();
			sb.append(entry.getKey());
			sb.append("=");
			sb.append(entry.getValue());
			if (it.hasNext()) {
				sb.append(",");
			}
		}
		sb.append("}");
	}

	public static String getKeysAsCSV(final Map<String, ?> map) {
		final StringBuffer sb = new StringBuffer();
		for (final Iterator<String> it = map.keySet().iterator(); it
				.hasNext();) {
			final String k = it.next();
			sb.append(escapeToCSV(k));
			if (it.hasNext()) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

	public static String getValuesAsCSV(final Map<?, String> map) {
		final StringBuffer sb = new StringBuffer();
		for (final Iterator<String> it = map.values().iterator(); it
				.hasNext();) {
			final String k = it.next();
			sb.append(escapeToCSV(k));
			if (it.hasNext()) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

	public static String escapeToCSV(String s) {
		if (s == null) {
			return "";
		}

		// need double quotes if there are any '"' or line feeds.
		final boolean needDoubleQuote = s.indexOf("\"") > -1
				|| s.indexOf("\r\n") > -1 || s.indexOf(",") > -1;

		s = s.replaceAll("\"", "\"\"");
		if (needDoubleQuote) {
			return "\"" + s + "\"";
		}
		return s;
	}

	public static String printMap(final Map<String, String> map) {
		final StringBuffer sb = new StringBuffer();
		printMap(map, sb);
		return sb.toString();
	}

	public static String generateSessionId() {
		return UUID.randomUUID().toString();
	}

	public static int booleanToInt(final boolean value) {
		return BooleanUtils.toInteger(value);
	}

	public static String escapeHtml(String text) {
		return StringEscapeUtils.escapeHtml4(text);
	}

	public static String escapeJs(String text) {
		return StringEscapeUtils.escapeEcmaScript(text);
	}

	public static String escapeUri(String text)
			throws UnsupportedEncodingException {
		return URLEncoder.encode(text, "UTF-8");
	}

}
