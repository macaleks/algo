package org.algo.mak.solution.impl.binary.search.tree;

import java.io.IOException;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        var comparator = Comparator.comparing(Integer::intValue);
//        var node = new SimpleBinaryTree<>(50, comparator, null);
//        node.insert(40);
//        node.insert(30);
//        node.insert(100);
//        node.insert(70);
//        node.insert(120);
//        node.insert(60);
//
//        System.out.println(node.search(100));
//        System.out.println(node.search(101));
//
//        node.remove(100);
//        System.out.println(node.search(100));

//        var node = new AVL<>(80, comparator, null);
//        node.insert(50);
//        node.insert(30);
//        node.insert(25);
//        node.insert(15);
//        node.insert(28);
//        node.insert(60);
//        node.insert(55);
//        node.insert(100);
//        node.insert(120);
//
//        var node1 = new AVL<>(80, comparator, null);
//        var node2 = node1;
//        var node3 = new AVL<>(88, comparator, null);
//        node2 = node3;


        var node = new SimpleTree<>(comparator);
        node.insert(50);
        node.insert(40);
        node.insert(30);
        node.insert(100);
        node.insert(70);
        node.insert(120);
        node.insert(60);


        System.out.println(node.search(100));
        System.out.println(node.search(101));

        node.remove(100);
        System.out.println(node.search(100));
    }
}
