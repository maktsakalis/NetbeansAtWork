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
public class ArrayPosTest {
    
    public ArrayPosTest() {
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
     * Test of equals method, of class ArrayPos.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        ArrayPos instance = new ArrayPos(1, 2);
        ArrayPos secInstance = new ArrayPos(1, 2);        
        boolean expResult = true;
        boolean result = instance.equals(instance);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class ArrayPos.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ArrayPos instance = new ArrayPos(1, 2);
        ArrayPos secInstance = new ArrayPos(1, 2);
        int expResult = secInstance.hashCode();        
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getX method, of class ArrayPos.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        ArrayPos instance = new ArrayPos(1, 2);
        int expResult = 1;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of setX method, of class ArrayPos.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 4;
        ArrayPos instance = new ArrayPos(0, 0);
        instance.setX(x);
        assertEquals(x, instance.getX());        
    }

    /**
     * Test of getY method, of class ArrayPos.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        ArrayPos instance = new ArrayPos(1, 2);
        int expResult = 2;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of setY method, of class ArrayPos.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 7;
        ArrayPos instance = new ArrayPos(0, 0);
        instance.setY(y);
        assertEquals(y, instance.getY());
    }
    
}
