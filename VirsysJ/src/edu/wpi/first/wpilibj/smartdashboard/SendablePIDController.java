package edu.wpi.first.wpilibj.smartdashboard;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class SendablePIDController extends PIDController implements SmartDashboardData {

    private NetworkTable table;

    public SendablePIDController(double p, double i, double d, PIDSource source, PIDOutput output) {
        //compiled code
        super(p, i, d, source, output);
        throw new RuntimeException("Compiled Code");
    }

    public SendablePIDController(double p, double i, double d, PIDSource source, PIDOutput output, double period) {
        //compiled code
        super(p, i, d, source, output, period);
        throw new RuntimeException("Compiled Code");
    }

    public synchronized void setSetpoint(double setpoint) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public synchronized void setPID(double p, double i, double d) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public synchronized void enable() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public synchronized void disable() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public String getType() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public NetworkTable getTable() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
