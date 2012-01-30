package edu.wpi.first.wpilibj.networktables;

import java.io.IOException;
import java.io.OutputStream;

class Buffer {

    public static class BufferOverflowException extends IndexOutOfBoundsException {

        public BufferOverflowException(String message) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }
    private byte[] buffer;
    private int size;
    private OutputStream stream;

    public Buffer(int capacity, OutputStream output) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void writeString(String entry) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void writeDouble(double entry) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void writeInt(int entry) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void writeId(int id) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void writeTableId(int id) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private void writeVariableSize(int tag, int id) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void writeBytes(byte[] entries) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void writeByte(int entry) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void flush() throws IOException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void clear() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public String toString() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
