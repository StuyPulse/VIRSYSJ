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

    double position = 0;
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
    }

}
