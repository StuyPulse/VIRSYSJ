/* sets the max torque for each wheel of which a percentage will be used*/
package edu;
public interface TorqueConfig{
    //The amount of torque that each motor can output.  Make these numbers
    //match the hardware on your robot
    final int LEFT_TORQUE  = 250;
    final int RIGHT_TORQUE = 250;
    final int ARM_TORQUE = 700;
    final int WRIST_TORQUE = 100;
}