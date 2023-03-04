package org.algo.mak.solution.impl.linear;

import org.algo.mak.solution.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RadixSortSolver extends Solver {

    private int[] array;

    public RadixSortSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        int size = Integer.valueOf(list.get(0));
        array = Arrays.stream(list.get(1).split(" ")).map(Integer::valueOf).mapToInt(Integer::intValue).toArray();

        int max = getMax();
        int numbersCount = getNumbersCount(max);
        int[] result = new int[size];

        for (int i = 0; i < numbersCount; i++) {
            int[] radix = countDigits(array, i);

            for (int j = size - 1; j >= 0; j--) {
                int r = getRadix(array[j], i);
                int index = --radix[r];
                result[index] = array[j];
                array[j] /= 10;
            }
            array = result.clone();
        }

        return Arrays.stream(result).boxed().map(String::valueOf).collect(Collectors.joining(" "));
    }

    private int getMax() {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    private int getNumbersCount(int max) {
        int numbersCount = 0;
        do {
            numbersCount++;
            max /= 10;
        } while (max != 0);
        return numbersCount;
    }

    private int[] countDigits(int[] array, int power) {
        int[] radix = new int[10];

        for (int j = 0; j < array.length; j++) {
            int r = getRadix(array[j], power);
            radix[r]++;
        }

        for (int j = 1; j < 10; j++) {
            radix[j] += radix[j - 1];
        }
        return radix;
    }

    private int pow(int a, int b) {
        int i = 1;
        for (int j = 0; j < b; j++) {
            i *= a;
        }
        return i;
    }

    private int getRadix(int value, int power) {
        return value / pow(10, power) % 10;
    }
}
