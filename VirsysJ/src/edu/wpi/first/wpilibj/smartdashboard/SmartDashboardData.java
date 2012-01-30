package edu.wpi.first.wpilibj.smartdashboard;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public interface SmartDashboardData {

    public String getType();

    public NetworkTable getTable();
}
