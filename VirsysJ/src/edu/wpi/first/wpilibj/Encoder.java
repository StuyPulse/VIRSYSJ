package edu.wpi.first.wpilibj;

import utilities.Channels;
import crio.hardware.CRIO;

public class Encoder {

    private boolean reverse = false;
    private int virsysPacketIndex;
    private double lastdis = 0;
    final int wheelradius = 3;
    boolean done = false;
    boolean distancePerPulseSet = false;
    int aChannel, bChannel;

    /**
     * Keep track of whether the start() method was called, which is required
     * for getting data.
     *
     * Throw an exception if someone tries to read before calling start()
     */
    boolean started = false;

    Client _c = CRIO.client;

    public Encoder(int aChannel, int bChannel) {
        if (CRIO.runWithPhysics) {
            virsysPacketIndex = CRIO.virsysInputMap[aChannel];
        }
        this.aChannel = aChannel;
        this.bChannel = bChannel;
    }
    
    public Encoder(final int aChannel, final int bChannel, boolean reverseDirection, final CounterBase.EncodingType encodingType) {
        this(aChannel, bChannel);
        reverse = reverseDirection;
        if (encodingType == null) {
            throw new NullPointerException("Given encoding type was null");
        }
    }

    public Encoder(final int aChannel, final int bChannel, boolean reverseDirection) {
        this(aChannel, bChannel);
        reverse = reverseDirection;
    }

    public class NotInitializedException extends Exception {
        public NotInitializedException(int a, int b) {
            super("Encoder on " + a + ", " + b + " not started");
        }
    }

    //returns rate in inches/sec...0 if it can't connect to Virsys program
    public double getRate() throws NotInitializedException {
        if (!started) {
            throw new NotInitializedException(aChannel, bChannel);
        }
        try {
            return _c.getdata()[virsysPacketIndex + 4] * wheelradius;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0.0;
    }

    //returns distance in inches
    public double getDistance() throws NotInitializedException {
        if (!started) {
            throw new NotInitializedException(aChannel, bChannel);
        }
        try {
            return _c.getdata()[virsysPacketIndex] * wheelradius - lastdis;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0.0;
    }

    public void reset() {
        try {
            lastdis = getDistance();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void start() {
        reset();
        started = true;
    }

    public void setDistancePerPulse(double distancePerPulse) {
        distancePerPulseSet = true;
    }
}
