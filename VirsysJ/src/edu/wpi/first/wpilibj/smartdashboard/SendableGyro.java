package edu.wpi.first.wpilibj.smartdashboard;

//import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class SendableGyro extends Gyro implements SmartDashboardData {

    private static final double DEFAULT_TIME_BETWEEN_UPDATES = 0.2;
    private double offset;
    private double period;
    private NetworkTable table;

    public SendableGyro(int moduleNumber, int channel) {
        //compiled code
        super(moduleNumber, channel);
        throw new RuntimeException("Compiled Code");
    }

    public SendableGyro(int channel) {
        //compiled code
        super(channel);
        throw new RuntimeException("Compiled Code");
    }

    public double getAngle() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void reset() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void setUpdatePeriod(double period) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public double getUpdatePeriod() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void resetToAngle(double angle) {
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
