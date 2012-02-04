/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.smartdashboard;

import edu.wpi.first.wpilibj.util.BoundaryException;
import java.util.TimerTask;
import edu.wpi.first.wpilibj.*;

/**
 * Class implements a PID Control Loop.
 *
 * Creates a separate thread which reads the given PIDSource and takes
 * care of the integral calculations, as well as writing the given
 * PIDOutput
 */
public class SendablePIDController extends PIDController {


    /**
     * Allocate a PID object with the given constants for P, I, D
     * @param Kp the proportional coefficient
     * @param Ki the integral coefficient
     * @param Kd the derivative coefficient
     * @param source The PIDSource object that is used to get values
     * @param output The PIDOutput object that is set to the output value
     * @param period the loop time for doing calculations. This particularly effects calculations of the
     * integral and differential terms. The default is 50ms.
     */
    public SendablePIDController(double Kp, double Ki, double Kd,
            PIDSource source, PIDOutput output,
            double period) {
            super(Kp, Ki, Kd, source, output, period);
    }

    /**
     * Allocate a PID object with the given constants for P, I, D, using a 50ms period.
     * @param Kp the proportional coefficient
     * @param Ki the integral coefficient
     * @param Kd the derivative coefficient
     * @param source The PIDSource object that is used to get values
     * @param output The PIDOutput object that is set to the output value
     */
    public SendablePIDController(double Kp, double Ki, double Kd,
            PIDSource source, PIDOutput output) {
        this(Kp, Ki, Kd, source, output, kDefaultPeriod);
    }
}
