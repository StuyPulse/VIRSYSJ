package edu.wpi.first.wpilibj.networktables;

import java.util.Hashtable;

class CountingQueue {

    private static class Counter {

        private int value;

        private Counter() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        void increment() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        void decrement() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        int value() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }
    Hashtable counts;
    LinkedList queue;

    CountingQueue() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public synchronized void offer(Entry entry) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public synchronized Entry poll() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public synchronized boolean containsKey(Key key) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public boolean isEmpty() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
