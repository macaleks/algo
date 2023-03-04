package org.algo.mak.solution.impl.bitarithmetic;

import java.math.BigInteger;

public class CountPositionsHelper {

    public static long[] bits;

    static {
        initBits();
    }

    private static void initBits() {
        bits = new long[256];
        for (int i = 0; i < 256; i++) {
            bits[i] = popcnt2(new BigInteger(String.valueOf(i)));
        }
    }
    public static long popcnt1(BigInteger mask) {
        long cnt = 0;

        while (mask.signum() == 1) {
            cnt += mask.and(new BigInteger("1")).intValue();
            mask = mask.shiftRight(1);
        }
        return cnt;
    }

    public static long popcnt2(BigInteger mask) {
        long cnt = 0;
        while (mask.signum() == 1) {
            cnt++;
            mask = mask.and(mask.subtract(new BigInteger("1")));
        }
        return cnt;
    }

    public static long popcnt3(BigInteger mask) {
        long cnt = 0;
        BigInteger value = new BigInteger("255");
        while (mask.signum() == 1) {
            cnt += bits[mask.and(value).intValue()];
            mask = mask.shiftRight(8);
        }
        return cnt;
    }
}
