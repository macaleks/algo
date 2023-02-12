package org.algo.mak.solution.impl.algomath;

import org.algo.mak.solution.Solver;

import java.math.BigDecimal;
import java.util.List;

public class AlgoMath021Solver extends Solver {
    public AlgoMath021Solver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        long n = Long.valueOf(list.get(0));
        if (n >= 0 && n <= 1) return String.valueOf(n);

        BigDecimal n1 = new BigDecimal(0);
        BigDecimal n2 = new BigDecimal(1);
        for (int i = 2; i <= n; i++) {
            var tmp = n1.add(n2);
            n1 = n2;
            n2 = tmp;
        }
        return n2.toString();
    }
}
