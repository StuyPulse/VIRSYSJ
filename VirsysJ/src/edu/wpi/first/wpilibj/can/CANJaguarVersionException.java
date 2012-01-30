package edu.wpi.first.wpilibj.can;

public class CANJaguarVersionException extends RuntimeException {

    public static final int kMinLegalFIRSTFirmwareVersion = 92;
    public static final int kMinRDKFirmwareVersion = 3330;

    public CANJaguarVersionException(int deviceNumber, int fwVersion) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    static String getString(int deviceNumber, int fwVersion) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
