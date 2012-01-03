package edu;

import edu.wpi.first.wpilibj.*;

public class MyBot extends SimpleRobot{

    Victor rv,lv, arm;
    Encoder re,le;
    final int wheelradius = 3;
    Gyro g;

    public MyBot() {
        System.out.println("starting");
        System.out.println("finised consntructing Client");
        rv = new Victor(1);
        lv = new Victor(2);
	arm = new Victor(3);
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

    public void autonomous() {
        rv.set(-0.5);
        lv.set(0.5);
	arm.set(1);
        System.out.println("in auton");
        while (isEnabled() && isAutonomous()) {
            //System.out.println("angle = " + g.getAngle());
            Timer.delay(0.1);
            //System.out.println("time: " + System.currentTimeMillis());
        }
    }

    public void operatorControl() {
	System.out.println("lower the arm");
	rv.set(0.5);
	lv.set(-0.5);
	arm.set(-1);
    }
}
