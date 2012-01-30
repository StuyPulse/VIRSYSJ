package edu.wpi.first.wpilibj.can;


public class JaguarCANDriver {

    public static final int kMaxMessageDataSize = 8;
    public int receivedMessageId;

    public JaguarCANDriver() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static void sendMessage(int messageID, byte[] data, int dataSize) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public byte receiveMessage(int messageID, byte[] data, double timeout) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public byte receiveMessage(int messageID, byte[] data) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public boolean receiveMessageStart(int messageID, Object sem, double timeout) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public byte receiveMessageComplete(int messageID, byte[] data) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
