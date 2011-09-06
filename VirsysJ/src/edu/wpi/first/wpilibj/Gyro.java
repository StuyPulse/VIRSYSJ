package edu.wpi.first.wpilibj;

/**
 *
 * @author Q
 */
public class Gyro implements Channels {

    private Runnable gyroThread;
    private Thread threadg;
    private int encodernumber;
    final int wheelradius = 3;
    final int width = 20;
    private double dist;
    Client _c = CRIO.client;

    public Gyro(int slot, int channel) {
        this(channel);
    }

    public Gyro(int channel) {
        gyroThread = new GyroThread();
        threadg = new Thread(gyroThread);
        threadg.start();
        switch (channel) {
            case (CHANNEL_FRONT_LEFT_ENC_A):
            case (CHANNEL_FRONT_LEFT_ENC_B):
                encodernumber = 1;
                break;
            case (CHANNEL_REAR_LEFT_ENC_A):
            case (CHANNEL_REAR_LEFT_ENC_B):
                encodernumber = 2;
                break;
            case (CHANNEL_FRONT_RIGHT_ENC_A):
            case (CHANNEL_FRONT_RIGHT_ENC_B):
                encodernumber = 3;
                break;
            case (CHANNEL_REAR_RIGHT_ENC_A):
            case (CHANNEL_REAR_RIGHT_ENC_B):
                encodernumber = 4;
                break;
            default:
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
        return dist;
    }

    private class GyroThread implements Runnable {

        public boolean done;

        public void run() {
            while (!done) {
                try {
                    dist += (_c.getdata()[7] - _c.getdata()[6]) * wheelradius / width;
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
    }
}
