package edu.wpi.first.wpilibj;

public class Timer {

    private long m_startTime;
    private double m_accumulatedTime;
    private boolean m_running;

    public Timer() {
        reset();
    }

    public static void delay(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            System.out.print("you did sonething really bad!!");
        }
    }

    public double get() {
        if(m_running){
            return ((double) ((getFPGATimestamp() - m_startTime) + m_accumulatedTime)) / 1000.0;
        } else {
            return m_accumulatedTime;
        }
    }

    public static double getFPGATimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    public void reset() {
        m_accumulatedTime = 0;
        m_startTime = (long)getFPGATimestamp();
    }

    public void start() {
        m_startTime = (long)getFPGATimestamp();
        m_running = true;
    }

    public void stop() {
        final double temp = get();
        m_accumulatedTime += temp;
        m_running = false;
    }
}
