package edu.wpi.first.wpilibj.networktables;

import java.util.Hashtable;

class Key implements Data {

    private static Hashtable ids;
    private static int currentId;
    private final NetworkTable table;
    private final String key;
    private Entry entry;
    private final Integer id;

    private static synchronized Integer grabId() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    static Key getKey(Integer id) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public Key(NetworkTable table, String key) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public NetworkTable getTable() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public synchronized int getType() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public synchronized Entry getEntry() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public String getName() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    synchronized Entry setEntry(Entry entry) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    boolean hasEntry() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    Integer getId() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    void encodeName(Buffer buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void encode(Buffer buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public String toString() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
