package edu.wpi.first.wpilibj.networktables;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

class Connection {

    private class Watchdog extends Thread {

        private final Object lock;
        boolean active;
        boolean fed;

        private Watchdog() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        public void run() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        private void activate() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        private void feed() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }
    private static final long WRITE_DELAY = 250L;
    private static final long TIMEOUT = 1000L;
    private final Hashtable tables;
    private final Hashtable fields;
    private final Object dataLock;
    private final NetworkQueue queue;
    private final CountingQueue confirmations;
    private final NetworkQueue transaction;
    private boolean connected;
    private boolean inTransaction;
    private boolean denyTransaction;
    private Watchdog watchdog;

    Connection(java.lang.Object socket) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    Object getLock() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    void offerTransaction(NetworkQueue transaction) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    void offer(Data data) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    void start() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private void read(InputStream stream) throws IOException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private NetworkTable getTable(boolean local, Integer id) throws IOException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private void write(OutputStream output) throws IOException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private synchronized void close() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
