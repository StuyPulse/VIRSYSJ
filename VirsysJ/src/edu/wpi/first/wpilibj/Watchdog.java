package edu.wpi.first.wpilibj;

public class Watchdog {
    private boolean enabled;
    private double begining, interval;
    private Timer time;

    public Watchdog() {
        time = new Timer();
        enabled = true;
        begining = time.getFPGATimestamp();
        interval = 5;
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
}