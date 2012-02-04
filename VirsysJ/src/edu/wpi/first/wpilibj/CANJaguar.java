/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj;

import edu.wpi.first.wpilibj.can.*;

public class CANJaguar implements MotorSafety, PIDOutput, SpeedController {

    // The internal PID control loop in the Jaguar runs at 1kHz.
    public static final int kControllerRate = 1000;
    public static final double kApproxBusVoltage = 12.0;

    /**
     * Mode determines how the Jaguar is controlled
     */
    public static class ControlMode {

        public final int value;
        static final int kPercentVbus_val = 0;
        static final int kCurrent_val = 1;
        static final int kSpeed_val = 2;
        static final int kPosition_val = 3;
        static final int kVoltage_val = 4;
        public static final ControlMode kPercentVbus = new ControlMode(kPercentVbus_val);
        public static final ControlMode kCurrent = new ControlMode(kCurrent_val);
        public static final ControlMode kSpeed = new ControlMode(kSpeed_val);
        public static final ControlMode kPosition = new ControlMode(kPosition_val);
        public static final ControlMode kVoltage = new ControlMode(kVoltage_val);

        private ControlMode(int value) {
            this.value = value;
        }
    }

    /**
     * Faults reported by the Jaguar
     */
    public static class Faults {

        public final int value;
        static final int kCurrentFault_val = 1;
        static final int kTemperatureFault_val = 2;
        static final int kBusVoltageFault_val = 4;
        static final int kGateDriverFault_val = 8;
        public static final Faults kCurrentFault = new Faults(kCurrentFault_val);
        public static final Faults kTemperatureFault = new Faults(kTemperatureFault_val);
        public static final Faults kBusVoltageFault = new Faults(kBusVoltageFault_val);
        public static final Faults kGateDriverFault = new Faults(kGateDriverFault_val);

        private Faults(int value) {
            this.value = value;
        }
    }

    /**
     * Limit switch masks
     */
    public static class Limits {

        public final int value;
        static final int kForwardLimit_val = 1;
        static final int kReverseLimit_val = 2;
        public static final Limits kForwardLimit = new Limits(kForwardLimit_val);
        public static final Limits kReverseLimit = new Limits(kReverseLimit_val);

        private Limits(int value) {
            this.value = value;
        }
    }

    /**
     * Determines which sensor to use for position reference.
     */
    public static class PositionReference {

        public final byte value;
        static final byte kQuadEncoder_val = 0;
        static final byte kPotentiometer_val = 1;
        static final byte kNone_val = (byte)0xFF;
        public static final PositionReference kQuadEncoder = new PositionReference(kQuadEncoder_val);
        public static final PositionReference kPotentiometer = new PositionReference(kPotentiometer_val);
        public static final PositionReference kNone = new PositionReference(kNone_val);

        private PositionReference(byte value) {
            this.value = value;
        }
    }

    /**
     * Determines which sensor to use for speed reference.
     */
    public static class SpeedReference {

        public final byte value;
        static final byte kEncoder_val = 0;
        static final byte kInvEncoder_val = 2;
        static final byte kQuadEncoder_val = 3;
        static final byte kNone_val = (byte)0xFF;
        public static final SpeedReference kEncoder = new SpeedReference(kEncoder_val);
        public static final SpeedReference kInvEncoder = new SpeedReference(kInvEncoder_val);
        public static final SpeedReference kQuadEncoder = new SpeedReference(kQuadEncoder_val);
        public static final SpeedReference kNone = new SpeedReference(kNone_val);

        private SpeedReference(byte value) {
            this.value = value;
        }
    }

    /**
     * Determines how the Jaguar behaves when sending a zero signal.
     */
    public static class NeutralMode {

        public final byte value;
        static final byte kJumper_val = 0;
        static final byte kBrake_val = 1;
        static final byte kCoast_val = 2;
        public static final NeutralMode kJumper = new NeutralMode(kJumper_val);
        public static final NeutralMode kBrake = new NeutralMode(kBrake_val);
        public static final NeutralMode kCoast = new NeutralMode(kCoast_val);

        private NeutralMode(byte value) {
            this.value = value;
        }
    }

    public static class JaguarControlDisabledException extends RuntimeException {
        public JaguarControlDisabledException(String s) {
            super(s);
        }
    }

