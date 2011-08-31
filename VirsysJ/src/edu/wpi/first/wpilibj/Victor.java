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
        output = prevspeed;
        switch (channel) {
            case (LEFT_PWM):
                c.send((float)(output * LEFT_TORQUE), 0, 0, 0, 0);
                break;
            case (RIGHT_PWM):
                c.send(0,(float)(output * RIGHT_TORQUE), 0, 0, 0);
                break;
            case (ARM_PWM):
                c.send(0, 0, (float)(output * ARM_TORQUE), 0, 0);
                break;
            case (WRIST_PWM):
                c.send(0, 0, 0, (float)(output * WRIST_TORQUE), 0);
                break;
            case (GRIP_PWM):
                c.send(0, 0, 0, 0, (float)(output * GRIP_TORQUE));
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
