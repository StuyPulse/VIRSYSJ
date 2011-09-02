package edu.wpi.first.wpilibj;

public class Jaguar implements Channels, TorqueConfig{

    double prevspeed;
    int channel;

    Client c = CRIO.client;

    public Jaguar(int slot, int channel) {
        this(channel);
    }

    public Jaguar(int _channel) {
        channel = _channel;
    }

    public double get() {
        return prevspeed;
    }

    public void pidWrite(double output) {
        prevspeed = output;
        switch (channel) {
            case (LEFT_PWM):
                c.threadS.toSend[0] = (float)(output * LEFT_TORQUE);
                break;
            case (RIGHT_PWM):
                c.threadS.toSend[1] = (float)(output * RIGHT_TORQUE);
                break;
            case (ARM_PWM):
                c.threadS.toSend[2] = (float)(output * ARM_TORQUE);
                break;
            case (WRIST_PWM):
                c.threadS.toSend[3] = (float)(output * WRIST_TORQUE);
                break;
            case (GRIP_PWM):
                c.threadS.toSend[4] = (float)(output * GRIP_TORQUE);
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
