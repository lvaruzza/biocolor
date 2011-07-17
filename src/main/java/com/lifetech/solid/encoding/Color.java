package com.lifetech.solid.encoding;

import java.util.Arrays;

public class Color {

	public static byte[] encode(String s) {
		byte [] b = s.getBytes();
		return encode(b,b.length);
	}
	
	public static byte[] encode(byte [] s, int len) {
		return encode(s,0,len);
	}
	
	public static byte[] encode(byte [] s,int start, int len) {
		byte[] r = new byte[len];
		
		r[0] = s[start];
		for(int i=start+1,j=1;i<start+len;i++,j++) {
			r[j] = encodeBase(s[i-1],s[i]);
		}
		
		return r;
	}


    public static byte[] decode(String s) {
        byte [] b = s.getBytes();
        return decode(b,b.length);
    }

    public static byte[] decode(byte [] s, int len) {
        return decode(s,0,len);
    }

    public static byte[] decode(byte [] s,int start, int len) {
        byte[] r = new byte[len];

        r[0] = s[start];
        for(int i=start+1,j=1;i<start+len;i++,j++) {
            r[j] = decodeBase(r[j-1],s[i]);
        }

        return r;
    }

	private static byte[] v;
	
	static {
		v = new byte[256]; 
		Arrays.fill(v, (byte)4);
		v['A'] = 0;
		v['C'] = 1;
		v['G'] = 2;
		v['T'] = 3;
		v['a'] = 0;
		v['c'] = 1;
		v['g'] = 2;
		v['t'] = 3;
	}
	
	private static byte[][] enc = { 
		          /*  A   C   G   T    N   */
		/* A */    { '0','1','2','3', '4'},
		/* C */    { '1','0','3','2', '4'},
		/* G */    { '2','3','0','1', '4'},
		/* T */    { '3','2','1','0', '4'},
		/* N */    { '4','4','4','4', '4'}		 
	};

    private static byte[][] dec = {
                  /*  0   1   2   3    4   */
        /* A */    { 'A','C','G','T', 'N'},
        /* C */    { 'C','A','T','G', 'N'},
        /* G */    { 'G','T','A','C', 'N'},
        /* T */    { 'T','G','C','A', 'N'},
        /* N */    { 'N','N','N','N', 'N'}
    };


	private static byte encodeBase(byte a, byte b) {
		return enc[v[a]][v[b]];
	}

    private static byte decodeBase(byte a, byte b) {
        return dec[v[a]][b-'0'];
    }
}
