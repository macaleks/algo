package org.algo.mak.solution.impl.hashtable;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;

public class HashTable<K, V> {
    private final int INIT_CAPACITY = 11;
    private final int THRESHOLD = 50;
    private int capacity = INIT_CAPACITY;
    private Entry<K, V>[] table = new Entry[capacity];

    private int size = 0;
    public void put(K key, V value) {
        if (size*100/capacity > THRESHOLD) {
            rehash();
        }
        var newEntry = new Entry<>(key, value);
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % capacity;
        var entry = table[index];
        if (entry == null) {
            table[index] = newEntry;
        } else {
            var dummy = new Entry<>(entry);
            var e = dummy;
            while (e.next != null) {
                if (key.equals(e.next.key)) {
                    e.next.value = value;
                    return;
                }
                e = e.next;
            }
            e.next = newEntry;
            table[index] = dummy.next;
        }
        size++;
    }

    private int hash(int khash) {
        int hash = khash;
        return (hash & 0x7FFFFFFF) % capacity;
    }
    public V get(K key) {
        int index = hash(key.hashCode());
        var entry = table[index];
        if (entry != null) {
            while (entry != null) {
                if (key.equals(entry.key)) {
                    return entry.value;
                }
                entry = entry.next;
            }
        }
        throw new NoSuchElementException("No such element with key " + key);
    }

    public V remove(K key) {
        int index = hash(key.hashCode());
        var entry = table[index];
        var dummy = new Entry<>(entry);
        var e = dummy;
        while (e.next != null) {
            if (key.equals(e.next.key)) {
                V value = e.next.value;
                e.next = e.next.next;
                table[index] = dummy.next;
                size--;
                return value;
            }
            e = e.next;
        }
        throw new NoSuchElementException("No such element with key " + key);
    }

    private void rehash() {
        capacity = capacity * capacity;
        size = 0;
        var entries = table;
        table = new Entry[capacity];
        for (int i = 0; i < entries.length; i++) {
            var entry = entries[i];
            if (entry == null) continue;
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Entry(Entry<K, V> next) {
            this.next = next;
        }
    }
}
