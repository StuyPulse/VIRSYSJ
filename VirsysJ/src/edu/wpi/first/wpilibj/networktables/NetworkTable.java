package edu.wpi.first.wpilibj.networktables;

import java.util.Hashtable;
import java.util.Vector;

public class NetworkTable {

    private static Hashtable tables;
    private static int currentId;
    private static Hashtable ids;
    private Set connections;
    private Set listenToAllListeners;
    private Hashtable listeners;
    private Set additionListeners;
    private Set connectionListeners;
    private final Object listenerLock;
    private Hashtable data;
    private final Integer id;
    private NetworkQueue transaction;
    private int transactionCount;
    private NetworkQueue hasChanged;
    private NetworkQueue hasAdded;

    public static synchronized void initialize() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static synchronized NetworkTable getTable(String name) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    static NetworkTable getTable(Integer id) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private synchronized Integer grabId() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public NetworkTable() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void beginTransaction() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void endTransaction() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    void processTransaction(boolean confirmed, NetworkQueue transaction) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    Integer getId() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    void addConnection(Connection connection) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    void removeConnection(Connection connection) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public Vector getKeys() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    Key getKey(String name) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void putInt(String key, int value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void putBoolean(String key, boolean value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void putDouble(String key, double value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void putString(String key, String value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void putSubTable(String key, NetworkTable value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private void put(String field, Entry value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private void send(Entry entry) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void addListener(String key, NetworkListener listener) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void addListenerToAll(NetworkListener listener) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void removeListener(String key, NetworkListener listener) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void removeListenerFromAll(NetworkListener listener) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void addAdditionListener(NetworkAdditionListener listener) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void removeAdditionListener(NetworkAdditionListener listener) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void addConnectionListener(NetworkConnectionListener listener, boolean immediateNotify) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void removeConnectionListener(NetworkConnectionListener listener) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public Object getValue(String key) throws NetworkTableKeyNotDefined {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public int getInt(String key) throws NetworkTableKeyNotDefined {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getDouble(String key) throws NetworkTableKeyNotDefined {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public String getString(String key) throws NetworkTableKeyNotDefined {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public NetworkTable getSubTable(String key) throws NetworkTableKeyNotDefined {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public boolean getBoolean(String key) throws NetworkTableKeyNotDefined {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public int getInt(String key, int defaultValue) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getDouble(String key, double defaultValue) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public String getString(String key, String defaultValue) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public boolean isConnected() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public boolean containsKey(String key) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    Entry getEntry(String key) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    void got(boolean confirmed, Key key, Entry value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private void alertListeners(boolean isNew, boolean confirmed, String key, Entry value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    void encodeName(Buffer buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
