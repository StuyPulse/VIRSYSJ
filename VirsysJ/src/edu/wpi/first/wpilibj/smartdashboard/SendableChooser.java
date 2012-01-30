package edu.wpi.first.wpilibj.smartdashboard;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import java.util.Hashtable;

public class SendableChooser implements SmartDashboardData {

    private static final String DEFAULT = "default";
    private static final String COUNT = "count";
    private static final String SELECTED = "selected";
    private Object defaultChoice;
    private Hashtable choices;
    private Hashtable ids;
    private NetworkTable table;
    private int count;

    public SendableChooser() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void addObject(String name, Object object) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public void addDefault(String name, Object object) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public Object getSelected() {
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
