package org.algo.mak.solution.impl.base.structure.model;

public interface IArray<T> {
    int size();
    void add(T item);
    T get(int index);
    T remove(int index);
}
