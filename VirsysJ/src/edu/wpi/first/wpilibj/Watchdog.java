package edu.wpi.first.wpilibj;

public class Watchdog {
    private static Watchdog m_instance;
    private boolean enabled;
    private double begining, interval;
    private Timer time;

    public Watchdog() {
        time = new Timer();
        enabled = true;
        begining = time.getFPGATimestamp();
        setExpiration(5);
        setEnabled(true);
    }

    public void feed() {
        begining = time.getFPGATimestamp();
    }

    public boolean getEnabled() {
        return enabled;
    }

    public double getExpiration() {
        return interval;
    }

    public double getTimer() {
        return time.getFPGATimestamp() - begining;
    }

    public boolean isAlive() {
        return time.getFPGATimestamp() < begining + interval;
    }

    public void kill() {
        setEnabled(false);
        setExpiration(1000000000);
    }

    public void setEnabled(boolean enables) {
        enabled = enables;
    }

    public void setExpiration(double expiration) {
        interval = (long) expiration;
    }

    /**
     *  Get an instance of the watchdog
     * @return an instance of the watchdog
     */
    public static synchronized Watchdog getInstance() {
        if (m_instance == null) {
            m_instance = new Watchdog();
        }
        return m_instance;
    }
}