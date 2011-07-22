/*config file for all of the ports*/
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
}