    /**
     * Determines which sensor to use for position reference.
     */
    public static class LimitMode {

        public final byte value;
        static final byte kSwitchInputsOnly_val = 0;
        static final byte kSoftPositionLimit_val = 1;
        public static final LimitMode kSwitchInputsOnly = new LimitMode(kSwitchInputsOnly_val);
        public static final LimitMode kSoftPostionLimits = new LimitMode(kSoftPositionLimit_val);

        private LimitMode(byte value) {
            this.value = value;
        }
    }

    private byte m_deviceNumber;
    private ControlMode m_controlMode;
    private double m_maxOutputVoltage;
    private double value;
    private MotorSafetyHelper m_safetyHelper;
    private static final byte[] kNoData = new byte[0];
    private SpeedReference speedReference;
    private PositionReference positionReference;
    private double kp, ki, kd;
    private boolean m_controlEnabled = false;
    public boolean mEncoderCodesSet = false;
    double forwardLimit, reverseLimit;
    boolean limitsEnabled = false;

    /**
     * Common initialization code called by all constructors.
     */
    private void initCANJaguar() throws CANTimeoutException {

        switch (m_controlMode.value) {
            case ControlMode.kPercentVbus_val:
            case ControlMode.kVoltage_val:
                enableControl();
                break;
            default:
                break;
        }
        m_safetyHelper = new MotorSafetyHelper(this);
    }

    /**
     * Constructor
     * Default to percent Vbus control mode.
     * @param deviceNumber The address of the Jaguar on the CAN bus.
     */
    public CANJaguar(int deviceNumber) throws CANTimeoutException {
        m_deviceNumber = (byte) deviceNumber;
        m_controlMode = ControlMode.kPercentVbus;
        m_maxOutputVoltage = kApproxBusVoltage;
        initCANJaguar();
    }

    /**
     * Constructor
     * @param deviceNumber The address of the Jaguar on the CAN bus.
     * @param controlMode The control mode that the Jaguar will run in.
     */
    public CANJaguar(int deviceNumber, ControlMode controlMode) throws CANTimeoutException {
        m_deviceNumber = (byte) deviceNumber;
        m_controlMode = controlMode;
        m_maxOutputVoltage = kApproxBusVoltage;
        initCANJaguar();
    }

    /**
     * Set the output set-point value.
     *
     * The scale and the units depend on the mode the Jaguar is in.
     * In PercentVbus Mode, the outputValue is from -1.0 to 1.0 (same as PWM Jaguar).
     * In Voltage Mode, the outputValue is in Volts.
     * In Current Mode, the outputValue is in Amps.
     * In Speed Mode, the outputValue is in Rotations/Minute.
     * In Position Mode, the outputValue is in Rotations.
     *
     * @param outputValue The set-point to sent to the motor controller.
     */
    public void setX(double outputValue) throws CANTimeoutException {
        setX(outputValue, (byte) 0);
    }

    /**
     * Set the output set-point value.
     *
     * Needed by the SpeedControl interface (swallows CANTimeoutExceptions).
     *
     * @deprecated Use setX instead.
     * @param outputValue The set-point to sent to the motor controller.
     */
    public void set(double outputValue) {
        set(outputValue, (byte) 0);
    }

    /**
     * Set the output set-point value.
     *
     * The scale and the units depend on the mode the Jaguar is in.
     * In PercentVbus Mode, the outputValue is from -1.0 to 1.0 (same as PWM Jaguar).
     * In Voltage Mode, the outputValue is in Volts.
     * In Current Mode, the outputValue is in Amps.
     * In Speed Mode, the outputValue is in Rotations/Minute.
     * In Position Mode, the outputValue is in Rotations.
     *
     * @param outputValue The set-point to sent to the motor controller.
     * @param syncGroup The update group to add this set() to, pending updateSyncGroup().  If 0, update immediately.
     */
    public void setX(double outputValue, byte syncGroup) throws CANTimeoutException, NullPointerException {
        if (!m_safetyHelper.isAlive()) {
            enableControl();
        }

        switch (m_controlMode.value) {
            case ControlMode.kPercentVbus_val:
                if (outputValue > 1.0) outputValue = 1.0;
                if (outputValue < -1.0) outputValue = -1.0;
                value = outputValue;
                break;
            case ControlMode.kSpeed_val: {
                if (speedReference == null) {
                    throw new NullPointerException("Must call setSpeedReference() before setting the speed.");
                }
                else if (!m_controlEnabled) {
                    throw new JaguarControlDisabledException("Must enable control before setting speed.");
                }
                else {
                    value = outputValue;
                }
            }
            break;
            case ControlMode.kPosition_val: {
                if (positionReference != null) {
                    if (outputValue > forwardLimit) {
                        value = forwardLimit;
                    }
                    else if (outputValue < reverseLimit) {
                        value = reverseLimit;
                    }
                    else {
                        value = outputValue;
                    }
                }
                else {
                    throw new NullPointerException("Must call setPositionReference() before setting the position.");
                }
            }
            break;
            case ControlMode.kCurrent_val: {
                value = outputValue;
            }
            break;
            case ControlMode.kVoltage_val: {
                value = outputValue;
            }
            break;
            default:
                return;
        }
        m_safetyHelper.feed();
    }

