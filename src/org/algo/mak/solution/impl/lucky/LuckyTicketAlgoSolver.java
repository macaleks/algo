package org.algo.mak.solution.impl.lucky;

import org.algo.mak.solution.Solver;

import java.util.List;
import java.util.stream.IntStream;

public class LuckyTicketAlgoSolver extends Solver {

    public LuckyTicketAlgoSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        int n = Integer.valueOf(list.get(0));
        if (n <= 0) return "0";
        if (n == 1) return "10";

        int[] luckyNumCountArray = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        //recursive solution
        luckyNumCountArray = calc(2, n, luckyNumCountArray);

        //iteration solution
//        for (int i = 2; i <= n; i++) {
//            int lineLength = 9 * n + 1;
//            int[][] matrix = fillMatrix(luckyNumCountArray, lineLength);
//            luckyNumCountArray = buildLuckyNumCountArray(matrix, lineLength);
//        }

        Long sum = IntStream.of(luckyNumCountArray).boxed().map(Integer::longValue).map(l -> l * l).reduce(0L, (i, v) -> i + v);
        return String.valueOf(sum);
    }

    private int[] calc(int i, int n, int[] luckyNumCountArray) {
        if (i > n) return luckyNumCountArray;

        int lineLength = 9 * n + 1;
        int[][] matrix = fillMatrix(luckyNumCountArray, lineLength);
        luckyNumCountArray = buildLuckyNumCountArray(matrix, lineLength);
        return calc(++i, n, luckyNumCountArray);
    }

    private int[][] fillMatrix(int[] pattern, int lineLength) {
        int[][] matrix = new int[10][lineLength];

        for (int j = 0; j < 10; j++) {
            int[] line = new int[lineLength];
            int patternIdx = 0;
            for (int k = 0; k < lineLength; k++) {
                if (j <= k && patternIdx < pattern.length) {
                    line[k] = pattern[patternIdx++];
                }
            }
            matrix[j] = line;
        }
        return matrix;
    }

    private int[] buildLuckyNumCountArray(int[][] matrix, int lineLength) {
        int[] pattern = new int[lineLength];

        for (int p = 0; p < 10; p++) {
            for (int q = 0; q < lineLength; q++) {
                pattern[q] += matrix[p][q];
            }
        }
        return pattern;
    }
}
