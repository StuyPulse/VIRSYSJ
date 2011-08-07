package edu.wpi.first.wpilibj;

public class RobotBase {

    public RobotBase() {
    }

    public boolean isSystemActive() {
        return true;
    }

    public Watchdog getWatchdog() {
        return new Watchdog();
    }

    public boolean isEnabled() {
        return true;
    }

    public boolean isDisabled() {
        return false;
    }

    public boolean isAutonomous() {
        return false;
    }

    public boolean isOperatorControl() {
        return true;
    }

    public boolean isNewDataAvailable() {
        return false;
    }

    public void startCompetition() {
    }
}
