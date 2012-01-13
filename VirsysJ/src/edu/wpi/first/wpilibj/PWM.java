/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj;

/**
 *
 * @author 694
 */
public class PWM {
    double position;
    int raw;

    public PWM(final int channel) {
    }

    public PWM(final int slot, final int channel) {
    }

    public void setPosition(double newPosition) {
        position = newPosition;
    }

    public double getPosition() {
        return position;
    }

    public void setRawTest(int newRaw) {
        raw = newRaw;

    }

    public int getRawTest() {
        return raw;
    }
}
