package edu.wpi.first.wpilibj.networktables;

abstract class Entry implements Data {

    public static class UnsupportedOperationException extends RuntimeException {

        public UnsupportedOperationException() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }

    static class TableEntry extends Entry {

        private NetworkTable value;

        public TableEntry(NetworkTable value) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        Object grabValue() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        NetworkTable getTable() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        int getType() {
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

    static class StringEntry extends Entry {

        private String value;

        public StringEntry(String value) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        Object grabValue() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        String getString() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        int getType() {
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

    static class BooleanEntry extends Entry {

        private boolean value;

        public BooleanEntry(boolean value) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        Object grabValue() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        boolean getBoolean() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        int getType() {
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

    static class IntegerEntry extends Entry {

        private int value;

        public IntegerEntry(int value) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        Object grabValue() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        int getInt() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        int getType() {
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

    static class DoubleEntry extends Entry {

        private double value;

        public DoubleEntry(double value) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        Object grabValue() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        double getDouble() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        int getType() {
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
    private Key key;
    private Connection source;
    private Object value;

    Entry() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    void setKey(Key key) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    Key getKey() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    abstract int getType();

    void setSource(Connection source) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    Connection getSource() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    abstract Object grabValue();

    public Object getValue() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void encode(Buffer buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    int getInt() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    double getDouble() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    boolean getBoolean() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    String getString() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    NetworkTable getTable() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public boolean equals(Object obj) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public int hashCode() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
