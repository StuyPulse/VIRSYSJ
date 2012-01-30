package edu.wpi.first.wpilibj;

import utilities.Channels;
import crio.hardware.CRIO;

public class Encoder {

    private boolean reverse = false;
    private int virsysPacketIndex;
    private double lastdis = 0;
    final int wheelradius = 3;
    boolean done = false;

    Client _c = CRIO.client;

    public Encoder(int aChannel, int bChannel) {
        if (CRIO.runWithPhysics) {
            virsysPacketIndex = CRIO.virsysInputMap[aChannel];
        }
    }
    
    public Encoder(final int aChannel, final int bChannel, boolean reverseDirection, final CounterBase.EncodingType encodingType) {
        this(aChannel, bChannel);
        reverse = reverseDirection;
        if (encodingType == null) {
            throw new NullPointerException("Given encoding type was null");
        }
    }

    //returns rate in inches/sec...0 if it can't connect to Virsys program
    public double getRate() {
        try {
            return _c.getdata()[virsysPacketIndex + 4] * wheelradius;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0.0;
    }

    //returns distance in inches
    public double getDistance() {
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
    }
}
