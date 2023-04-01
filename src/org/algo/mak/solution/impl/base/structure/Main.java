package org.algo.mak.solution.impl.base.structure;



import org.algo.mak.solution.impl.base.structure.model.*;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        IArray singleArray = new SingleArray();
        IArray vectorArray = new VectorArray();
        IArray factorArray = new FactorArray();
        IArray matrixArray = new MatrixArray();
        testAddArray(singleArray, 100_000);
        testAddArray(vectorArray, 100_000);
        testAddArray(factorArray, 100_000);
        testAddArray(matrixArray, 100_000);

        testRemoveArray(singleArray, 4);
        testRemoveArray(vectorArray, 4);
        testRemoveArray(factorArray, 4);
        testRemoveArray(matrixArray, 4);
    }

    private static void testAddArray(IArray data, int total) {
        long start = System.currentTimeMillis();

        for (int j = 0; j < total; j ++)
            data.add(j);

        System.out.println(data.getClass().getSimpleName() + " testAddArray: " +
                (System.currentTimeMillis() - start));
    }

    private static void testRemoveArray(IArray data, int index) {
        long start = System.currentTimeMillis();

        data.remove(4);

        System.out.println(data.getClass().getSimpleName() + " testRemoveArray: " +
                (System.currentTimeMillis() - start));
    }
}
