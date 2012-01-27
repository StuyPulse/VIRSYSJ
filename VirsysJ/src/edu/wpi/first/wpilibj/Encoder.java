package edu.wpi.first.wpilibj;

import utilities.Channels;
import crio.hardware.CRIO;

public class Encoder {

    private boolean reverse;
    private int encodernumber;
    private double lastdis = 0;
    final int wheelradius = 3;
    boolean done = false;

    Client _c = CRIO.client;

    public Encoder(final int aChannel, final int bChannel, boolean reverseDirection, final CounterBase.EncodingType encodingType) {
        reverse = reverseDirection;
        if (encodingType == null) {
            throw new NullPointerException("Given encoding type was null");
        }
        /*
        if (aChannel == CRIO.channel.getChannelFrontLeftEncA() || aChannel == CRIO.channel.getChannelFrontLeftEncB()) {
            encodernumber = 1;
        } else if (aChannel == CRIO.channel.getChannelRearLeftEncA() || aChannel == CRIO.channel.getChannelRearLeftEncB()) {
            encodernumber = 2;
        } else if (aChannel == CRIO.channel.getChannelFrontRightEncA() || aChannel == CRIO.channel.getChannelFrontRightEncB()) {
            encodernumber = 3;
        } else if (aChannel == CRIO.channel.getChannelRearRightEncA() || aChannel == CRIO.channel.getChannelRearRightEncB()) {
            encodernumber = 4;
        } else {
            encodernumber = 0;
        }
         *
         */
    }

    //returns rate in inches/sec...0 if it can't connect to Virsys program
    public double getRate() {
        try {
            return encodernumber <= 2 ? _c.getdata()[6] * wheelradius : _c.getdata()[7] * wheelradius;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0.0;
    }

    //returns distance in inches
    public double getDistance() {
         try {
            return (encodernumber <= 2 ? _c.getdata()[2] * wheelradius : _c.getdata()[3] * wheelradius) - lastdis;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0.0;
    }

    public void reset() {
        try {
            lastdis = encodernumber <= 2 ? _c.getdata()[2] * wheelradius : _c.getdata()[3] * wheelradius;
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void start() {
        reset();
    }
}
