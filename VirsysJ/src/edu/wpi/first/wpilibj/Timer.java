package edu.wpi.first.wpilibj;

public class Timer {

    private long beggining;
    private double time;

    public Timer() {
    }

    public void delay(double seconds) {
        try {
            Thread.currentThread().sleep((int) seconds * 1000);
        } catch (InterruptedException e) {
            System.out.print("you did sonething really bad!!");
        }
    }

    public double get() {
        return time;
    }

    public double getFPGATimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    public void reset() {
        time = 0;
    }

    public void start() {
        beggining = System.currentTimeMillis();
    }

    public void stop() {
        time = (System.currentTimeMillis() - beggining) / 1000;
    }
}