    /**
     * Set the output set-point value.
     *
     * Needed by the SpeedControl interface (swallows CANTimeoutExceptions).
     *
     * @deprecated Use setX instead.
     * @param outputValue The set-point to sent to the motor controller.
     * @param syncGroup The update group to add this set() to, pending updateSyncGroup().  If 0, update immediately.
     */
    public void set(double outputValue, byte syncGroup) {
        try {
            setX(outputValue, syncGroup);
        } catch (CANTimeoutException e) {}
    }

    /**
     * Get the recently set outputValue setpoint.
     *
     * The scale and the units depend on the mode the Jaguar is in.
     * In PercentVbus Mode, the outputValue is from -1.0 to 1.0 (same as PWM Jaguar).
     * In Voltage Mode, the outputValue is in Volts.
     * In Current Mode, the outputValue is in Amps.
     * In Speed Mode, the outputValue is in Rotations/Minute.
     * In Position Mode, the outputValue is in Rotations.
     *
     * @return The most recently set outputValue setpoint.
     */
    public double getX() throws CANTimeoutException, NullPointerException {
        byte[] dataBuffer = new byte[8];
        byte dataSize = 0;

        switch (m_controlMode.value) {
            case ControlMode.kPercentVbus_val:
                return value;
            case ControlMode.kSpeed_val:
                if (speedReference != null) {
                    return value;
                }
                else {
                    throw new NullPointerException("Must call setSpeedReference() before getting the speed.");
                }
            case ControlMode.kPosition_val:
                if (positionReference != null) {
                    return value;
                }
                else {
                    throw new NullPointerException("Must call setPositionReference() before getting the position.");
                }
            case ControlMode.kCurrent_val:
                return value;
            case ControlMode.kVoltage_val:
                return value;
        }
        return 0.0;

    }

    /**
     * Get the recently set outputValue setpoint.
     *
     * Needed by the SpeedControl interface (swallows CANTimeoutExceptions).
     *
     * @deprecated Use getX instead.
     * @return The most recently set outputValue setpoint.
     */
    public double get() {
        try {
            return getX();
        } catch (CANTimeoutException e) {
            return 0.0;
        }
    }

    /**
     * Common interface for disabling a motor.
     *
     * Needed by the SpeedControl interface (swallows CANTimeoutExceptions).
     *
     * @deprecated Use disableControl instead.
     */
    public void disable() {
        try {
            disableControl();
        } catch (CANTimeoutException e) {}
    }

    /**
     * Write out the PID value as seen in the PIDOutput base object.
     *
     * @deprecated Use setX instead.
     * @param output Write out the percentage voltage value as was computed by the PIDController
     */
    public void pidWrite(double output) {
        if (m_controlMode == ControlMode.kPercentVbus) {
            set(output);
        } else {
            // TODO: Error... only percent vbus mode supported for PID API
        }
    }

    /**
     * Set the reference source device for speed controller mode.
     *
     * Choose encoder as the source of speed feedback when in speed control mode.
     *
     * @param reference Specify a SpeedReference.
     */
    public void setSpeedReference(SpeedReference reference) throws CANTimeoutException {
        speedReference = reference;
    }

