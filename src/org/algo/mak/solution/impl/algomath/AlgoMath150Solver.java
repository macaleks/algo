package org.algo.mak.solution.impl.algomath;

import org.algo.mak.solution.Solver;

import java.util.List;

public class AlgoMath150Solver extends Solver {
    public AlgoMath150Solver(String folder) {
        super(folder);
    }
    @Override
    public String solve(List<String> list) {
        long value = Long.valueOf(list.get(0));
        if (value < 2) return "0";

        long primes = calculatePrimes(value);

        return String.valueOf(primes);
    }

    private long calculatePrimes(long value) {
        var count = 0;
        Long size = value / 2;
        var primes = new long[size.intValue() + 1];

        primes[count++] = 2;

        for (long number = 3; number <= value; number++) {
            if (isPrimeBasedOnPrimes(primes, number)) primes[count++] = number;
        }
        return count;
    }

    private boolean isPrimeBasedOnPrimes(long[] primes, long value) {
        double sqrt = Math.sqrt(value);
        for (int i = 0; primes[i] <= sqrt; i++) {
            if (value % primes[i] == 0) return false;
        }
        return true;
    }
}
