package edu.wpi.first.wpilibj.can;

import edu.wpi.first.wpilibj.util.UncleanStatusException;

public class CANExceptionFactory {

    static final int ERR_JaguarCANDriver_InvalidBuffer = -44086;
    static final int ERR_JaguarCANDriver_TimedOut = -44087;
    static final int ERR_JaguarCANDriver_NotAllowed = -44088;
    static final int ERR_JaguarCANDriver_NotInitialized = -44089;

    public CANExceptionFactory() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static void checkStatus(int status, int messageID) throws CANInvalidBufferException, CANTimeoutException, CANMessageNotAllowedException, CANNotInitializedException, UncleanStatusException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
