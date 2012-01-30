package edu.wpi.first.wpilibj;

import utilities.Channels;
import crio.hardware.CRIO;
import crio.hardware.DigitalSidecar;


public class Jaguar extends Victor {
    // For the purpose of this simulator, Victor and Jaguar do the same thing

    public Jaguar(int channel) {
       super(channel);
    }
    
    public Jaguar(int slot, int channel) {
        super(slot, channel);
    }
}