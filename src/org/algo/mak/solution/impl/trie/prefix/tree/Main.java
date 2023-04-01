package org.algo.mak.solution.impl.trie.prefix.tree;

public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");


        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("add"));


        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("--------TrieMap-----------");


        Map<String> trieMap = new TrieMap<>();
        trieMap.put("apple", "green");
        trieMap.put("app", "new");
        trieMap.put("alter", "first");
        trieMap.put("a", "a");

        System.out.println(trieMap.get("apple"));
        System.out.println(trieMap.get("app"));
        System.out.println(trieMap.get("alter"));
        System.out.println(trieMap.get("a"));

        System.out.println("------------------------------");

        System.out.println(trieMap.remove("a"));

        System.out.println("------------------------------");

        System.out.println(trieMap.get("apple"));
        System.out.println(trieMap.get("app"));
        System.out.println(trieMap.get("alter"));
        System.out.println(trieMap.get("a"));
    }
}