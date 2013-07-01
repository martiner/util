package cz.geek.util;

import org.junit.Assert;
import org.junit.Test;


public class SEOTest {
	@Test
	public void toSeoString() {

		String ahoj = " Ahoj  ty vole  ";
		String palce = " aaa  17\" palců ";
		
		Assert.assertEquals("Ahoj ty vole", SEO.stripSpaces(ahoj));
		Assert.assertEquals("aaa 17\" palců", SEO.stripSpaces(palce));
		
		Assert.assertEquals("ahoj-ty-vole", SEO.toSeoString(ahoj));
		Assert.assertEquals("aaa-17-palcu", SEO.toSeoString(palce));
	}
}
