package cz.geek.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class SEO {

	protected static final Pattern SPACES = Pattern.compile("\\s+");
	protected static final Pattern NONCHAR = Pattern.compile("[^\\s\\w\\d]");

	public static String stripSpaces(String s) {
		Matcher m = SPACES.matcher(s.trim());
		return m.replaceAll(" ");
	}
	
	public static String spaces2dash(String s) {
		Matcher m = SPACES.matcher(s.trim());
		return m.replaceAll("-");
	}
	
	public static String nonchar2spaces(String s) {
		Matcher m = NONCHAR.matcher(s);
		return m.replaceAll(" ");
	}
	
	public static String toAscii(String s) {
		return Normalizer.normalize(s, Form.NFD).replaceAll("[^\\p{ASCII}]","");
	}
	
	public static String toSeoString(String s) {
		return spaces2dash(nonchar2spaces(toAscii(s))).toLowerCase();
	}

}
