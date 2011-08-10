package edu.wpi.first.wpilibj;

public class IterativeRobot extends RobotBase {

    private int waittime;
    private Timer time;

    public IterativeRobot() {
        waittime = 1;
        time = new Timer();
        System.out.print("Default Constructor... Overload me!");
    }

    public void autonomousContinuous() {
        while (isAutonomous()) {
        }
        System.out.print("Default autonomousContinuous()... Overload me!");
    }

    public void autonomousInit() {
        System.out.print("Default autonomousInit()... Overload me!");
    }

    public void autonomousPeriodic() {
        while (isAutonomous()) {
            time.delay(waittime);
        }
        System.out.print("Default autonomousPeriodic()... Overload me!");
    }

    public void disabledContinuous() {
        while (isDisabled()) {
        }
        System.out.print("Default diasbledContinuous()... Overload me!");
    }

    public void disabledInit() {
        System.out.print("Default diasbledInit()... Overload me!");
    }

    public void disabledPeriodic() {
        while (isDisabled()) {
            time.delay(waittime);
        }
    }

    public void startCompetition() {
        System.out.print("Default startCompetition()... Overload me!");
    }

    public void teleopContinuous() {
        while (isOperatorControl()) {
        }
        System.out.print("Default teleopContinuous()... Overload me!");
    }

    public void teleopInit() {
        System.out.print("Default teleopInit()... Overload me!");
    }

    public void teleopPeriodic() {
        while (isOperatorControl()) {
            time.delay(waittime);
        }
    }
}
