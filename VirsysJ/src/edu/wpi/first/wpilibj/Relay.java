/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj;

/**
 * Class for Spike style relay outputs.
 * Relays are intended to be connected to spikes or similar relays. The relay channels controls
 * a pair of pins that are either both off, one on, the other on, or both on. This translates into
 * two spike outputs at 0v, one at 12v and one at 0v, one at 0v and the other at 12v, or two
 * spike outputs at 12V. This allows off, full forward, or full reverse control of motors without
 * variable speed.  It also allows the two channels (forward and reverse) to be used independently
 * for something that does not care about voltage polatiry (like a solenoid).
 */
public class Relay {

    /**
     * This class represents errors in trying to set realy values contradictory
     * to the direction to which the relay is set.
     */
    public class InvalidValueException extends RuntimeException {

        /**
         * Create a new exception with the given message
         * @param message the message to pass with the exception
         */
        public InvalidValueException(String message) {
            super(message);
        }
    }

    /**
     * The state to drive a Relay to.
     */
    public static class Value {

        /**
         * The integer value representing this enumeration
         */
        public final int value;
        static final int kOff_val = 0;
        static final int kOn_val = 1;
        static final int kForward_val = 2;
        static final int kReverse_val = 3;
        /**
         * value: off
         */
        public static final Relay.Value kOff = new Relay.Value(kOff_val);
        /**
         * value: on for relays with defined direction
         */
        public static final Relay.Value kOn = new Relay.Value(kOn_val);
        /**
         * value: forward
         */
        public static final Relay.Value kForward = new Relay.Value(kForward_val);
        /**
         * value: reverse
         */
        public static final Relay.Value kReverse = new Relay.Value(kReverse_val);

        private Value(int value) {
            this.value = value;
        }
    }

    /**
     * The Direction(s) that a relay is configured to operate in.
     */
    public static class Direction {

        /**
         * The integer value representing this enumeration
         */
        public final int value;
        static final int kBoth_val = 0;
        static final int kForward_val = 1;
        static final int kReverse_val = 2;
        /**
         * direction: both directions are valid
         */
        public static final Relay.Direction kBoth = new Relay.Direction(kBoth_val);
        /**
         * direction: Only forward is valid
         */
        public static final Relay.Direction kForward = new Relay.Direction(kForward_val);
        /**
         * direction: only reverse is valid
         */
        public static final Relay.Direction kReverse = new Relay.Direction(kReverse_val);

        private Direction(int value) {
            this.value = value;
        }
    }
    private int m_channel;
    private Relay.Direction m_direction;
    public boolean forwardOn = false;
    public boolean reverseOn = false;
    
    /**
     * Relay constructor given the module and the channel.
     * @param moduileNumber The number of the digital module to use.
     * @param channel The channel number within the module for this relay.
     * @param direction The direction that the Relay object will control.
     */
    public Relay(final int moduileNumber, final int channel, Relay.Direction direction) {
        if (direction == null)
            throw new NullPointerException("Null Direction was given");
        m_channel = channel;
        m_direction = direction;
    }

    /**
     * Relay constructor given a channel only where the default digital module is used.
     * @param channel The channel number within the default module for this relay.
     * @param direction The direction that the Relay object will control.
     */
    public Relay(final int channel, Relay.Direction direction) {
        if (direction == null)
            throw new NullPointerException("Null Direction was given");
        m_channel = channel;
        m_direction = direction;
    }

    /**
     * Relay constructor given the module and the channel, allowing both directions.
     * @param moduleNumber The number of the digital module to use.
     * @param channel The channel number within the module for this relay.
     */
    public Relay(final int moduleNumber, final int channel) {
        m_channel = channel;
        m_direction = Relay.Direction.kBoth;
    }

    /**
     * Relay constructor given a channel only where the default digital module is used,
     * allowing both directions.
     * @param channel The channel number within the default module for this relay.
     */
    public Relay(final int channel) {
        m_channel = channel;
        m_direction = Relay.Direction.kBoth;
    }

    public void free() {

    }

    /**
     * Set the relay state.
     *
     * Valid values depend on which directions of the relay are controlled by the object.
     *
     * When set to kBothDirections, the relay can be set to any of the four states:
	 *		0v-0v, 12v-0v, 0v-12v, 12v-12v
     *
     * When set to kForwardOnly or kReverseOnly, you can specify the constant for the
     *    direction or you can simply specify kOff_val and kOn_val.  Using only kOff_val and kOn_val is
     *    recommended.
     *
     * @param value The state to set the relay.
     */
    public void set(Relay.Value value) {
        switch (value.value) {
            case Relay.Value.kOff_val:
                if (m_direction == Relay.Direction.kBoth || m_direction == Relay.Direction.kForward) {
                    forwardOn = false;
                }
                if (m_direction == Relay.Direction.kBoth || m_direction == Relay.Direction.kReverse) {
                    reverseOn = false;
                }
                break;
            case Relay.Value.kOn_val:
                if (m_direction == Relay.Direction.kBoth || m_direction == Relay.Direction.kForward) {
                    forwardOn = true;
                } 
		if (m_direction == Relay.Direction.kBoth || m_direction == Relay.Direction.kReverse) {
                    reverseOn = true;
                }
                break;
            case Relay.Value.kForward_val:
                if (m_direction == Relay.Direction.kReverse)
                    throw new Relay.InvalidValueException("A relay configured for reverse cannot be set to forward");
                if (m_direction == Relay.Direction.kBoth || m_direction == Relay.Direction.kForward) {
                    forwardOn = true;
                }
                if (m_direction == Relay.Direction.kBoth) {
                    reverseOn = false;
                }
                break;
            case Relay.Value.kReverse_val:
                if (m_direction == Relay.Direction.kForward)
                    throw new Relay.InvalidValueException("A relay configured for forward cannot be set to reverse");
                if (m_direction == Relay.Direction.kBoth) {
                    forwardOn = false;
                }
                if (m_direction == Relay.Direction.kBoth || m_direction == Relay.Direction.kReverse) {
                    reverseOn = true;
                }
                break;
            default:
            //Cannot hit this, limited by Value enum
        }
    }

    /**
     * Set the Relay Direction
     *
     * Changes which values the relay can be set to depending on which direction is
     * used
     *
     * Valid inputs are kBothDirections, kForwardOnly, and kReverseOnly
     *
     *@param direction The direction for the relay to operate in
     */
    public void setDirection(Relay.Direction direction) {
        if (direction == null)
            throw new NullPointerException("Null Direction was given");
        if (m_direction == direction) {
            return;
        }

        free();

        m_direction = direction;
    }
}
