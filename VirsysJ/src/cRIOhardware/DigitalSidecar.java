package cRIOhardware;

public class DigitalSidecar {

    public static final int NUM_CHANNELS = 16;
    public static double[] register = new double[NUM_CHANNELS]; // store value for each channel
    public static boolean[] inputBits = new boolean[NUM_CHANNELS]; // inputBits[i] is true if the i'th channel is an input
}
