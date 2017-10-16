/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tsakalis
 */
public class ChessBoardPosTest {
    
    public ChessBoardPosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLetter method, of class ChessBoardPos.
     */
    @Test
    public void testGetLetter() {
        System.out.println("getLetter");
        ChessBoardPos instance = null;
        char expResult = ' ';
        char result = instance.getLetter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLetter method, of class ChessBoardPos.
     */
    @Test
    public void testSetLetter() {
        System.out.println("setLetter");
        char letter = ' ';
        ChessBoardPos instance = null;
        instance.setLetter(letter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumber method, of class ChessBoardPos.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        ChessBoardPos instance = null;
        int expResult = 0;
        int result = instance.getNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumber method, of class ChessBoardPos.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        int number = 0;
        ChessBoardPos instance = null;
        instance.setNumber(number);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
