package org.algo.mak.solution.impl.algomath;

import org.algo.mak.solution.Solver;

import java.util.List;

public class AlgoMath140Solver extends Solver {
    public AlgoMath140Solver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        long n = Long.valueOf(list.get(0));
        if (n < 2) return String.valueOf(n);
        if (n == 2) return "1";

        long[][] matrix = {{1, 1}, {1, 0}};
        long[][] result;
//        result = new long[][]{{1, 1}, {1, 0}};
//        result = calculateN(result, matrix, n);

        result = calculateLogN(matrix, n - 1);

        return String.valueOf(result[0][0]);
    }

    private long[][] calculateN(long[][] result, long[][] matrix, long n) {
        for (int i = 3; i <= n; i++) {
            result = multiplyMatrix(result, matrix);
        }
        return result;
    }

    private long[][] calculateLogN(long[][] matrix, long n) {

        long[][] result;
        if (n % 2 == 0) {
            result = new long[][] {{1, 1}, {0, 0}};
        } else {
            result = matrix.clone();
        }

        while (n > 0) {
            n /= 2;
            matrix = multiplyMatrix(matrix, matrix);
            if (n % 2 > 0) {
                    result = multiplyMatrix(matrix, result);
            }
        }
        return result;
    }

    private long[][] multiplyMatrix(long[][] m1, long[][] m2) {
        long l00 = m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0];
        long l01 = m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1];

        long l10 = m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0];
        long l11 = m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1];
        return new long[][]{{l00, l01}, {l10, l11}};
    }
}
