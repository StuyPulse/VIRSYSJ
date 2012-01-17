/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj;

import cRIOhardware.DigitalSidecar;
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
public class ServoTest {

    public ServoTest() {
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
     * Test of set method, of class Servo.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        double value = 0.5;
        Servo instance = new Servo(5);
        instance.set(value);
        assertEquals(0.5, DigitalSidecar.register[4], 0.1);
    }

    /**
     * Test of get method, of class Servo.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Servo instance = new Servo(4);
        instance.set(1.0);
        double result = instance.get();
        assertEquals(1.0, result, 0.1);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setAngle method, of class Servo.
     */
    @Test
    public void testSetAngle() {
        System.out.println("setAngle");
        double degrees = 10.0;
        Servo instance = new Servo(3);
        instance.setAngle(degrees);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(1.0/17.0,DigitalSidecar.register[2],0.1);
    }

    /**
     * Test of getAngle method, of class Servo.
     */
    @Test
    public void testGetAngle() {
        System.out.println("getAngle");
        Servo instance = new Servo(1);
        instance.setAngle(45);
        assertEquals(45.0,instance.getAngle(), 0.1);
    }

}