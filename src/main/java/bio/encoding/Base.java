package bio.encoding;

/**
 * Created by IntelliJ IDEA.
 * User: varuzza
 * Date: 7/17/11
 * Time: 12:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class Base {
    static public double[] equiProp = {0.25,0.25,0.25,0.25};

    static public byte[] randomSequence(int size) {
        return randomSequence(size,equiProp);
    }

    static public byte randomBase(double [] p) {
        return 'N';
    }

    static public byte[] randomSequence(int size,double [] p) {
        byte r[] = new byte[size];

        for(int i=0;i<size;i++) {
            r[i] = randomBase(p);
        }
        return r;
    }

}
