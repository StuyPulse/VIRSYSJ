package edu.wpi.first.wpilibj;

import utilities.Channels;
import crio.hardware.CRIO;

/**
 *
 * @author Q
 */
public class Gyro {

    private Runnable gyroThread;
    private Thread threadg;
    private int encodernumber;
    final int wheelradius = 3;
    final int width = 20;
    private double dist;
    Client _c = CRIO.client;
    Timer time;
    double prev;

    public Gyro(int slot, int channel) {
        this(channel);
        prev = time.getFPGATimestamp();
    }

    public Gyro(int channel) {
        gyroThread = new GyroThread();
        threadg = new Thread(gyroThread);
        threadg.start();
        if (channel == CRIO.channel.getChannelFrontLeftEncA() || channel == CRIO.channel.getChannelFrontLeftEncB()) {
            encodernumber = 1;
        } else if (channel == CRIO.channel.getChannelRearLeftEncA() || channel == CRIO.channel.getChannelRearLeftEncB()) {
            encodernumber = 2;
        } else if (channel == CRIO.channel.getChannelFrontRightEncA() || channel == CRIO.channel.getChannelFrontRightEncB()) {
            encodernumber = 3;
        } else if (channel == CRIO.channel.getChannelRearRightEncA() || channel == CRIO.channel.getChannelRearRightEncB()) {
            encodernumber = 4;
        } else {
            encodernumber = 0;
        }
    }

    public void reset() {
        dist = 0;
    }

    public double getAngle() {
        return this.pidGet();
    }

    public double pidGet() {
        //return dist;
        return _c.getdata()[0];
    }

    private class GyroThread implements Runnable {

        public boolean done;

        public void run() {
            while (!done) {
                try {
                    double change = time.getFPGATimestamp() - prev;
                    prev = time.getFPGATimestamp();
                    dist += (_c.getdata()[7] - _c.getdata()[6]) * wheelradius / width * change;
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
    }
}
