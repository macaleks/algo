package org.algo.mak.solution.impl.cartesian.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class CTree<E> {

    private Node<E> root;
    private final Comparator<E> comparator;

    public CTree(Node<E> root, Comparator<E> comparator) {
        this.root = root;
        this.comparator = comparator;
    }

    public CTree(Comparator<E> comparator) {
        this((Node<E>) null, comparator);
    }

    public CTree(E item, int priority, Comparator<E> comparator) {
        this.root = new Node<>(item, priority);
        this.comparator = comparator;
    }

    public void insert(E item, int priority) {
        var node = new Node<>(item, priority);
        Node<E>[] split = split(root, item);
        var merged = merge(split[0], node);
        root = merge(merged, split[1]);

    }

    public E pull() {
        var value = root.item;
        root = merge(root.left, root.right);
        return value;
    }

    private Node<E> get(Node<E> node, E item) {
        if (node == null) return null;
        if (comparator.compare(node.item, item) > 0) {
            return get(node.left, item);
        } else if (comparator.compare(node.item, item) < 0) {
            return get(node.right, item);
        } else {
            return node;
        }
    }

    public Node<E>[] split(Node<E> node, E item) {
        if (node == null) return new Node[] {null, null};
        if (comparator.compare(node.item, item) > 0) {
            if (node.left == null) {
                return new Node[]{null, node};
            }
            Node<E>[] nodes = split(node.left, item);
            var node2 = node;
            var node1 = nodes[0];
            node2.left = nodes[1];
            return new Node[] {node1, node2};
        } else {
            if (node.right == null) {
                return new Node[]{node, null};
            }
            Node<E>[] nodes = split(node.right, item);
            var node2 = nodes[1];
            var node1 = node;
            node1.right = nodes[0];
            return new Node[]{node1, node2};
        }
    }

    private Node<E> merge(Node<E> node1, Node<E> node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;
        if (node1.priority > node2.priority) {
            if (comparator.compare(node1.item, node2.item) > 0)
                node1.left = merge(node1.left, node2);
            else
                node1.right = merge(node1.right, node2);
            return node1;
        } else {
            if (comparator.compare(node2.item, node1.item) > 0)
                node2.left = merge(node2.left, node1);
            else
                node2.right = merge(node2.right, node1);
            return node2;
        }
    }

    public static class Node<E> {
        E item;
        int priority;
        Node<E> left;
        Node<E> right;

        Node(E element, int priority) {
            this.item = element;
            this.priority = priority;
        }
    }

    //For testing
    public List<E> toList() {
        var list = new ArrayList<E>();
        Consumer<E> consumer = list::add;
        collect(root, consumer);
        return list;
    }

    private void collect(Node<E> node, Consumer<E> consumer) {
        if (node != null) {
            collect(node.left, consumer);
            consumer.accept(node.item);
            collect(node.right, consumer);
        }
    }

    public void insert(Node<E> node) {
        if (root == null) root = node;
        insert(node, root);
    }

    private Node<E> insert(Node<E> iNode, Node<E> node) {
        if (node == null) return iNode;
        if (comparator.compare(node.item, iNode.item) > 0) {
            node.left = insert(iNode, node.left);
        } else if (comparator.compare(node.item, iNode.item) < 0) {
            node.right = insert(iNode, node.right);
        }
        return node;
    }
}
