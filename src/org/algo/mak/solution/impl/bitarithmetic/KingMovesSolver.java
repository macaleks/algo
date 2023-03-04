package org.algo.mak.solution.impl.bitarithmetic;

import org.algo.mak.solution.Solver;

import java.math.BigInteger;
import java.util.List;

import static org.algo.mak.solution.impl.bitarithmetic.CountPositionsHelper.popcnt1;
import static org.algo.mak.solution.impl.bitarithmetic.CountPositionsHelper.popcnt2;

public class KingMovesSolver extends Solver {
    public KingMovesSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        long value = 1L << Long.valueOf(list.get(0));
        BigInteger king = new BigInteger(String.valueOf(value));

        BigInteger noA = new BigInteger("18374403900871474942");
        BigInteger noH = new BigInteger("9187201950435737471");
        BigInteger no8 = new BigInteger("72057594037927935");


        BigInteger kingNoA = king.and(noA);
        BigInteger kingNoH = king.and(noH);
        BigInteger kingNo8 = king.and(no8);

        BigInteger kingNoAand8 = kingNoA.and(kingNo8);
        BigInteger kingNoHand8 = kingNoH.and(kingNo8);

        BigInteger number =
                kingNoAand8.shiftLeft(7).or(kingNo8.shiftLeft(8)).or(kingNoHand8.shiftLeft(9))
                        .or(kingNoA.shiftRight(1)).or(kingNoH.shiftLeft(1))
                        .or(kingNoA.shiftRight(9)).or(king.shiftRight(8)).or(kingNoH.shiftRight(7));
        long cnt = popcnt2(number);
        return cnt + "\r\n" + number;
    }
}
