package org.algo.mak.solution.impl.linear;

import org.algo.mak.solution.Solver;

import java.util.Arrays;

public class BucketSortSolver extends Solver {

    private int[] array;
    int max = 0;

    public BucketSortSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(java.util.List<String> list) {
        int size = Integer.valueOf(list.get(0));
        array = Arrays.stream(list.get(1).split(" ")).map(Integer::valueOf).mapToInt(Integer::intValue).toArray();

        max = getMax();
        List[] buckets = new List[size];

        for (int i = 0; i < size; i++) {
            int value = array[i];
            int index = calculateNewPosition(value, size);
            buckets[index] = new List(value, buckets[index]);
            List lst = buckets[index];
            while (lst.next != null) {
                if (value > lst.next.value) {
                    List node = new List(lst.value, lst.next.next);
                    lst = lst.next;
                    lst.next = node;
                }
                lst = lst.next;
            }
        }

        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            List node = buckets[i];
            while (node != null) {
                string.append(node.value);
                string.append(" ");
                node = node.next;
            }
        }

        return string.toString().trim();
    }

    private int calculateNewPosition(long value, long size) {
        Long index = value * size / max;
        return index.intValue();
    }

    private int getMax() {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return ++max;
    }

    class List {

        private int value;
        private List next;

        public List(int value) {
            this(value, null);
        }

        public List(int value, List next) {
            this.value = value;
            this.next = next;
        }
    }
}
