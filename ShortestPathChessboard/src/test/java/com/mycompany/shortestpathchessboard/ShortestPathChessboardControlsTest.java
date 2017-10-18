/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shortestpathchessboard;

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
public class ShortestPathChessboardControlsTest {
    
    public ShortestPathChessboardControlsTest() {
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
     * Test of createChessBoardPane method, of class ShortestPathChessboardControls.
     */
    @Test
    public void testCreateChessBoardPane() {
        System.out.println("createChessBoardPane");
        ShortestPathChessboardControls instance = new ShortestPathChessboardControls();
        instance.createChessBoardPane();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createInputPane method, of class ShortestPathChessboardControls.
     */
    @Test
    public void testCreateInputPane() {
        System.out.println("createInputPane");
        ShortestPathChessboardControls instance = new ShortestPathChessboardControls();
        instance.createInputPane();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSquareOnBoard method, of class ShortestPathChessboardControls.
     */
    @Test
    public void testIsSquareOnBoard() {
        System.out.println("isSquareOnBoard");
        ArrayPos a = null;
        ShortestPathChessboardControls instance = new ShortestPathChessboardControls();
        boolean expResult = false;
        boolean result = instance.isSquareOnBoard(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
