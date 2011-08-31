package edu;

import edu.wpi.first.wpilibj.*;

public class Test {

    Client c;
    Victor rv,lv;
    Encoder re,le;
    final int wheelradius = 3;

    public Test() {
        System.out.println("starting");
        c = new Client();
        System.out.println("finised consntructing Client");
        rv = new Victor(1,c);
        lv = new Victor(2,c);
        rv.pidWrite(1);
        lv.pidWrite(1);
        System.out.println("done making victors");
        re = new Encoder(1,1,true,CounterBase.EncodingType.k2X,c);
        le = new Encoder(5,6,true,CounterBase.EncodingType.k2X,c);
        System.out.println("done making Encoders");
        re.start();
        le.start();
        System.out.println("distances (right, left): " + re.getDistance() + " " + le.getDistance());

    }

    public static void main(String[] arg) {
        Test bah = new Test();
    }
}
