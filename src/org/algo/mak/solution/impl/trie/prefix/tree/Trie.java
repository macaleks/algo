package org.algo.mak.solution.impl.trie.prefix.tree;

public class Trie {

    private final int A = 126;
    private final Node[] nodes = new Node[A];
    public Trie() {
    }

    public void insert(String word) {
        Node[] next = nodes;
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            count++;
            Node node = next[word.charAt(i)];
            if (next[word.charAt(i)] == null) {
                next[word.charAt(i)] = node = new Node();
            }
            if (count == word.length()) node.end = true;
            next = node.next;
        }

    }

    public boolean search(String word) {
        var node = find(word);
        return node != null && node.end == true;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String word) {
        Node[] next = nodes;
        Node node = null;
        for (int i = 0; i < word.length(); i++) {
            node = next[word.charAt(i)];
            if (node == null)
                break;
            next = node.next;
        }
        return node;
    }

    private class Node {
        boolean end = false;
        Node[] next = new Node[A];
    }
}