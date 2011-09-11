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
        System.out.println(_gametimer.get());
        return _gametimer.get() < 15;
    }

    public boolean isOperatorControl() {
        return _gametimer.get() > 15;
    }

    public boolean isNewDataAvailable() {
        return false;
    }

    public void startCompetition() {
    }
}
