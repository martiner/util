package cz.geek.util;

import java.util.Arrays;
import java.util.List;

public abstract class ListUtils {
	
	/**
	 * Delete items from given <code>list</code> at given <code>indexes</code>
	 * @param list list
	 * @param indexes indexes to remove (may be null)
     * @throws UnsupportedOperationException if the <tt>remove</tt> method is not supported by this list.
	 * @throws IndexOutOfBoundsException if one of indexes is out of range &lt; 0 || index &gt;= size()).
	 */
	public static void delete(List<?> list, Integer[] indexes) throws IndexOutOfBoundsException, UnsupportedOperationException {
		if (indexes == null)
			return;
		if (indexes.length > 1)
			Arrays.sort(indexes);
		for (int i=0; i<indexes.length; i++)
			list.remove(indexes[i]-i);
	}
}
