package org.algo.mak.solution.impl.binary.search.tree;

import java.util.Comparator;

public class Tree<E> {

    private Node<E> root;
    private final Comparator<E> comparator;

    public Tree(Node<E> root, Comparator<E> comparator) {
        this.root = root;
        this.comparator = comparator;
    }

    public Tree(Comparator<E> comparator) {
        this((Node<E>) null, comparator);
    }

    public Tree(E item, Comparator<E> comparator) {
        this.root = new Node<>(item);
        this.comparator = comparator;
    }

    public void insert(E item) {
        root = insert(item, root);
    }

    private Node<E> insert(E item, Node<E> node) {
        if (node == null) return new Node<>(item);
        if (comparator.compare(node.item, item) > 0) {
            node.left = insert(item, node.left);
        } else if (comparator.compare(node.item, item) < 0) {
            node.right = insert(item, node.right);
        }
        return node;
    }

    public boolean search(E item) {
        return search(item, root);
    }

    private boolean search(E item, Node<E> node) {
        if (node == null) return false;
        if (comparator.compare(node.item, item) > 0) {
             return search(item, node.left);
        } else if (comparator.compare(node.item, item) < 0) {
            return search(item, node.right);
        } else {
            return true;
        }
    }

    public void remove(E item) {
        root = remove(item, root);
    }

    private Node<E> remove(E item, Node<E> node) {
        if (node == null) return null;
        if (comparator.compare(node.item, item) > 0) {
            node.left = remove(item, node.left);
        } else if (comparator.compare(node.item, item) < 0) {
            node.right = remove(item, node.right);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                node.item = max(node.left);
                node.left = remove(node.item, node.left);
            }
        }
        return node;
    }

    private E max(Node<E> node) {
        E maxItem = node.item;
        while (node.right != null) {
            maxItem = node.right.item;
            node = node.right;
        }
        return maxItem;
    }

    private static class Node<E> {
        E item;
        Node<E> left;
        Node<E> right;

        Node(E element) {
            this.item = element;
        }
    }
}
