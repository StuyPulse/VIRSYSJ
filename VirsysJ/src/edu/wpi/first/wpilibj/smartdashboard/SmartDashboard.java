package edu.wpi.first.wpilibj.smartdashboard;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;
import java.util.Hashtable;

public class SmartDashboard {

    private static Hashtable<String, Object> data;

    public SmartDashboard() {
        data = new Hashtable<String, Object>();
    }

    public static void putData(String key, SmartDashboardData value) {
        data.put(key, value);
    }

    public static void putData(SmartDashboardNamedData value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static SmartDashboardData getData(String key) throws NetworkTableKeyNotDefined {
        return (SmartDashboardData)(data.get(key));
    }

    public static void putBoolean(String key, boolean value) {
        data.put(key, value);
    }

    public static boolean getBoolean(String key) throws NetworkTableKeyNotDefined {
        return (Boolean)(data.get(key));
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static void putInt(String key, int value) {
        data.put(key, value);
    }

    public static int getInt(String key) throws NetworkTableKeyNotDefined {
        return (Integer)(data.get(key));
    }

    public static int getInt(String key, int defaultValue) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static void putDouble(String key, double value) {
        data.put(key, value);
    }

    public static double getDouble(String key) throws NetworkTableKeyNotDefined {
        return (Double)(data.get(key));
    }

    public static double getDouble(String key, double defaultValue) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static void putString(String key, String value) {
        data.put(key, value);
    }

    public static String getString(String key) throws NetworkTableKeyNotDefined {
        return (String)(data.get(key));
    }

    public static String getString(String key, String defaultValue) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static void init() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static int log(byte value, String name) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static int log(char value, String name) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static int log(int value, String name) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static int log(long value, String name) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static int log(short value, String name) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static int log(float value, String name) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static int log(double value, String name) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static int log(String value, String name) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static int log(boolean value, String name) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static int useProfile(String name) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static String diagnoseErrorCode(int code) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public static void useBlockingIO(boolean value) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
