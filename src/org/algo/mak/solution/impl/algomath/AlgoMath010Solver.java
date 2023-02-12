package org.algo.mak.solution.impl.algomath;

import org.algo.mak.solution.Solver;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AlgoMath010Solver extends Solver {
    public AlgoMath010Solver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        double number = Double.valueOf(list.get(0));
        long degree = Long.valueOf(list.get(1));

        double result = 1.0;
        for (int i = 0; i < degree; i++) {
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
