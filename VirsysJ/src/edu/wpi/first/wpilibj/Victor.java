package edu.wpi.first.wpilibj;

public class Victor implements Channels, TorqueConfig {

    double prevspeed;
    int channel;
    Client c;

    public Victor(int _channel, Client _c) {
        c = _c;
       channel = _channel;
    }

    public Victor(int slot, int channel, Client _c) {
        this(channel,_c);
    }

    public double get() {
        return prevspeed;
    }

    public void pidWrite(double output) {
        prevspeed = output;
        switch (channel) {
            case (LEFT_PWM):
                c.toSend[0] = (float)(output * LEFT_TORQUE);
                System.out.println("set left to: " + c.toSend[0] + " = " + output + " * " + LEFT_TORQUE);
                break;
            case (RIGHT_PWM):
                c.toSend[1] = (float)(output * RIGHT_TORQUE);
                System.out.println("set right to: " + c.toSend[1]);
                break;
            case (ARM_PWM):
                c.toSend[2] = (float)(output * ARM_TORQUE);
                break;
            case (WRIST_PWM):
                c.toSend[3] = (float)(output * WRIST_TORQUE);
                break;
            case (GRIP_PWM):
                c.toSend[4] = (float)(output * GRIP_TORQUE);
                break;
            default:
                System.out.println("channel does not match any PWM values... try again");
                break;
        }
    }

    public void set(double speed) {
        pidWrite(speed);
    }
}
