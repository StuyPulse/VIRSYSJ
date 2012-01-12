package edu;

import edu.wpi.first.wpilibj.*;

public class MyBot extends SimpleRobot implements Channels {

    Victor rv,lv, arm;
    Encoder re,le;
    final int wheelradius = 3;
    RobotDrive rd;
    Gyro g;

    public MyBot() {
        System.out.println("starting");
        System.out.println("finised consntructing Client");
        lv = new Victor(LEFT_PWM);
        rv = new Victor(RIGHT_PWM);
        rd = new RobotDrive(lv, rv);
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
	arm.set(1);
        System.out.println(g.pidGet());
        // p = new PIDController(1, 0, 0, , arm);
    }

    public void operatorControl() {
	System.out.println("lower the arm");
	rv.set(0.5);
	lv.set(-0.5);
	arm.set(-1);
    }
}
