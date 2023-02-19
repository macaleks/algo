package org.algo.mak.solution.impl.algomath;

import org.algo.mak.solution.Solver;

import java.util.List;

public class AlgoMath160Solver extends Solver {
    public AlgoMath160Solver(String folder) {
        super(folder);
    }
    @Override
    public String solve(List<String> list) {
        long value = Long.valueOf(list.get(0));
        int primes = 0;

        for (int i = 0; i <= value; i++) {
            if (isPrime(i)) primes++;
        }

        return String.valueOf(primes);
    }

    private boolean isPrime(long value) {
        if (value == 1) return false;
        if (value == 2) return true;
        if (value % 2 == 0) return false;

        double sqrt = Math.sqrt(value);

        for (long number = 3; number <= sqrt; number += 2) {
            if (value % number == 0) return false;
        }
        return true;
    }
}
