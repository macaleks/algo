package org.algo.mak.solution.impl.algomath;

import org.algo.mak.solution.Solver;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AlgoMath110Solver extends Solver {
    public AlgoMath110Solver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        double number = Double.valueOf(list.get(0));
        long degree = Long.valueOf(list.get(1));
        if (degree == 0) return "1.0";
        if (degree == 1) return String.valueOf(number);

        long n = 2;
        double result = number;

        for (long i = n; i < degree; i = 2 * i ) {
            result *= result;
            n = i;
        }

        for (long i = n; i < degree; i++) {
            result *= number;
        }
        return String.valueOf(round(result));
    }

    private double round(double number) {
        BigDecimal bigDecimal = BigDecimal.valueOf(number);
        bigDecimal = bigDecimal.setScale(11, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
