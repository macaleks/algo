package org.algo.mak.solution.impl.qmsorts;

import org.algo.mak.solution.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSortSolver extends Solver {

    private Integer[] array;

    public QuickSortSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        int size = Integer.valueOf(list.get(0));
        array = Arrays.stream(list.get(1).split(" ")).map(Integer::valueOf).toArray(Integer[]::new);

        qsort(0, size -1);

        return Arrays.stream(array).map(String::valueOf).collect(Collectors.joining(" "));
    }

    private void qsort(int l, int r) {

        if (l == -1 || l >= r) return;
        int m = split(l, r);
        qsort(l, m - 1);
        qsort(m, r);
    }

    private int split(int l, int r) {
        int p = array[r];
        int m = l - 1;
        for (int j = l; j <= r; j++) {
            if (array[j] <= p)
                swap(++m, j);
        }
        return m == l - 1 ? p : m;
    }

    private void swap(int l, int r) {
        int i = array[l];
        array[l] = array[r];
        array[r] = i;
    }
}
