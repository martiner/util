package cz.geek.taglib;

import org.junit.Test;

import static cz.geek.taglib.Functions.acontains;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class FunctionsTest {

	@Test
	public void testAcontains() throws Exception {
		assertFalse(acontains(null, null));
		assertFalse(acontains(null, this));
		assertFalse(acontains(new Object[]{}, this));
		assertFalse(acontains(new Object[]{}, null));
		assertTrue(acontains(new Object[]{"A", "B", "C"}, "B"));
	}
}
