package me.treymoore.interview.hashtables;

public class Hashes {

    //The hashing functions are taken from http://docjar.com/html/api/java/util/HashMap.java.html
    public static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public static int indexFor(int h, int length) {
        return h & (length -1);
    }
}
