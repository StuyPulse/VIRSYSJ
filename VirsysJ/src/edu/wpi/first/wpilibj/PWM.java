/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj;

import crio.hardware.*;

/**
 *
 * @author 694
 */
public class PWM {

    double positionPwm;
    int rawPwm;
    int channelPwm;
    int moduleNumberPwm;
    int maxPwm;
    int deadbandMaxPwm;
    int centerPwm;
    int deadbandMinPwm;
    int minPwm;
    double speedPwm;

    public PWM(int moduleNumber, int channel) {
        channelPwm = channel;
        moduleNumberPwm = moduleNumber;
    }

    public PWM(int channel) {
        channelPwm = channel;
        //moduleNumber should set to default. What is the default?
    }

    public void enableDeadbandElimination(boolean eliminateDeadband) {
        //If eliminateDeadband is true, set the motor curve on the Jaguar to eliminate the deadband in the middle
        //of the range. Otherwise, keep the full range without modifying any values.
    }

    public void free() {
        channelPwm = 0;
    }

    public void setBounds(int max, int deadbandMax, int center, int deadbandMin, int min) {
        maxPwm = max;
        deadbandMaxPwm = deadbandMax;
        centerPwm = center;
        deadbandMinPwm = deadbandMin;
        minPwm = min;
    }

    public void setPosition(double position) {
        DigitalSidecar.register[channelPwm - 1] = position;
    }

    public int getChannel() {
        return this.channelPwm;
    }

    public int getModuleNumber() {
        return this.moduleNumberPwm;
    }

    public double getPosition() {
        return DigitalSidecar.register[channelPwm - 1];
    }
}
