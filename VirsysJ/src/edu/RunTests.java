package edu;

import edu.wpi.first.wpilibj.CRIO;
import org.junit.*;

public class RunTests {
    public static void main(String[] args) {
	System.out.println("run those tests");
	CRIO.DigitalSidecar.register[0] = 5;
	System.out.println(CRIO.DigitalSidecar.register[0]);
    }
}

