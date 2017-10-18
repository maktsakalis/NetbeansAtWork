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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author tsakalis
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.mycompany.shortestpathchessboard.ArrayPosTest.class, com.mycompany.shortestpathchessboard.ShortestPathChessboardControlsTest.class, com.mycompany.shortestpathchessboard.ShortestPathChessboardDemoTest.class, com.mycompany.shortestpathchessboard.ChessBoardPosTest.class})
public class ShortestpathchessboardSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
