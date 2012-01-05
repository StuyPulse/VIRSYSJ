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
 * @author blake
 */
public class CRIOTest {

    public CRIOTest() {
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
     * Test of main method, of class CRIO.
     *
    @Test
    public void testMain() {
        System.out.println("main");
        String[] arg = null;
        CRIO.main(arg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /*
     * Test the ability to write a digital output
     */
    @Test
    public void testWriteDigital() {
        CRIO.DigitalSidecar.register[0] = true;
        assertEquals(CRIO.DigitalSidecar.register[0], true);
    }
}