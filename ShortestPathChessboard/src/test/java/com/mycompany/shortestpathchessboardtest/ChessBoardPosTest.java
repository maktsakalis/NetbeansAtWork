package com.mycompany.shortestpathchessboardtest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.shortestpathchessboard.ChessBoardPos;
import com.mycompany.shortestpathchessboard.ChessBoardPos;
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
        ChessBoardPos instance = new ChessBoardPos('A', 0);
        char expResult = 'A';
        char result = instance.getLetter();
        assertEquals(expResult, result);

    }

    /**
     * Test of setLetter method, of class ChessBoardPos.
     */
    @Test
    public void testSetLetter() {
        System.out.println("setLetter");
        char letter = 'A';
        ChessBoardPos instance = new ChessBoardPos('C', 0);
        instance.setLetter(letter);
        char expResult = instance.getLetter();
        assertEquals(expResult, letter);
    }

    /**
     * Test of getNumber method, of class ChessBoardPos.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        ChessBoardPos instance = new ChessBoardPos('A', 4);
        int expResult = 4;
        int result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumber method, of class ChessBoardPos.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        int number = 12;
        ChessBoardPos instance = new ChessBoardPos('C', 0);;
        instance.setNumber(number);
        int result = instance.getNumber();
        assertEquals(number, result);        
    }
    
}
