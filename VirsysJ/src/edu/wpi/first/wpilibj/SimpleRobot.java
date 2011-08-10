package edu.wpi.first.wpilibj;

public class SimpleRobot extends RobotBase {

    public SimpleRobot() {
        System.out.print("Default Constructor... Overload me!");
    }

    public void disabled() {
        System.out.print("Default Disabled method... Overload me!");
    }

    public void autonomous() {
        System.out.print("Default Autonomous method... Overload me!");
    }

    public void operatorControl() {
        System.out.print("Default OperatorControl method... Overload me!");
    }

    public void startCompetition() {
        System.out.print("Default StartCompetition method... Overload me!");
    }
}
