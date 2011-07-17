package com.lifetech.solid.encoding;

import static com.lifetech.solid.encoding.Color.decode;
import static com.lifetech.solid.encoding.Color.encode;
import static java.lang.System.out;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestColorEncoding {

	private void doTestEncode(String a, String b) {
		String r = new String(encode(a));
		out.println(r);
		assertEquals(b,r);		
	}

    private void doTestDecode(String a, String b) {
        String r = new String(decode(a));
        out.println(r);
        assertEquals(b,r);
    }


	@Test
	public void testEncoding() {
        out.println("Testing Encode");
		doTestEncode("ACGT", "A131");
		doTestEncode("TGCA", "T131");
		doTestEncode("TGCA", "T131");
		doTestEncode("ACCNCC", "A10440");
		doTestEncode("A..CCNACGT", "A444044131");
	}


    @Test
    public void testDecoding() {
        out.println("Testing Decode");
        doTestDecode("A131","ACGT");
        doTestDecode("T131","TGCA");
        doTestDecode("T131","TGCA");
    }

}
