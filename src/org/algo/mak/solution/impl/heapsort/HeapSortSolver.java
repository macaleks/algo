package org.algo.mak.solution.impl.heapsort;

import org.algo.mak.solution.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeapSortSolver extends Solver {

    private Integer[] array;

    public HeapSortSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        int size = Integer.valueOf(list.get(0));
        array = Arrays.stream(list.get(1).split(" ")).map(Integer::valueOf).toArray(Integer[]::new);

        for (int i = size/2 -1; i >= 0; i--) {
            heapify(i, size);
        }

        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            heapify(0, i);
        }

        return Arrays.stream(array).map(String::valueOf).collect(Collectors.joining(" "));
    }

    private void heapify(int root, int size) {
        int x = root;
        int l = x * 2 + 1;
        int r = x * 2 + 2;

        if (l < size && array[l] > array[x]) x = l;
        if (r < size && array[r] > array[x]) x = r;
        if (root != x) {
            swap(root, x);
            heapify(x, size);
        }
    }

    private void swap(int root, int x) {
        int rootVal = array[root];
        array[root] = array[x];
        array[x] = rootVal;
    }
}
