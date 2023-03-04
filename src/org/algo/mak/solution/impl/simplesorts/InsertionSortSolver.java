package org.algo.mak.solution.impl.simplesorts;

import org.algo.mak.solution.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertionSortSolver extends Solver {

    private Integer[] array;

    public InsertionSortSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        int size = Integer.valueOf(list.get(0));
        array = Arrays.stream(list.get(1).split(" ")).map(Integer::valueOf).toArray(Integer[]::new);

        for (int i = 0; i < size - 1; i++) {
            for (int j = i; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(j, j + 1);
            }
        }

        return Arrays.stream(array).map(String::valueOf).collect(Collectors.joining(" "));
    }

    private void swap(int l, int r) {
        int i = array[l];
        array[l] = array[r];
        array[r] = i;
    }
}
