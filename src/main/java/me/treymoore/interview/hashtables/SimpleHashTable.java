package me.treymoore.interview.hashtables;

public class SimpleHashTable<K,V> {

}

class Entry<K,V> {
    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

    private K key;
    private V value;
    private Entry<K,V> next;
    private int hash;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
}