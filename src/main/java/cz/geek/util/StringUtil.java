package cz.geek.util;

import java.util.Arrays;
import java.util.Collection;

public class StringUtil {
    public static String join(CharSequence delim, CharSequence[] arg) {
        StringBuilder s = new StringBuilder();
        int i = 0;
        for (CharSequence ch : arg) {
            s.append(ch);
            i++;
            if (arg.length != i)
                s.append(delim);
        }
        return s.toString();
    }

    public static String join(CharSequence delim, Collection<?> c) {
        StringBuilder s = new StringBuilder();
        int i = 0;
        for (Object ch: c) {
            s.append(ch.toString());
            i++;
            if (c.size() != i)
                s.append(delim);
        }
        return s.toString();
    }

    public static String join(CharSequence delim, Object[] a) {
        return join(delim, Arrays.asList(a));
    }

    public static String ucFirst(String s) {
        StringBuilder b = new StringBuilder(s);
        b.setCharAt(0, Character.toUpperCase(b.charAt(0)));
        return b.toString();
    }
}
