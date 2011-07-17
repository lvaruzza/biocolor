package bio.encoding;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import static java.lang.System.out;
import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: varuzza
 * Date: 7/17/11
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestBase {

    @Test
    public void testRandomSequence() {
        int len = 100;
        String res = new String(Base.randomSequence(len));
        out.println(res);
        out.println("A: " +StringUtils.countMatches(res,"A"));
        out.println("C: " +StringUtils.countMatches(res,"C"));
        out.println("G: " +StringUtils.countMatches(res,"G"));
        out.println("T: " +StringUtils.countMatches(res,"T"));
        assertEquals(len,res.length());
        assertTrue(StringUtils.containsOnly(res,"ACGT"));
    }
}
