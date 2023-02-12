package org.algo.mak.solution.impl.lucky;

import org.algo.mak.solution.Solver;

import java.util.List;

public class LuckyTicketRecursiveSolver extends Solver {

    private static long count = 0;

    public LuckyTicketRecursiveSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        int n = Integer.valueOf(list.get(0));

        count = 0;

        solve(n, 0, 0);

        return String.valueOf(count);
    }

    private void solve(int n, int l, int r) {
        if (n == 0) {
            if (l == r) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                solve(n - 1, l + i, r + j);
            }
        }
    }
}