    /**
     * Get the reference source device for speed controller mode.
     *
     * @return A SpeedReference indicating the currently selected reference device for speed controller mode.
     */
    public SpeedReference getSpeedReference() throws CANTimeoutException {
        return speedReference;
    }

    /**
     * Set the reference source device for position controller mode.
     *
     * Choose between using and encoder and using a potentiometer
     * as the source of position feedback when in position control mode.
     *
     * @param reference Specify a PositionReference.
     */
    public void setPositionReference(PositionReference reference) throws CANTimeoutException {
        positionReference = reference;
    }

    /**
     * Get the reference source device for position controller mode.
     *
     * @return A PositionReference indicating the currently selected reference device for position controller mode.
     */
    public PositionReference getPositionReference() throws CANTimeoutException {
        return positionReference;
    }

    /**
     * Set the P, I, and D constants for the closed loop modes.
     *
     * @param p The proportional gain of the Jaguar's PID controller.
     * @param i The integral gain of the Jaguar's PID controller.
     * @param d The differential gain of the Jaguar's PID controller.
     */
    public void setPID(double p, double i, double d) throws CANTimeoutException {
        kp = p;
        ki = i;
        kd = d;
    }

    /**
     * Get the Proportional gain of the controller.
     *
     * @return The proportional gain.
     */
    public double getP() throws CANTimeoutException {
        return kp;
    }

    /**
     * Get the Intregral gain of the controller.
     *
     * @return The integral gain.
     */
    public double getI() throws CANTimeoutException {
        return ki;
    }

    /**
     * Get the Differential gain of the controller.
     *
     * @return The differential gain.
     */
    public double getD() throws CANTimeoutException {
        return kd;
    }

    /**
     * Enable the closed loop controller.
     *
     * Start actually controlling the output based on the feedback.
     */
    public void enableControl() throws CANTimeoutException {
        enableControl(0.0);
    }

    /**
     * Enable the closed loop controller.
     *
     * Start actually controlling the output based on the feedback.
     * If starting a position controller with an encoder reference,
     * use the encoderInitialPosition parameter to initialize the
     * encoder state.
     * @param encoderInitialPosition Encoder position to set if position with encoder reference.  Ignored otherwise.
     */
    public void enableControl(double encoderInitialPosition) throws CANTimeoutException {
        m_controlEnabled = true;
    }

    /**
     * Disable the closed loop controller.
     *
     * Stop driving the output based on the feedback.
     */
    public void disableControl() throws CANTimeoutException {
        m_controlEnabled = false;
    }

    /**
     * Change the control mode of this Jaguar object.
     *
     * After changing modes, configure any PID constants or other settings needed
     * and then enableControl() to actually change the mode on the Jaguar.
     *
     * @param controlMode The new mode.
     */
    public void changeControlMode(ControlMode controlMode) throws CANTimeoutException {
        // Disable the previous mode
        disableControl();

        // Update the local mode
        m_controlMode = controlMode;
    }

    /**
     * Get the active control mode from the Jaguar.
     *
     * Ask the Jag what mode it is in.
     *
     * @return ControlMode that the Jag is in.
     */
    public ControlMode getControlMode() throws CANTimeoutException {
        return m_controlMode;
    }

    /**
     * Get the position of the encoder or potentiometer.
     *
     * @return The position of the motor based on the configured feedback.
     */
    public double getPosition() throws CANTimeoutException {
        if (m_controlMode.value != ControlMode.kPosition_val) {
            throw new JaguarControlDisabledException("Control mode not set to position");
        }
        if (positionReference == null) {
            throw new NullPointerException("Must call setPositionReference() before getting the position.");
        }
        return value;
    }

    /**
     * Get the speed of the encoder.
     *
     * @return The speed of the motor in RPM based on the configured feedback.
     */
    public double getSpeed() throws CANTimeoutException {
        if (m_controlMode.value != ControlMode.kSpeed_val) {
            throw new JaguarControlDisabledException("Control mode not set to speed");
        }
        if (speedReference == null) {
            throw new NullPointerException("Must call setSpeedReference() before getting the speed.");
        }
        return value;
    }

    /**
     * Get the status of the forward limit switch.
     *
     * @return The motor is allowed to turn in the forward direction when true.
     *
    public boolean getForwardLimitOK() throws CANTimeoutException {
        byte[] dataBuffer = new byte[8];
        byte dataSize;

        dataSize = getTransaction(JaguarCANProtocol.LM_API_STATUS_LIMIT, dataBuffer);
        if (dataSize == 1) {
            return (dataBuffer[0] & Limits.kForwardLimit_val) != 0;
        }
        return false;
    }*/

