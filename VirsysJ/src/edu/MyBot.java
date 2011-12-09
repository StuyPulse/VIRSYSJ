package edu;

import edu.wpi.first.wpilibj.*;

public class MyBot extends SimpleRobot{

    Victor rv,lv;
    Encoder re,le;
    final int wheelradius = 3;
    Gyro g;

    public MyBot() {
        System.out.println("starting");
        System.out.println("finised consntructing Client");
        rv = new Victor(1);
        lv = new Victor(2);
        System.out.println("done making victors");
        re = new Encoder(1,1,true,CounterBase.EncodingType.k2X);
        le = new Encoder(5,6,true,CounterBase.EncodingType.k2X);
        System.out.println("done making Encoders");
        g = new Gyro(1);
        System.out.println("done making Gyros");
        
        re.start();
        le.start();
        System.out.println("distances (right, left): " + re.getDistance() + " " + le.getDistance());
        System.out.println("angle = " + g.getAngle());
    }

    public void operatorControl() {

        rv.pidWrite(-1);
        lv.pidWrite(1);
        while (isOperatorControl() && isEnabled()) {
            System.out.println("angle = " + g.getAngle());
            Timer.delay(0.1);
        }
    }
}