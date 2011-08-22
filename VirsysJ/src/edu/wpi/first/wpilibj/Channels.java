/*config file for all of the ports*/
package edu.wpi.first.wpilibj;
public interface Channels {
    //PWM out
    final int LEFT_PWM = 1;
    final int RIGHT_PWM = 2;
    final int ARM_PWM = 3;
    final int WRIST_PWM = 4;
    final int GRIP_PWM = 5;
    //InPorts
    final int ARM_ANGLE = 1;
    final int ARM_SPEED = 2;
    final int WRIST_ANGLE = 3;
    final int WRIST_SPEED = 4;
    final int LEFT_ANGLE = 5;
    final int LEFT_SPEED = 6;
    final int RIGHT_ANGLE = 7;
    final int RIGHT_SPEED = 8;
    final int HEADING_RATE = 9;
    //Encoder Channel
    final int CHANNEL_FRONT_LEFT_ENC_A       = 1;
    final int CHANNEL_FRONT_LEFT_ENC_B       = 2;
    final int CHANNEL_REAR_LEFT_ENC_A        = 9; // 3 / 4 were bad
    final int CHANNEL_REAR_LEFT_ENC_B        = 10;
    final int CHANNEL_FRONT_RIGHT_ENC_A      = 5;
    final int CHANNEL_FRONT_RIGHT_ENC_B      = 6;
    final int CHANNEL_REAR_RIGHT_ENC_A       = 7;
    final int CHANNEL_REAR_RIGHT_ENC_B       = 8;
}