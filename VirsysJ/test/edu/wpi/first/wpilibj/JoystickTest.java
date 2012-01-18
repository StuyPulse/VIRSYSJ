/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author English
 */
public class JoystickTest {

    public JoystickTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getX method, of class Joystick.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Joystick instance = new Joystick(1);
        double expResult = 0.0;
        double result = instance.getX();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getY method, of class Joystick.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Joystick instance = new Joystick(1);
        double expResult = 0.0;
        double result = instance.getY();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getZ method, of class Joystick.
     */
    @Test
    public void testGetZ() {
        System.out.println("getZ");
        Joystick instance = new Joystick(1);
        double expResult = 0.0;
        double result = instance.getZ();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getTwist method, of class Joystick.
     */
    @Test
    public void testGetTwist() {
        System.out.println("getTwist");
        Joystick instance = new Joystick(1);
        double expResult = 0.0;
        double result = instance.getTwist();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getThrottle method, of class Joystick.
     */
    @Test
    public void testGetThrottle() {
        System.out.println("getThrottle");
        Joystick instance = new Joystick(1);
        double expResult = 0.0;
        double result = instance.getThrottle();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getRawAxis method, of class Joystick.
     */
    @Test
    public void testGetRawAxis() {
        System.out.println("getRawAxis");
        int axis = 0; //should give x-cor val
        Joystick instance = new Joystick(1);
        double expResult = 0.0;
        double result = instance.getRawAxis(axis);
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getTrigger method, of class Joystick.
     */
    @Test
    public void testGetTrigger() {
        System.out.println("getTrigger");
        Joystick instance = new Joystick(1);
        boolean expResult = false;
        boolean result = instance.getTrigger();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTop method, of class Joystick.
     */
    @Test
    public void testGetTop() {
        System.out.println("getTop");
        Joystick instance = new Joystick(1);
        boolean expResult = false;
        boolean result = instance.getTop();
        assertEquals(expResult, result);
    }
   
    /**
     * Test of getRawButton method, of class Joystick.
     */
    @Test
    public void testGetRawButton() {
        System.out.println("getRawButton");
        int button = 0;
        Joystick instance = new Joystick(1);
        boolean expResult = false;
        boolean result = instance.getRawButton(button);
        assertEquals(expResult, result);
    }
  
    /**
     * Test of getMagnitude method, of class Joystick.
     */
    @Test
    public void testGetMagnitude() {
        System.out.println("getMagnitude");
        Joystick instance = new Joystick(1);
        double expResult = 0.0;
        double result = instance.getMagnitude();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getDirectionRadians method, of class Joystick.
     */
    @Test
    public void testGetDirectionRadians() {
        System.out.println("getDirectionRadians");
        Joystick instance = new Joystick(1);
        double expResult = 0.0;
        double result = instance.getDirectionRadians();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getDirectionDegrees method, of class Joystick.
     */
    @Test
    public void testGetDirectionDegrees() {
        System.out.println("getDirectionDegrees");
        Joystick instance = new Joystick(1);
        double expResult = 0.0;
        double result = instance.getDirectionDegrees();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getAxisChannel method, of class Joystick.
     */
    @Test
    public void testGetAxisChannel() {
        System.out.println("getAxisChannel");
        AxisType axis = AxisType.kY;
        Joystick instance = new Joystick(1);
        int expResult = 1;
        int result = instance.getAxisChannel(axis);
        assertEquals(expResult, result);
    }

    /**
     * Test of setAxisChannel method, of class Joystick.
     */
    @Test
    public void testSetAxisChannel() {
        System.out.println("setAxisChannel");
        AxisType axis = AxisType.kZ;
        Joystick instance = new Joystick(1);
        int channel = 6;
        int expResult = 6;
        instance.setAxisChannel(axis, channel);
        int result = instance.getAxisChannel(axis);
        assertEquals(expResult, result);
    }

}