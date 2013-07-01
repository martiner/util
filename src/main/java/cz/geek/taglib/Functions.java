package cz.geek.taglib;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

public class Functions {
	public static boolean isinrole(HttpServletRequest req, String[] role) {
		for (String i : role)
			if (req.isUserInRole(i))
				return true;
		return false;
	}

	public static boolean inrole(HttpServletRequest req, String role) {
		return isinrole(req, new String[]{role});
	}

	public static boolean inrole2(HttpServletRequest req, String role, String role2) {
		return isinrole(req, new String[]{role, role2});
	}

	public static boolean inrole3(HttpServletRequest req, String role, String role2, String role3) {
		return isinrole(req, new String[]{role, role2, role3});
	}

	public static boolean contains(Collection<?> col, Object obj) {
		if ((col == null) || (obj == null)) {
			return false;
		}
		return col.contains(obj);
	}

	public static boolean acontains(Object[] col, Object obj) {
		if ((col == null) || (obj == null)) {
			return false;
		}
		for (Object i: col) {
			if (obj.equals(i))
				return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public static boolean compare(Comparable a, Comparable b) {
		if (a == null || b == null)
			return false;
		return a.compareTo(b) == 0;
	}

	@SuppressWarnings("unchecked")
	public static int compareTo(Comparable a, Comparable b) {
		return a.compareTo(b);
	}

}
