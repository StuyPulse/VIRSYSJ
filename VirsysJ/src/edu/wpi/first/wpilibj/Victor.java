package edu.wpi.first.wpilibj;

import utilities.Channels;
import crio.hardware.CRIO;

public class Victor implements SpeedController {

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

    Client c;

    public Victor(int _channel) {
       channel = _channel;
       c = CRIO.client;
    }

    public Victor(int slot, int channel) {
        this(channel);
    }

    public double get() {
        return prevspeed;
    }

    public void pidWrite(double output) {
        prevspeed = output;
        System.out.println("c is " + c);
        System.out.println("c.threadS is " + c.threadS);
        System.out.println("c.threadS.toSend is " + c.threadS.toSend);
	c.threadS.toSend[channel-1] = (float)(output * maxcurrenttorque());
    }

    public void set(double speed) {
        pidWrite(speed);
    }

    public void set(double speed, byte syncgroup) {
        set(speed);
    }

    double maxcurrenttorque() {
        double slope = -1 * motor_stall_torques[channel - 1] / motor_free_speeds[channel - 1];
        System.out.println("c is " + c);
        System.out.println("c.getdata() is " + c.getdata());
        double currentspeed = Math.abs(c.getdata()[channel + 5]); // +5 to convert the channel number to the correct index of the receive data array
        return motor_stall_torques[channel - 1] + currentspeed * slope;
    }

    public void disable() {
        
    }
}
