package org.algo.mak.solution.impl.base.structure.model;

public class SingleArray<T> implements IArray<T> {

    private Object[] array;

    public SingleArray () {
        array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        resize();
        array[size() - 1] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    private void resize() {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }

    @Override
    public T remove(int index) {
        Object[] newArray = new Object[size() - 1];
        T object = (T) array[index];
        int arrayI = 0;
        int newArrayI = 0;
        while (arrayI < size()) {
            if (arrayI == index) {
                arrayI++;
                continue;
            }
            newArray[newArrayI++] = array[arrayI++];
        }
        array = newArray;
        return object;
    }
}