    /**
     * Get the status of the reverse limit switch.
     *
     * @return The motor is allowed to turn in the reverse direction when true.
     *
    public boolean getReverseLimitOK() throws CANTimeoutException {
        byte[] dataBuffer = new byte[8];
        byte dataSize;

        dataSize = getTransaction(JaguarCANProtocol.LM_API_STATUS_LIMIT, dataBuffer);
        if (dataSize == 1) {
            return (dataBuffer[0] & Limits.kReverseLimit_val) != 0;
        }
        return false;
    }*/

    /**
     * Get the status of any faults the Jaguar has detected.
     *
     * @return A bit-mask of faults defined by the "Faults" enum class.
     *
    public short getFaults() throws CANTimeoutException {
        byte[] dataBuffer = new byte[8];
        byte dataSize;

        dataSize = getTransaction(JaguarCANProtocol.LM_API_STATUS_FAULT, dataBuffer);
        if (dataSize == 2) {
            return (short)unpackINT16(dataBuffer);
        }
        return 0;
    }*/

    /**
     * Check if the Jaguar's power has been cycled since this was last called.
     *
     * This should return true the first time called after a Jaguar power up,
     * and false after that.
     *
     * @return The Jaguar was power cycled since the last call to this function.
     *
    public boolean getPowerCycled() throws CANTimeoutException {
        byte[] dataBuffer = new byte[8];
        byte dataSize;

        dataSize = getTransaction(JaguarCANProtocol.LM_API_STATUS_POWER, dataBuffer);
        if (dataSize == 1) {
            boolean powerCycled = dataBuffer[0] != 0;

            // Clear the power cycled bit now that we've accessed it
            if (powerCycled) {
                dataBuffer[0] = 1;
                setTransaction(JaguarCANProtocol.LM_API_STATUS_POWER, dataBuffer, (byte) 1);
            }

            return powerCycled;
        }
        return false;
    }*/

    /**
     * Set the maximum voltage change rate.
     *
     * When in percent voltage output mode, the rate at which the voltage changes can
     * be limited to reduce current spikes.  Set this to 0.0 to disable rate limiting.
     *
     * @param rampRate The maximum rate of voltage change in Percent Voltage mode in V/s.
     */
    public void setVoltageRampRate(double rampRate) throws CANTimeoutException {
        if (m_controlMode.value != ControlMode.kPercentVbus_val &&
                m_controlMode.value != ControlMode.kVoltage_val) {
            throw new JaguarControlDisabledException("Must be in Voltage mode (Percent Vbus or Voltage val)");
        }
    }

    /**
     * Get the version of the firmware running on the Jaguar.
     *
     * @return The firmware version.  0 if the device did not respond.
     *
    public int getFirmwareVersion() throws CANTimeoutException {
        byte[] dataBuffer = new byte[8];
        byte dataSize;

        // Set the MSB to tell the 2CAN that this is a remote message.
        dataSize = getTransaction(0x80000000 | JaguarCANProtocol.CAN_MSGID_API_FIRMVER, dataBuffer);
        if (dataSize == 4) {
            return (int)unpackINT32(dataBuffer);
        }
        return 0;
    }*/

    /**
     * Get the version of the Jaguar hardware.
     *
     * @return The hardware version. 1: Jaguar,  2: Black Jaguar
     *
    public byte getHardwareVersion() throws CANTimeoutException {
        byte[] dataBuffer = new byte[8];
        byte dataSize;

        dataSize = getTransaction(JaguarCANProtocol.LM_API_HWVER, dataBuffer);
        if (dataSize == 1 + 1) {
            if (dataBuffer[0] == m_deviceNumber) {
                return dataBuffer[1];
            }
        }
        // Assume Gray Jag if there is no response
        return JaguarCANProtocol.LM_HWVER_JAG_1_0;
    }

    /**
     * Configure what the controller does to the H-Bridge when neutral (not driving the output).
     *
     * This allows you to override the jumper configuration for brake or coast.
     *
     * @param mode Select to use the jumper setting or to override it to coast or brake.
     */
    public void configNeutralMode(NeutralMode mode) throws CANTimeoutException {
        /*byte[] dataBuffer = new byte[8];

        dataBuffer[0] = mode.value;
        setTransaction(JaguarCANProtocol.LM_API_CFG_BRAKE_COAST, dataBuffer, (byte) 1);*/
    }

