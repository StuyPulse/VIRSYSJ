package edu.wpi.first.wpilibj.networktables;

public interface NetworkListener {

    public void valueChanged(String string, Object o);

    public void valueConfirmed(String string, Object o);
}
