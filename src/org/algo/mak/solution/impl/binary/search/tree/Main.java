package org.algo.mak.solution.impl.binary.search.tree;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(Comparator.comparing(Integer::intValue));
        tree.insert(56);
        tree.insert(70);
        tree.insert(20);
        tree.insert(30);
        tree.insert(100);
        tree.insert(94);
        tree.insert(67);
        tree.insert(6);
        tree.insert(27);

        tree.remove(56);

        System.out.println(tree.search(100));
        System.out.println(tree.search(28));
    }
}
