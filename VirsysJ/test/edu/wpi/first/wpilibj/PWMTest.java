/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 694
 */
public class PWMTest {

    public PWMTest() {
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
    
    @Test
    public void PWMTest() {
        PWM myPwm = new PWM();
        assert(myPwm != null);
    }

    @Test
    public void freeTest() {
        
    }

    @Test
    public void getPositionTest() {
        PWM myPWM = new PWM();
        assert(myPWM.getPosition() < 1.0 && myPWM.getPosition() > 0.0);
    }

    @Test
    public void setPositionTest(){
        double position;
        position = myPWM.setPosition(0.5);
    }

    @Test
    public void setRawTest(){
        int raw;
        raw = myPWN.setRaw(128);
    }

    @Test
    public void getRawTest(){
        PWM myPWM = new PWM();
        assert(myPWM.getRaw() < 256 && myPWM.getRaw() > -1);
    }
}