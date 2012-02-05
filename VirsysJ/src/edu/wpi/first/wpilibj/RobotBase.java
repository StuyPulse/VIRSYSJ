package edu.wpi.first.wpilibj;

public abstract class RobotBase {

    private Timer _gametimer;
    private final Watchdog m_watchdog = Watchdog.getInstance();

    public final double TOTAL_MATCH_TIME_SECONDS = 10;
    public final double AUTON_TIME_SECONDS = 5;

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
        return _gametimer.get() < TOTAL_MATCH_TIME_SECONDS;
    }

    public boolean isDisabled() {
        return !isEnabled();
    }

    public boolean isAutonomous() {
        //System.out.println(_gametimer.get());
        return _gametimer.get() < AUTON_TIME_SECONDS;
    }

    public boolean isOperatorControl() {
        return (_gametimer.get() >= AUTON_TIME_SECONDS) &&
	    (_gametimer.get() < TOTAL_MATCH_TIME_SECONDS);
    }

    public boolean isNewDataAvailable() {
        return false;
    }

    public abstract void startCompetition();
}
