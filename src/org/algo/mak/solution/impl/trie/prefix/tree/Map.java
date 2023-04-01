package org.algo.mak.solution.impl.trie.prefix.tree;

public interface Map<T> {

    void put(String key, T value);

    T get(String key);

    T remove(String key);
}
