package org.algo.mak.solution.impl.cartesian.tree;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        CTree<Integer> tree1 = new CTree<>(Comparator.comparing(Integer::intValue));
        tree1.insert(new CTree.Node(8, 10));
        tree1.insert(new CTree.Node(6, 7));
        tree1.insert(new CTree.Node(15, 6));
        tree1.insert(new CTree.Node(20, 3));
        tree1.insert(new CTree.Node(12, 4));
        tree1.insert(new CTree.Node(10, 2));
        tree1.insert(new CTree.Node(14, 1));

        tree1.insert(13, 5);

        CTree<Integer> tree2 = new CTree<>(Comparator.comparing(Integer::intValue));
        tree2.insert(20, 3);
        tree2.insert(6, 7);
        tree2.insert(8, 10);
        tree2.insert(15, 6);
        tree2.insert(13, 5);
        tree2.insert(10, 2);
        tree2.insert(14, 1);
        tree2.insert(12, 4);

        var list1 = tree1.toList();
        var list2 = tree2.toList();
        System.out.println(list1.equals(list2));

        System.out.println(tree2.pull());

    }
}
