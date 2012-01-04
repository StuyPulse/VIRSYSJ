package edu;

import edu.wpi.first.wpilibj.*;

public class MyBot extends SimpleRobot implements Channels {

    Victor rv,lv, arm;
    Encoder re,le;
    final int wheelradius = 3;
    Gyro g;

    public MyBot() {
        System.out.println("starting");
        System.out.println("finised consntructing Client");
        lv = new Victor(LEFT_PWM);
        rv = new Victor(RIGHT_PWM);
	arm = new Victor(ARM_PWM);
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
        rv.set(-1);
        lv.set(1);
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
