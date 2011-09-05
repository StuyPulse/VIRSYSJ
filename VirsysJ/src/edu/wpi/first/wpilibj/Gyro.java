package edu.wpi.first.wpilibj;

/**
 *
 * @author Q
 */
public class Gyro extends Thread implements Channels {

    private int encodernumber;
    final int wheelradius = 3;
    final int width = 20;
    private double dist;
    public boolean done;
    Client _c = CRIO.client;

    public Gyro(int slot, int channel) {
        this(channel);
    }

    public Gyro(int channel) {
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
        this.start();
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

    public void start() {
        while (!done) {
            this.run();
        }
    }

    public void run() {
        try {
            dist += (_c.getdata()[7] - _c.getdata()[6]) * wheelradius / width;
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
