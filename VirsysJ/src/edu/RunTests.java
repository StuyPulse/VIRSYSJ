package edu;

import edu.wpi.first.wpilibj.CRIO;
/*import junit.framework.*;
import org.junit.Test;*/

//import org.junit.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Assert;
import org.junit.Test;

public class RunTests {
    public static void main(String[] args) {
	System.out.println("run those tests");
	/*	Class[] testClasses = { DigitalTest.class };
	TestSuite suite = new TestSuite(testClasses);
	TestResult result = new TestResult();
	suite.run(result);
	System.out.format("Ran %d tests: %d errors and %d failures\n", result.runCount(), result.errorCount(), result.failureCount());*/


	Result result = JUnitCore.runClasses(DigitalTest.class);
	for (Failure failure : result.getFailures()) {
	    System.out.println(failure.toString());
	}
    }
}

class DigitalTest {
    
    @Test
    void testDigital() {
	CRIO.DigitalSidecar.register[0] = true;
	CRIO.DigitalSidecar.register[1] = false;
	Assert.assertEquals(CRIO.DigitalSidecar.register[0], true);
	Assert.assertEquals(CRIO.DigitalSidecar.register[1], false);
    }
}