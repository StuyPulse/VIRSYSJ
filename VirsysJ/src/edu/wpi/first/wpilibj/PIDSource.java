package edu.wpi.first.wpilibj;

/**
 * This interface allows for PIDController to automatically read from this
 * object
 * @author dtjones
 */
public interface PIDSource {

    /**
     * Get the result to use in PIDController
     * @return the result to use in PIDController
     */
    public double pidGet();
}