package org.algo.mak.solution.impl.algomath;

import org.algo.mak.solution.Solver;

import java.util.List;

public class AlgoMath020Solver extends Solver {
    public AlgoMath020Solver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        var n = Long.valueOf(list.get(0));
        return Long.toString(solve(n));
    }

    private long solve(long n) {
        if (n <= 1) return n;
        return solve(n - 1) + solve(n - 2);
    }
}
