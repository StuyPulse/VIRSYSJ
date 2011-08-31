package edu.wpi.first.wpilibj;

public class Encoder extends Thread implements Channels {

    private Client _c;
    private boolean reverse;
    private int encodernumber;
    private double distance, lasttime, lastsenval;
    final int wheelradius = 3;
    boolean done = false;

    public Encoder(final int aChannel, final int bChannel, boolean reverseDirection, final CounterBase.EncodingType encodingType, Client c) {
        _c = c;
        reverse = reverseDirection;
        if (encodingType == null) {
            throw new NullPointerException("Given encoding type was null");
        }
        switch (aChannel) {
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

    //returns rate in inches/sec...0 if it can't connect to Virsys program
    public double getRate() {
        try {
            return encodernumber <= 2 ? _c.getdata()[2] * wheelradius : _c.getdata()[3] * wheelradius;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0.0;
    }

    //returns distance in inches
    public double getDistance() {
        return distance * wheelradius;
    }

    public void reset() {
        distance = 0;
    }

    public void start() {
        reset();
        //run();
        super.start();
    }

    public void run() {
        while (!done) {
            double current = getRate();
            double time = Timer.getFPGATimestamp();
            distance += (current + lastsenval) * (time - lasttime) / 2;
            lasttime = time;
            lastsenval = current;
            Thread.yield();
        }
    }
}
