package edu.wpi.first.wpilibj;

import cRIOhardware.CRIO;

public class Jaguar implements Channels {

    double prevspeed;
    int channel;

    double[] motor_stall_torques = {
            346.9, // OZ*in
            346.9,
            700.0,
            100.0,
            100.0,
    };
    double[] motor_free_speeds = {
            5342 * 2 * Math.PI / 60.0, // rad / sec
            5342 * 2 * Math.PI / 60.0,
            700.0,
            100.0,
            100.0
    };

    Client c = CRIO.client;

    public Jaguar(int _channel) {
       channel = _channel;
    }

    public Jaguar(int slot, int channel) {
        this(channel);
    }

    public double get() {
        return prevspeed;
    }

    public void pidWrite(double output) {
        prevspeed = output;



	c.threadS.toSend[channel-1] = (float)(output * maxcurrenttorque());
    }

    public void set(double speed) {
        pidWrite(speed);
    }

    double maxcurrenttorque() {
        double slope = -1 * motor_stall_torques[channel - 1] / motor_free_speeds[channel - 1];
        double currentspeed = Math.abs(c.getdata()[channel + 5]); // +5 to convert the channel number to the correct index of the receive data array
        return motor_stall_torques[channel - 1] + currentspeed * slope;
    }
}