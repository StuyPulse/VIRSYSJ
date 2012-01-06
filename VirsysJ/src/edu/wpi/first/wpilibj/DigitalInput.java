package edu.wpi.first.wpilibj;

/**
 * Class to read a digital input.
 * This class will read digital inputs and return the current value on the channel. Other devices
 * such as encoders, gear tooth sensors, etc. that are implemented elsewhere will automatically
 * allocate digital inputs and outputs as required. This class is only for devices like switches
 * etc. that aren't implemented anywhere else.
 */
public class DigitalInput {

    /**
     * Create an instance of a Digital Input class.
     * Creates a digital input given a channel and uses the default module.
     * @param channel the port for the digital input
     */
    public DigitalInput(int channel) {
    }

    /**
     * Get the value from a digital input channel.
     * Retrieve the value of a single digital input channel from the FPGA.
     * @return the stats of the digital input
     */
    public boolean get() {
        return false;
    }
}