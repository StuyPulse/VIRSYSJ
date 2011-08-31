package edu;

import edu.wpi.first.wpilibj.*;

public class Test {

    Client c;
    Victor rv,lv;
    Encoder re,le;
    final int wheelradius = 3;

    public Test() {
        c = new Client();
        c.startRecieveing();
        rv = new Victor(1,c);
        lv = new Victor(2,c);
        rv.pidWrite(1);
        lv.pidWrite(1);
        re = new Encoder(1,1,true,CounterBase.EncodingType.k2X,c);
        le = new Encoder(5,6,true,CounterBase.EncodingType.k2X,c);
        re.start();
        le.start();
        System.out.println(re.getDistance() + " " + le.getDistance());

    }

    public static void main(String[] arg) {
        Test bah = new Test();
    }
}
