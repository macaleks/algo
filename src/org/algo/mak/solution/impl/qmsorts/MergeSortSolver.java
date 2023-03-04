package org.algo.mak.solution.impl.qmsorts;

import org.algo.mak.solution.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortSolver extends Solver {

    private Integer[] array;

    public MergeSortSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        int size = Integer.valueOf(list.get(0));
        array = Arrays.stream(list.get(1).split(" ")).map(Integer::valueOf).toArray(Integer[]::new);

        msort(0, size - 1);

        return Arrays.stream(array).map(String::valueOf).collect(Collectors.joining(" "));
    }

    private void msort(int l, int r) {

        if (l >= r) return;
        int m = (l + r) / 2;
        msort(l, m);
        msort(m + 1, r);
        merge(l, m, r);
    }

    private void merge(int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int a = l;
        int b = m + 1;
        int t = 0;
        while (a <= m && b <= r) {
            if (array[a] < array[b])
                temp[t++] = array[a++];
            else
                temp[t++] = array[b++];
        }

        while (a <= m) {
            temp[t++] = array[a++];
        }

        while (b <= r) {
            temp[t++] = array[b++];
        }

        for (int i = l; i <= r; i++) {
            array[i] = temp[i - l];
        }
    }

    private void swap(int l, int r) {
        int i = array[l];
        array[l] = array[r];
        array[r] = i;
    }
}
