package org.algo.mak.solution.impl.trie.prefix.tree;

public class TrieMap<T> implements Map<T> {

    private final int A = 126;
    private final Node[] nodes = new Node[A];

    @Override
    public void put(String key, T value) {
        Node[] next = nodes;
        Node<T> parent = null;
        int count = 0;
        for (int i = 0; i < key.length(); i++) {
            count++;
            Node node = next[key.charAt(i)];
            if (next[key.charAt(i)] == null) {
                next[key.charAt(i)] = node = new Node(parent);
                parent = node;
            }
            if (count == key.length()) {
                node.end = true;
                node.value = value;
            }
            next = node.next;
        }
    }

    @Override
    public T get(String key) {
        var node = find(key);
        if (node != null && node.end == true) {
            return node.value;
        }
        return null;
    }

    @Override
    public T remove(String key) {
        var node = find(key);
        T value = null;
        if (node != null) {
            value = node.value;
            node.end = false;
            node.value = null;
            //cleanup
            int index = key.length() - 1;
            while (node != null && node.end == false && node.next == null) {
                var parent = node.parent;
                char ch = key.charAt(index--);
                if (parent != null) {
                    parent.next[ch] = null;
                } else {
                    nodes[ch] = null;
                }
                node = parent;
            }
        }
        return value;
    }

    private Node<T> find(String key) {
        Node[] next = nodes;
        Node node = null;
        for (int i = 0; i < key.length(); i++) {
            node = next[key.charAt(i)];
            if (node == null)
                break;
            next = node.next;
        }
        return node;
    }

    private class Node<T> {
        final Node parent;
        T value;
        boolean end = false;
        Node[] next = new Node[A];

        public Node(Node<T> parent) {
            this.parent = parent;
        }
    }
}
