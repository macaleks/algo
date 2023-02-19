package org.algo.mak.solution.impl.algomath;

import org.algo.mak.solution.Solver;

import java.util.List;

public class AlgoMath030Solver extends Solver {
    public AlgoMath030Solver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        long n = Long.valueOf(list.get(0));
        if (n < 2) return "0";
        int primes = 0;
        int count;

        for (int i = 2; i <= n; i++) {
            count = 0;
            for (int j = 2; j <= n; j++) {
                if (i % j == 0) count++;
            }
            if (count > 1) continue;
            primes++;
        }
        return String.valueOf(primes);
    }
}
