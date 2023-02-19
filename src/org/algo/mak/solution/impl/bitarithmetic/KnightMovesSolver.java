package org.algo.mak.solution.impl.bitarithmetic;

import org.algo.mak.solution.Solver;

import java.math.BigInteger;
import java.util.List;

import static org.algo.mak.solution.impl.bitarithmetic.CountPositionsHelper.popcnt2;

public class KnightMovesSolver extends Solver {
    public KnightMovesSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        long value = 1L << Long.valueOf(list.get(0));
        BigInteger knight = new BigInteger(String.valueOf(value));

        BigInteger noA = new BigInteger("18374403900871474942");
        BigInteger noB = new BigInteger("18302063728033398269");
        BigInteger noG = new BigInteger("13816973012072644543");
        BigInteger noH = new BigInteger("9187201950435737471");

        BigInteger noAnoBno8 = new BigInteger("71209857637481724");
        BigInteger no7no8noA = new BigInteger("280371153272574");
        BigInteger noHnoGno8 = new BigInteger("17802464409370431");
        BigInteger no7no8noH = new BigInteger("140185576636287");

        BigInteger knightNoA = knight.and(noA);
        BigInteger knightNoB = knight.and(noB);
        BigInteger knightNoG = knight.and(noG);
        BigInteger knightNoH = knight.and(noH);
        BigInteger knightNoANoB = knightNoA.and(knightNoB);
        BigInteger knightNoHNoG = knightNoH.and(knightNoG);
        BigInteger knightNoAnoBno8 = knight.and(noAnoBno8);
        BigInteger knightNo7No8NoA = knight.and(no7no8noA);
        BigInteger knightNoHNoHNo8 = knight.and(noHnoGno8);
        BigInteger knightNo7No8NoH = knight.and(no7no8noH);

        BigInteger number =
                knightNo7No8NoA.shiftLeft(15).or(knightNo7No8NoH.shiftLeft(17)).or(
                        knightNoAnoBno8.shiftLeft(6)).or(knightNoHNoHNo8.shiftLeft(10)).or(
                        knightNoANoB.shiftRight(10)).or(knightNoHNoG.shiftRight(6)).or(
                        knightNoA.shiftRight(17)).or(knightNoH.shiftRight(15));
        long cnt = popcnt2(number);
        return cnt + "\r\n" + number;
    }
}
