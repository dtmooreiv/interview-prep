package me.treymoore.interview.hashtables;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K,V> {
    private ArrayList<LinkedList<HashRecord<K,V>>> table;

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = .75f;

    public HashTable(){
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTable(int initialCapacity, float loadFactor){
        table = new ArrayList<LinkedList<HashRecord<K,V>>>(initialCapacity);
        for(int i = 0; i < initialCapacity; i++) {
            table.add(new LinkedList<HashRecord<K, V>>());
        }
    }

    //This method adds a key-value pair into the table, overwriting
    //the old value if the key is already in the table
    //Returns the inserted value
    public V put(K key, V val) {
        //Hash the key's hashCode
        int hash = Hashes.hash(key.hashCode());
        //Calculate the offset into the table from the hash and the table size
        int index = Hashes.indexFor(hash, table.size());

        //Get the list of records at the index
        LinkedList<HashRecord<K,V>> list = table.get(index);
        HashRecord<K, V> newHashRecord = new HashRecord<K, V>(key, val);
        //Check to see if key already exists in table
        for(HashRecord<K,V> hashRecord : list) {
            if(hashRecord.getKey() == key) {
                list.set(list.indexOf(hashRecord), newHashRecord);
                return val;
            }
        }

        //If we've gotten here, the key didn't already exist in the table
        //So we need to add it.
        list.add(newHashRecord);

        return val;
    }

    //Returns the value associated with a given key
    //Return null if key is not in the table
    public V get(K key) {
        int index = indexOf(key);
        LinkedList<HashRecord<K, V>> hashRecords = table.get(index);
        for(HashRecord<K,V> hashRecord : hashRecords) {
            if(hashRecord.getKey() == key) {
                return hashRecord.getVal();
            }
        }

        return null;
    }

    //Removes a key from the table and returns its value
    //Returns null if key not in table
    public V remove(K key) {
        int index = indexOf(key);

        LinkedList<HashRecord<K,V>> records = table.get(index);
        for(HashRecord<K,V> record : records) {
            if(record.getKey() == key) {
                records.remove(record);
                return record.getVal();
            }
        }

        return null;
    }

    //TODO
    public List<K> getKeys() {
        List<K> keys = new ArrayList<K>(table.size());
        for(int i = 0; i < table.size(); i++) {
            LinkedList<HashRecord<K, V>> hashRecords = table.get(i);
            for(HashRecord<K,V> hashRecord : hashRecords) {
                keys.add(hashRecord.getKey());
            }
        }

        return keys;
    }

    private int indexOf(K key) {
        return Hashes.indexFor(Hashes.hash(key.hashCode()), table.size());
    }

    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<String, String>();
        hashTable.put("Frank", "Cranton");
        hashTable.put("Jill", "Fontano");
        hashTable.put("Alex", "Marizzy");


        System.out.println(hashTable.get("Frank"));
        List<String> keys = hashTable.getKeys();
        for(String key : keys) {
            System.out.println("Key: " + key + " value: "  + hashTable.get(key));
        }

        String removed = hashTable.remove("Alex");
        System.out.println("Removed value: " + removed);
        System.out.println("Getting Alex now returns: " + hashTable.get("Alex"));

        String notRemoved = hashTable.remove("NotInTable");
        if(notRemoved == null) {
            System.out.println("Key not in table");
        } else {
            System.out.println("This is unexpected");
        }
    }
}

class HashRecord<K,V> {
    public HashRecord(K key, V val) {
        this.key = key;
        this.val = val;
    }

    private K key;
    private V val;


    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }
}
