package org.algo.mak.solution.impl.algomath;

import org.algo.mak.solution.Solver;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AlgoMath120Solver extends Solver {
    public AlgoMath120Solver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        double number = Double.valueOf(list.get(0));
        long degree = Long.valueOf(list.get(1));

        double result;
        if (degree % 2 == 0) {
            result = 1.0;
        } else{
            result = number;
        }

        while (degree > 0) {
            degree /= 2;
            number = number * number;
            if (degree % 2 > 0) {
                result = result * number;
            }
        }

        return String.valueOf(round(result));
    }

    private double round(double number) {
        BigDecimal bigDecimal = BigDecimal.valueOf(number);
        bigDecimal = bigDecimal.setScale(11, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
