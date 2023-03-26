package org.algo.mak.solution.impl.base.structure.model;

import java.util.ArrayList;

public class MatrixArray<T> implements IArray<T> {

    private int size;
    private int vector;
    private IArray<IArray<T>> array;

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new SingleArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size == array.size() * vector)
            array.add(new VectorArray<T>(vector));
        array.get(size / vector).add(item);
        size ++;
    }

    @Override
    public T get(int index) {
        return array.get(index / vector).get(index % vector);
    }

    @Override
    public T remove(int index) {
        T object = get(index);
        int mainI = index / vector;
        IArray<T> innerArray = array.get(mainI);
        innerArray.remove(index % vector);
        mainI++;
        while (mainI * vector < size) {
            IArray<T> vectorArray = array.get(mainI);
            innerArray.add(vectorArray.get(0));
            vectorArray.remove(0);

            mainI++;
            innerArray = vectorArray;
        }
        size--;
        return object;
    }
}
