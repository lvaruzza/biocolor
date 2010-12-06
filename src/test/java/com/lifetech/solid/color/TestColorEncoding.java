package com.lifetech.solid.color;

import static com.lifetech.solid.color.ColorEncoding.encode;
import static java.lang.System.out;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestColorEncoding {

	private void doTest(String a,String b) {
		String r = new String(encode(a));
		out.println(r);
		assertEquals(b,r);		
	}
	
	@Test
	public void testEncoding() {
		doTest("ACGT","A131");
		doTest("TGCA","T131");
		doTest("TGCA","T131");
		doTest("ACCNCC","A10440");
		doTest("A..CCNACGT","A444044131");
	}
}
