package edu.wpi.first.wpilibj;

import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.can.*;

public class CANJaguar implements PIDOutput, SpeedController {

    public static class LimitMode {

        public final byte value;
        static final byte kSwitchInputsOnly_val = 0;
        static final byte kSoftPositionLimit_val = 1;
        public static final CANJaguar.LimitMode kSwitchInputsOnly;
        public static final CANJaguar.LimitMode kSoftPostionLimits;

        private LimitMode(byte value) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }

    public static class NeutralMode {

        public final byte value;
        static final byte kJumper_val = 0;
        static final byte kBrake_val = 1;
        static final byte kCoast_val = 2;
        public static final CANJaguar.NeutralMode kJumper;
        public static final CANJaguar.NeutralMode kBrake;
        public static final CANJaguar.NeutralMode kCoast;

        private NeutralMode(byte value) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }

    public static class SpeedReference {

        public final byte value;
        static final byte kEncoder_val = 0;
        static final byte kInvEncoder_val = 2;
        static final byte kQuadEncoder_val = 3;
        static final byte kNone_val = -1;
        public static final CANJaguar.SpeedReference kEncoder;
        public static final CANJaguar.SpeedReference kInvEncoder;
        public static final CANJaguar.SpeedReference kQuadEncoder;
        public static final CANJaguar.SpeedReference kNone;

        private SpeedReference(byte value) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }

    public static class PositionReference {

        public final byte value;
        static final byte kQuadEncoder_val = 0;
        static final byte kPotentiometer_val = 1;
        static final byte kNone_val = -1;
        public static final CANJaguar.PositionReference kQuadEncoder;
        public static final CANJaguar.PositionReference kPotentiometer;
        public static final CANJaguar.PositionReference kNone;

        private PositionReference(byte value) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }

    public static class Limits {

        public final int value;
        static final int kForwardLimit_val = 1;
        static final int kReverseLimit_val = 2;
        public static final CANJaguar.Limits kForwardLimit;
        public static final CANJaguar.Limits kReverseLimit;

        private Limits(int value) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }

    public static class Faults {

        public final int value;
        static final int kCurrentFault_val = 1;
        static final int kTemperatureFault_val = 2;
        static final int kBusVoltageFault_val = 4;
        static final int kGateDriverFault_val = 8;
        public static final CANJaguar.Faults kCurrentFault;
        public static final CANJaguar.Faults kTemperatureFault;
        public static final CANJaguar.Faults kBusVoltageFault;
        public static final CANJaguar.Faults kGateDriverFault;

        private Faults(int value) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }

    public static class ControlMode {

        public final int value;
        static final int kPercentVbus_val = 0;
        static final int kCurrent_val = 1;
        static final int kSpeed_val = 2;
        static final int kPosition_val = 3;
        static final int kVoltage_val = 4;
        public static final CANJaguar.ControlMode kPercentVbus;
        public static final CANJaguar.ControlMode kCurrent;
        public static final CANJaguar.ControlMode kSpeed;
        public static final CANJaguar.ControlMode kPosition;
        public static final CANJaguar.ControlMode kVoltage;

        private ControlMode(int value) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }
    public static final int kControllerRate = 1000;
    public static final double kApproxBusVoltage = 12.0;
    private final Object m_transactionMutex;
    private byte m_deviceNumber;
    private CANJaguar.ControlMode m_controlMode;
    private double m_maxOutputVoltage;
    private static final byte[] kNoData;
    private static final int kFullMessageIDMask = 536870848;
    private static final byte[] sendTrustedDataBuffer;

    private static final int swap16(int x) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private static final long swap32(long x) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private static final int swap16(int x, byte[] buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private static final long swap32(long x, byte[] buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private static final int swap16(byte[] buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private static final long swap32(byte[] buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private static final void pack16(short data, byte[] buffer, int offset) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private static final void pack32(int data, byte[] buffer, int offset) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private static final short unpack16(byte[] buffer, int offset) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private static final int unpack32(byte[] buffer, int offset) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private void initCANJaguar() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public CANJaguar(int deviceNumber) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public CANJaguar(int deviceNumber, CANJaguar.ControlMode controlMode) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void setX(double outputValue) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void set(double outputValue) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void setX(double outputValue, byte syncGroup) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void set(double outputValue, byte syncGroup) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getX() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double get() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void disable() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void pidWrite(double output) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    byte packPercentage(byte[] buffer, double value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    byte packFXP8_8(byte[] buffer, double value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    byte packFXP16_16(byte[] buffer, double value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    byte packINT16(byte[] buffer, short value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    byte packINT32(byte[] buffer, int value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    double unpackPercentage(byte[] buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    double unpackFXP8_8(byte[] buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    double unpackFXP16_16(byte[] buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    int unpackINT16(byte[] buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    long unpackINT32(byte[] buffer) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    protected static void sendMessage(int messageID, byte[] data, int dataSize) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    protected static byte receiveMessage(int messageID, byte[] data, double timeout) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    protected static byte receiveMessage(int messageID, byte[] data) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    protected byte setTransaction(int messageID, byte[] data, byte dataSize) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    protected byte getTransaction(int messageID, byte[] data) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void setSpeedReference(CANJaguar.SpeedReference reference) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public CANJaguar.SpeedReference getSpeedReference() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void setPositionReference(CANJaguar.PositionReference reference) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public CANJaguar.PositionReference getPositionReference() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void setPID(double p, double i, double d) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getP() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getI() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getD() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void enableControl() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void enableControl(double encoderInitialPosition) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void disableControl() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void changeControlMode(CANJaguar.ControlMode controlMode) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public CANJaguar.ControlMode getControlMode() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getBusVoltage() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getOutputVoltage() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getOutputCurrent() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getTemperature() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getPosition() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getSpeed() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public boolean getForwardLimitOK() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public boolean getReverseLimitOK() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public short getFaults() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public boolean getPowerCycled() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void setVoltageRampRate(double rampRate) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public int getFirmwareVersion() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public byte getHardwareVersion() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void configNeutralMode(CANJaguar.NeutralMode mode) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void configEncoderCodesPerRev(int codesPerRev) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void configPotentiometerTurns(int turns) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void configSoftPositionLimits(double forwardLimitPosition, double reverseLimitPosition) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void disableSoftPositionLimits() throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void configMaxOutputVoltage(double voltage) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void configFaultTime(double faultTime) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static void updateSyncGroup(byte syncGroup) throws CANTimeoutException {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void setExpiration(double timeout) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getExpiration() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public boolean isAlive() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public boolean isSafetyEnabled() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void setSafetyEnabled(boolean enabled) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public String getDescription() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void stopMotor() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
