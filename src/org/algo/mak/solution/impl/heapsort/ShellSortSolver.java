package org.algo.mak.solution.impl.heapsort;

import org.algo.mak.solution.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShellSortSolver extends Solver {

    private Integer[] array;

    public ShellSortSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        int size = Integer.valueOf(list.get(0));
        array = Arrays.stream(list.get(1).split(" ")).map(Integer::valueOf).toArray(Integer[]::new);

        for (int gap = size / 2; gap > 0; gap /= 2)
            for (int i = gap; i < size ; i++)
                for (int j = i; j >= gap && array[j - gap] > array[j]; j -= gap)
                    swap(j - gap, j);

        return Arrays.stream(array).map(String::valueOf).collect(Collectors.joining(" "));
    }

    private void swap(int l, int r) {
        int i = array[l];
        array[l] = array[r];
        array[r] = i;
    }
}
