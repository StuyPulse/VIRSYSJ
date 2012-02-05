/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj;


/**
 * Analog channel class.
 *
 * Each analog channel is read from hardware as a 12-bit number representing -10V to 10V.
 *
 * Connected to each analog channel is an averaging and oversampling engine.  This engine accumulates
 * the specified ( by setAverageBits() and setOversampleBits() ) number of samples before returning a new
 * value.  This is not a sliding window average.  The only difference between the oversampled samples and
 * the averaged samples is that the oversampled samples are simply accumulated effectively increasing the
 * resolution, while the averaged samples are divided by the number of samples to retain the resolution,
 * but get more stable values.
 */
public class AnalogChannel implements PIDSource {

    private int m_channel;
    public int value;
    public int avgValue;
    public int voltage;
    public int avgVoltage;
    
    /**
     * Construct an analog channel on the default module.
     *
     * @param channel The channel number to represent.
     */
    public AnalogChannel(final int channel) {
        m_channel = channel;
    }

    /**
     * Get a sample straight from this channel on the module.
     * The sample is a 12-bit value representing the -10V to 10V range of the A/D converter in the module.
     * The units are in A/D converter codes.  Use GetVoltage() to get the analog value in calibrated units.
     * @return A sample straight from this channel on the module.
     */
    public int getValue() {
        return value;
    }

    /**
     * Get a sample from the output of the oversample and average engine for this channel.
     * The sample is 12-bit + the value configured in SetOversampleBits().
     * The value configured in setAverageBits() will cause this value to be averaged 2**bits number of samples.
     * This is not a sliding window.  The sample will not change until 2**(OversamplBits + AverageBits) samples
     * have been acquired from the module on this channel.
     * Use getAverageVoltage() to get the analog value in calibrated units.
     * @return A sample from the oversample and average engine for this channel.
     */
    public int getAverageValue() {
        return avgValue;

    }
    
    /**
     * Get a scaled sample straight from this channel on the module.
     * The value is scaled to units of Volts using the calibrated scaling data from getLSBWeight() and getOffset().
     * @return A scaled sample straight from this channel on the module.
     */
    public double getVoltage() {
        return voltage;
    }

    /**
     * Get a scaled sample from the output of the oversample and average engine for this channel.
     * The value is scaled to units of Volts using the calibrated scaling data from getLSBWeight() and getOffset().
     * Using oversampling will cause this value to be higher resolution, but it will update more slowly.
     * Using averaging will cause this value to be more stable, but it will update more slowly.
     * @return A scaled sample from the output of the oversample and average engine for this channel.
     */
    public double getAverageVoltage() {
        return avgVoltage;
    }

    /**
     * Get the channel number.
     * @return The channel number.
     */
    public int getChannel() {
        return m_channel;
    }

    /**
     * Get the average value for usee with PIDController
     * @return the average value
     */
    public double pidGet() {
        return getAverageValue();
    }
}
