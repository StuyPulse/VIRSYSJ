package edu.wpi.first.wpilibj;

public class Encoder {

    private Client _c;
    private boolean reverse;

    public Encoder(final int aChannel, final int bChannel, boolean reverseDirection, final CounterBase encodingType,Client c) {
        _c = c;
        reverse = reverseDirection;
        if (encodingType == null)
            throw new NullPointerException("Given encoding type was null");
    }

    public double getRate() {
        return 0;
    }

    public double getDistance() {
        return 0;
    }
    
    public void reset() {
      //Should do something here?
    }
}
