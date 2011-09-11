package edu.wpi.first.wpilibj;

public class RobotBase {

    private Timer _gametimer;

    public RobotBase() {
        _gametimer = new Timer();
        _gametimer.start();
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
        return _gametimer.get() < 60;
    }

    public boolean isOperatorControl() {
        return _gametimer.get() > 60;
    }

    public boolean isNewDataAvailable() {
        return false;
    }

    public void startCompetition() {
    }
}
