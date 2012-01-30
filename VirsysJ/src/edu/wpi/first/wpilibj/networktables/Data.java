package edu.wpi.first.wpilibj.networktables;

interface Data {


    public static final int STRING = 0;
    public static final int BEGIN_STRING = 255;
    public static final int END_STRING = 0;
    public static final int INT = 1;
    public static final int DOUBLE = 2;
    public static final int TABLE = 3;
    public static final int TABLE_ASSIGNMENT = 3;
    public static final int BOOLEAN_FALSE = 4;
    public static final int BOOLEAN_TRUE = 5;
    public static final int ASSIGNMENT = 6;
    public static final int EMPTY = 7;
    public static final int DATA = 8;
    public static final int OLD_DATA = 9;
    public static final int TRANSACTION = 10;
    public static final int REMOVAL = 11;
    public static final int TABLE_REQUEST = 12;
    public static final int ID = 128;
    public static final int TABLE_ID = 64;
    public static final int CONFIRMATION = 32;
    public static final int CONFIRMATION_MAX = 31;
    public static final int PING = 32;
    public static final int DENIAL = 16;

    public void encode(Buffer buffer);
}
