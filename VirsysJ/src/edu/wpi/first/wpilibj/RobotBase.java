package edu.wpi.first.wpilibj;

public abstract class RobotBase {

    private Timer _gametimer;
    private final Watchdog m_watchdog = Watchdog.getInstance();

    public RobotBase() {
        _gametimer = new Timer();
        _gametimer.start();
        m_watchdog.setEnabled(false);
    }

    public boolean isSystemActive() {
        return true;
    }

    public Watchdog getWatchdog() {
        return m_watchdog;
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
        return _gametimer.get() >= 15;
    }

    public boolean isNewDataAvailable() {
        return false;
    }

    public abstract void startCompetition();
}