    /**
     * Configure how many codes per revolution are generated by your encoder.
     *
     * @param codesPerRev The number of counts per revolution in 1X mode.
     */
    public void configEncoderCodesPerRev(int codesPerRev) throws CANTimeoutException {
        if (m_controlMode != ControlMode.kPosition && m_controlMode != ControlMode.kSpeed) {
            throw new JaguarControlDisabledException("Setting encoder codes per rev when not in Position or Speed mode.");
        }
        else if (mEncoderCodesSet) {
            throw new RuntimeException("Don't use the pot and encoders on the same Jaguar.");
        }
        mEncoderCodesSet = true;
    }

    /**
     * Configure the number of turns on the potentiometer.
     *
     * There is no special support for continuous turn potentiometers.
     * Only integer numbers of turns are supported.
     *
     * @param turns The number of turns of the potentiometer
     */
    public void configPotentiometerTurns(int turns) throws CANTimeoutException {
        if (!mEncoderCodesSet) {
            configEncoderCodesPerRev(turns);  // doesn't actually use the value, just checks that setting it here is appropriate
        }
        else {
            throw new RuntimeException("Don't use the pot and encoders on the same Jaguar.");
        }
    }

    /**
     * Configure Soft Position Limits when in Position Controller mode.
     *
     * When controlling position, you can add additional limits on top of the limit switch inputs
     * that are based on the position feedback.  If the position limit is reached or the
     * switch is opened, that direction will be disabled.
     *
     * @param forwardLimitPosition The position that if exceeded will disable the forward direction.
     * @param reverseLimitPosition The position that if exceeded will disable the reverse direction.
     */
    public void configSoftPositionLimits(double forwardLimitPosition, double reverseLimitPosition) throws CANTimeoutException {
        limitsEnabled = true;
        forwardLimit = forwardLimitPosition;
        reverseLimit = reverseLimitPosition;
    }

    /**
     * Disable Soft Position Limits if previously enabled.
     *
     * Soft Position Limits are disabled by default.
     */
    public void disableSoftPositionLimits() throws CANTimeoutException {
        limitsEnabled = false;
    }

    /**
     * Configure the maximum voltage that the Jaguar will ever output.
     *
     * This can be used to limit the maximum output voltage in all modes so that
     * motors which cannot withstand full bus voltage can be used safely.
     *
     * @param voltage The maximum voltage output by the Jaguar.
     */
    public void configMaxOutputVoltage(double voltage) throws CANTimeoutException {
    }

    /**
     * Configure how long the Jaguar waits in the case of a fault before resuming operation.
     *
     * Faults include over temerature, over current, and bus under voltage.
     * The default is 3.0 seconds, but can be reduced to as low as 0.5 seconds.
     *
     * @param faultTime The time to wait before resuming operation, in seconds.
     */
    public void configFaultTime(double faultTime) throws CANTimeoutException {
    }

    /**
     * Update all the motors that have pending sets in the syncGroup.
     *
     * @param syncGroup A bitmask of groups to generate synchronous output.
     */
    public static void updateSyncGroup(byte syncGroup) throws CANTimeoutException {
    }


    public void setExpiration(double timeout) {
        m_safetyHelper.setExpiration(timeout);
    }

    public double getExpiration() {
        return m_safetyHelper.getExpiration();
    }

    public boolean isAlive() {
        return m_safetyHelper.isAlive();
    }

    public boolean isSafetyEnabled() {
        return m_safetyHelper.isSafetyEnabled();
    }

    public void setSafetyEnabled(boolean enabled) {
        m_safetyHelper.setSafetyEnabled(enabled);
    }

    public String getDescription() {
        return "CANJaguar ID "+m_deviceNumber;
    }

    /**
     * Common interface for stopping a motor.
     *
     * @deprecated Use disableControl instead.
     */
    public void stopMotor() {
        try {
            disableControl();
        } catch (CANTimeoutException e) {}
    }

}
