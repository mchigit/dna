package dataStructures.hashTable;


import java.util.LinkedList;

//This hashtable will take in Key = String, Value = Int
//Collisions are resolved using chaining
//Assuming all values are distinct
public class HashTable {
    private int elementsNumber;
    private int TABLE_SIZE;
    private LinkedList[] table;

    private int returnIndex(String key) {
        int hashVal = key.hashCode( );
        hashVal %= TABLE_SIZE;
        if (hashVal < 0)
            hashVal += TABLE_SIZE;
        return hashVal;
    }

    public HashTable(int sizeOfTable) {
        elementsNumber = 0;
        TABLE_SIZE = sizeOfTable;
        table = new LinkedList[sizeOfTable];
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    public void put(String key, int value) {
        int index = returnIndex(key);
        if (table[index] == null) {
            LinkedList<HashTableData> data = new LinkedList<HashTableData>();
            data.addFirst(new HashTableData(key, value));
            table[index] = data;
        } else {
            LinkedList<HashTableData> chainedData = table[index];
            chainedData.addLast(new HashTableData(key, value));
        }
        elementsNumber++;
    }

    public boolean containsKey(String key) {
        int index = returnIndex(key);
        if (table[index] == null) return false;
        LinkedList<HashTableData> chainedData = table[index];
        for (int i = 0; i < chainedData.size(); i++) {
            if (chainedData.get(i).getKey() == key) return true;
        }
        return false;
    }

    public int get(String key) {
        int index = returnIndex(key);
        int value = 0;
        if (table[index] == null || !containsKey(key)) {
            throw new NullPointerException("Item does not exist");
        } else {
            LinkedList<HashTableData> chainedData = table[index];
            for (int i = 0; i < chainedData.size(); i++) {
                if (chainedData.get(i).getKey() == key) {
                    value = chainedData.get(i).getValue();
                }
            }
        }
        return value;
    }

    public int getElementsNumber() {
        return elementsNumber;
    }
}
