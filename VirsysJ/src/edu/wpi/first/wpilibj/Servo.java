/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj;

/**
 *
 * @author English
 */
public class Servo {

    int m_maxPwm;
    int m_deadbandMaxPwm;
    int m_centerPwm;
    int m_deadbandMinPwm;
    int m_minPwm;

    private static final double kMaxServoAngle = 170.0;
    private static final double kMinServoAngle = 0.0;

    /**
     * Constructor that assumes the default digital module.
     *
     * @param channel The PWM channel on the digital module to which the servo is attached.
     */
    public Servo(final int channel) {
        super(channel);
    }

    /**
     * Constructor that specifies the digital module.
     *
     * @param slot The slot in the chassis that the digital module is plugged into.
     * @param channel The PWM channel on the digital module to which the servo is attached.
     */
    public Servo(final int slot, final int channel) {
        super(slot, channel);
    }

    /**
     * Set the servo position.
     *
     * Servo values range from 0.0 to 1.0 corresponding to the range of full left to full right.
     *
     * @param value Position from 0.0 to 1.0.
     */
    public void set(double value) {
        setPosition(value);
    }

    /**
     * Get the servo position.
     *
     * Servo values range from 0.0 to 1.0 corresponding to the range of full left to full right.
     *
     * @return Position from 0.0 to 1.0.
     */
    public double get() {
        return getPosition();
    }

    /**
     * Set the servo angle.
     *
     * Assume that the servo angle is linear with respect to the PWM value (big assumption, need to test).
     *
     * Servo angles that are out of the supported range of the servo simply "saturate" in that direction
     * In other words, if the servo has a range of (X degrees to Y degrees) than angles of less than X
     * result in an angle of X being set and angles of more than Y degrees result in an angle of Y being set.
     *
     * @param degrees The angle in degrees to set the servo.
     */
    public void setAngle(double degrees) {
        if (degrees < kMinServoAngle) {
            degrees = kMinServoAngle;
        } else if (degrees > kMaxServoAngle) {
            degrees = kMaxServoAngle;
        }

        setPosition(((degrees - kMinServoAngle)) / getServoAngleRange());
    }

    /**
     * Get the servo angle.
     *
     * Assume that the servo angle is linear with respect to the PWM value (big assumption, need to test).
     * @return The angle in degrees to which the servo is set.
     */
    public double getAngle() {
        return getPosition() * getServoAngleRange() + kMinServoAngle;
    }

    private double getServoAngleRange() {
        return kMaxServoAngle - kMinServoAngle;
    }
}


    /*double position = 0;
    double angle = 0;

    public void set(double value) {
        position = value;
    }

    public double get() {
        return position;
    }

    public void setAngle(double degrees) {
        angle = degrees;
    }

    public double getAngle() {
        return angle;
    }*/

}
