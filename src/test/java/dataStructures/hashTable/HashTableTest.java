package dataStructures.hashTable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HashTableTest {

    private HashTable table;

    @Before
    public void setUp() throws Exception {
        table = new HashTable(100);
    }

    @Test
    public void put() {
        table.put("Key1", 1);
        table.put("Key2", 2);
        table.put("Key3", 3);
        assertTrue(table.getElementsNumber() == 3);
    }

    @Test
    public void containsKey() {
        table.put("Key1", 1);
        table.put("Key2", 2);
        assertTrue(table.containsKey("Key1"));
        assertTrue(table.containsKey("Key2"));
        assertTrue(table.containsKey("Key3") == false);
    }

    @Test
    public void get() {
        table.put("Key1", 1);
        table.put("Key2", 2);
        table.put("Key3", 3);
        assertTrue(table.get("Key1") == 1);
        assertTrue(table.get("Key2") == 2);
        assertTrue(table.get("Key3") == 3);
    }

    @Test(expected = NullPointerException.class)
    public void getInvalidElement() {
        table.put("Key1", 1);
        table.put("Key2", 2);
        table.get("Key3");
    }
}