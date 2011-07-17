package bio.encoding;

import static bio.encoding.Color.decode;
import static bio.encoding.Color.encode;
import static java.lang.System.out;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestColor {

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

    private void doTestEncodeDecode(String a) {
        byte[] e = encode(a);
        out.flush();
        String r = new String(decode(e));
        out.println( a + "  => " + new String(e) + " => " + r);
        assertEquals(a, r);
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

    @Test
    public void testEncodeDecode() {
        out.println("Testing Encode and Decode");
        doTestEncodeDecode("CGAGCAGCGAGCA");
        doTestEncodeDecode("TA");
        doTestEncodeDecode("AA");
        doTestEncodeDecode("GGGGGGGG");
    }

    @Test
    public void testEncodeDecodeRandom() {
        for(int i=0;i<10;i++) {
            doTestEncodeDecode(new String(Base.randomSequence(50)));
        }
    }
}
