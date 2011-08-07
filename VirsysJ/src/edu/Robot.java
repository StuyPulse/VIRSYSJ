/* basic robot class courtesy of Kevin Wang's newbie final project*/
/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu;
import edu.wpi.first.wpilibj.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Michael1 extends SimpleRobot {
    Joystick lstick;
    Joystick rstick;
    RobotDrive dt;
    Victor intake;
    Victor shooter;
    Servo paddle_thingy;
    public Michael1(){
       lstick = new Joystick(1);
       rstick = new Joystick(2);
       dt = new RobotDrive(1,2);
       shooter = new Victor(3);
       intake = new Victor(4);
       paddle_thingy = new Servo(9);

       // Invert motors or the robot will drive backwards.
       dt.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
       dt.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    }
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        getWatchdog().setEnabled(false);

        intake.set(1.0); // Turn on intake motor.
        dt.drive(-0.5,0); // Drive forward at half speed
        Timer.delay(2.0); // for two seconds,
        dt.drive(0,0); // then stop driving.
        Timer.delay(3.0); // After another three seconds,
        intake.set(0.0); // stop the intake motor.
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        getWatchdog().setEnabled(false); // Anything outside the while loop is run only once.
        while(isOperatorControl()&&isEnabled()){ // Loop everything else while teleop enabled.
            // Plain old tank drive.
            dt.tankDrive(lstick,rstick);

            // Intake control
            if(rstick.getRawButton(3)){
                intake.set(1.0);
            }
            else{ // Without the else statement, the motor will never stop after being started.
                intake.set(0.0);
            }

            // Shooter control
            if(rstick.getTrigger()){
                shooter.set(-0.75); // Negative because otherwise the shooter would run in reverse.
            }
            else{
                shooter.set(0.0);
            }

            // Paddle thingy control
            if(lstick.getTrigger()){
                paddle_thingy.set(0.0); // Paddle forward.
            }
            else{
                paddle_thingy.set(1.0); // Paddle backward.
            }
        }
    }
}