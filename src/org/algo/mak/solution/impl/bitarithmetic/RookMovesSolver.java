package org.algo.mak.solution.impl.bitarithmetic;

import org.algo.mak.solution.Solver;

import java.math.BigInteger;
import java.util.List;

import static org.algo.mak.solution.impl.bitarithmetic.CountPositionsHelper.popcnt2;
import static org.algo.mak.solution.impl.bitarithmetic.CountPositionsHelper.popcnt3;

public class RookMovesSolver extends Solver {
    public RookMovesSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        long value = 1L << Long.valueOf(list.get(0));
        BigInteger knight = new BigInteger(String.valueOf(value));

        BigInteger columnA = new BigInteger("72340172838076673");
        BigInteger columnB = new BigInteger("144680345676153346");
        BigInteger columnC = new BigInteger("289360691352306692");
        BigInteger columnD = new BigInteger("578721382704613384");
        BigInteger columnE = new BigInteger("1157442765409226768");
        BigInteger columnF = new BigInteger("2314885530818453536");
        BigInteger columnG = new BigInteger("4629771061636907072");
        BigInteger columnH = new BigInteger("9259542123273814144");

        BigInteger line1 = new BigInteger("255");
        BigInteger line2 = new BigInteger("65280");
        BigInteger line3 = new BigInteger("16711680");
        BigInteger line4 = new BigInteger("4278190080");
        BigInteger line5 = new BigInteger("1095216660480");
        BigInteger line6 = new BigInteger("280375465082880");
        BigInteger line7 = new BigInteger("71776119061217280");
        BigInteger line8 = new BigInteger("18374686479671623680");

        BigInteger[] columns = {columnA, columnB, columnC, columnD, columnE, columnF, columnG, columnH};
        BigInteger[] lines = {line1, line2, line3, line4, line5, line6, line7, line8};

        BigInteger number = new BigInteger("0");

        for (int i = 0; i < columns.length; i++) {
            if (knight.and(columns[i]).signum() == 1) {
                number = (columns[i]);
            }
        }

        for (int i = 0; i < lines.length; i++) {
            if (knight.and(lines[i]).signum() == 1) {
                number = number.xor(lines[i]);
            }
        }

        long cnt = popcnt3(number);
        return cnt + "\r\n" + number;
    }
}
