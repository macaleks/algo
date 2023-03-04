package org.algo.mak.solution.impl.heapsort;

import org.algo.mak.solution.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSortSolver extends Solver {

    private Integer[] array;
    public BubbleSortSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        int size = Integer.valueOf(list.get(0));
        array = Arrays.stream(list.get(1).split(" ")).map(Integer::valueOf).toArray(Integer[]::new);

        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1])
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
