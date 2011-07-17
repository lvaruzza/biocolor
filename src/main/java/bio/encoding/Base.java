package bio.encoding;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: varuzza
 * Date: 7/17/11
 * Time: 12:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class Base {

    static byte[] num2base = {'A','C','G','T'};

    static public byte[] randomSequence(int size) {
        byte r[] = new byte[size];
        Random generator = new Random();
        generator.nextBytes(r);
        for (int i =0;i<size;i++)
            r[i] = (byte) num2base[Math.abs(r[i] % 4)];
        return r;
    }

    static public byte randomBase(double [] p) {
        throw new RuntimeException("Not Implemented: static public byte randomBase(double [] p)");
    }


    static public byte[] randomSequence(int size,double [] p) {
        byte r[] = new byte[size];

        for(int i=0;i<size;i++) {
            r[i] = randomBase(p);
        }
        return r;
    }

}
