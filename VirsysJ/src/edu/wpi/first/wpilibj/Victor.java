package edu.wpi.first.wpilibj;

public class Victor implements Channels {

    double prevspeed;
    int channel;

    Client c = CRIO.client;

    public Victor(int _channel) {
       channel = _channel;
    }

    public Victor(int slot, int channel) {
        this(channel);
    }

    public double get() {
        return prevspeed;
    }

    public void pidWrite(double output) {
        prevspeed = output;

	double[] motor_stall_torques = new double[5];
	motor_stall_torques[0] = 250.0;
	motor_stall_torques[1] = 250.0;
	motor_stall_torques[2] = 700.0;
	motor_stall_torques[3] = 100.0;
	motor_stall_torques[4] = 100.0;
	
	c.threadS.toSend[channel-1] = (float)(output * motor_stall_torques[channel-1]);
    }

    public void set(double speed) {
        pidWrite(speed);
    }
}
