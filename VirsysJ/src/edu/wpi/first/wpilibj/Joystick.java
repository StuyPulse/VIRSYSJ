/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj;


/**
 * Handle input from standard Joysticks connected to the Driver Station.
 * This class handles standard input that comes from the Driver Station. Each time a value is requested
 * the most recent value is returned. There is a single class instance for each joystick and the mapping
 * of ports to hardware buttons depends on the code in the driver station.
 */
public class Joystick {

    private final int m_port;
    static int NUM_JOYSTICKS = 4;
    public static double[][] stickAxes = new double[NUM_JOYSTICKS][3];
    public static boolean[][] stickButtons = new boolean[NUM_JOYSTICKS][12];

    /*static {
        for (int i = 0; i < NUM_JOYSTICKS; i++) {
            for (int j = 0; j <= stickAxes[0].length; j++) {
                setStickAxis(i, j, 0);
            }
            for (int j = 0; j <= stickAxes[0].length; j++) {
                setStickAxis(i, j, 0);
            }
        }
    }*/

    public static void setStickAxis(int port, int axis, double value) {
        stickAxes[port][axis] = value;
    }

    public static double getStickAxis(int port, int axis) {
        return stickAxes[port][axis];
    }

    public static void setStickButton(int port, int button, boolean value) {
        stickButtons[port][button] = value;
    }

    public static boolean getStickButton(int port, int button) {
        return stickButtons[port][button];
    }

    /**
     * Construct an instance of a joystick.
     * The joystick index is the usb port on the drivers station.
     *
     * @param port The port on the driver station that the joystick is plugged into.
     */
    public Joystick(final int port) {
        m_port = port;
    }

    /**
     * Get the value of the axis.
     *
     * @param axis The axis to read [1-6].
     * @return The value of the axis.
     */
    public double getRawAxis(final int axis) {
        return getStickAxis(m_port, axis);
    }

    public double getX() {
        return getRawAxis(0);
    }

    public double getY() {
        return getRawAxis(1);
    }

    public double getZ() {
        return getRawAxis(2);
    }

    /**
     * Get the button value for buttons 1 through 12.
     *
     * The buttons are returned in a single 16 bit value with one bit representing the state
     * of each button. The appropriate button is returned as a boolean value.
     *
     * @param button The button number to be read.
     * @return The state of the button.
     */
    public boolean getRawButton(final int button) {
        return getStickButton(m_port, button);
    }
}
