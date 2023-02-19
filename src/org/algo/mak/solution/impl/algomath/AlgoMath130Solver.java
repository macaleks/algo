package org.algo.mak.solution.impl.algomath;

import org.algo.mak.solution.Solver;

import java.util.List;

public class AlgoMath130Solver extends Solver {
    public AlgoMath130Solver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        long n = Long.valueOf(list.get(0));
        double sqrtOf5 = Math.sqrt(5);
        double f = (1 + sqrtOf5)/2;

        Double v = Math.pow(f, n) / sqrtOf5 + 0.5;
        Long l = v.longValue();
        return l.toString();
    }
}
