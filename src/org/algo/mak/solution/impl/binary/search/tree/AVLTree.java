package org.algo.mak.solution.impl.binary.search.tree;

import java.util.Comparator;

public class AVLTree<T> {
        private Node<T> root;
        private final Comparator<T> comparator;

        public AVLTree(Comparator<T> comparator) {
            this.comparator = comparator;
        }

        public void insert(T value) {
            Node<T> node = new Node<>(value);
            if (root == null) {
                root = node;
                return;
            }
            insert(root, node);
        }

        public void insert(Node<T> node, Node<T> newNode) {
            if (comparator.compare(node.value, newNode.value) > 0) {
                if (node.left == null) {
                    node.left = newNode;
                    newNode.parent = node;
                } else {
                    insert(node.left, newNode);
                }
            } else if ((comparator.compare(node.value, newNode.value) < 0)) {
                if (node.right == null) {
                    node.right = newNode;
                    newNode.parent = node;
                } else {
                    insert(node.right, newNode);
                }
            }
        }

        public boolean search(T value) {
            if (root == null) {
                return false;
            }
            return search(root, value) != null;
        }

        private Node<T> search(Node<T> node, T value) {
            if (comparator.compare(node.value, value) > 0) {
                if (node.right == null) {
                    return null;
                } else {
                    return search(node.left, value);
                }
            } else if ((comparator.compare(node.value, value) < 0)) {
                if (node.right == null) {
                    return null;
                } else {
                    return search(node.right, value);
                }
            } else if (comparator.compare(node.value, value) == 0) {
                return node;
            }
            return null;
        }

        public void remove(T value) {
            if (root == null) {
                return;
            }
            var node = search(root, value);
            remove(node);
        }

        public void remove(Node<T> node) {
            if (node.left == null && node.right == null) {
                remove(node, null);
            } else if (node.left == null) {
                remove(node, node.right);
            } else if (node.right == null) {
                remove(node, node.left);
            } else {
                var maxInLeft = maxInNode(node.left);
                swapValues(node, maxInLeft);
                remove(maxInLeft);
            }
        }

        private void remove(Node<T> node, Node<T> child) {
            if (node.parent.left == node) {
                node.parent.left = child;
            } else
                node.parent.right = child;

            if (node.left == child)
                node.left = null;
            else
                node.right = null;
        }

        private Node<T> maxInNode(Node<T> node) {
            if (node.right == null) {
                return node;
            }
            return maxInNode(node.right);
        }

        private void swapValues(Node<T> node1, Node<T> node2) {
            T tmp = node1.value;
            node1.value = node2.value;
            node2.value = tmp;
        }

    private static class Node<T> {
        int height;
        
        T value;
        Node<T> parent;
        Node<T> left;
        Node<T> right;
        

        public Node(T value) {
            this.value = value;
        }
    }

    public void smallLeftRotation(Node<T> t) {

    }

    public void smallRightRotation(Node<T> node) {
        var newParent = node.left;
        var rNode = newParent.right;

        newParent.parent = node.parent;
        newParent.right = node;

        node.left = rNode;
        node.parent = newParent;


        if (node == root) {
            node.value = newParent.value;
            node.left = newParent.left;
            node.right = newParent.right;
        }
        node = newParent;

    }

    public void bigLeftRotation(Node<T> t) {

    }

    public void bigRightRotation(Node<T> t) {

    }
    
}
