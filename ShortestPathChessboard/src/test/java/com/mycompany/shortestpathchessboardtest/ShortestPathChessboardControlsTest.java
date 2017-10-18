package com.mycompany.shortestpathchessboardtest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.shortestpathchessboard.ArrayPos;
import com.mycompany.shortestpathchessboard.ShortestPathChessboardControls;
import com.mycompany.shortestpathchessboard.ShortestPathChessboardControls;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
     * Test of createChessBoardPane method, of class
     * ShortestPathChessboardControls.
     */
    @Test
    public void testCreateChessBoardPane() {
        System.out.println("createChessBoardPane");
        ShortestPathChessboardControls instance = new ShortestPathChessboardControls();
        instance.createChessBoardPane();

    }

    /**
     * Test of createInputPane method, of class ShortestPathChessboardControls.
     */
    @Test
    public void testCreateInputPane() {
        System.out.println("createInputPane");
        ShortestPathChessboardControls instance = new ShortestPathChessboardControls();
        instance.createInputPane();
    }


//
//    /**
//     * Test of calcHorsePossibleNextNodes method, of class
//     * ShortestPathChessboardControls.
//     */
//    @Test
//    public void testCalcHorsePossibleNextNodes() {
//        System.out.println("calcHorsePossibleNextNodes");
//
//        ArrayPos test = new ArrayPos(4, 5);
//        int row = test.getX();
//        int col = test.getY();
//
//        ShortestPathChessboardControls instance = new ShortestPathChessboardControls();
//        ArrayPos[] nodes = new ArrayPos[8];
//        LinkedList<ArrayPos> possibleSquares = new LinkedList<ArrayPos>();
//
//        //all possible next squares for horse figure based on horse moves pattern
//        nodes[0] = new ArrayPos(row - 2, col - 1);
//        nodes[1] = new ArrayPos(row - 1, col - 2);
//        nodes[2] = new ArrayPos(row - 2, col + 1);
//        nodes[3] = new ArrayPos(row - 1, col + 2);
//        nodes[4] = new ArrayPos(row + 1, col - 2);
//        nodes[5] = new ArrayPos(row + 2, col - 1);
//        nodes[6] = new ArrayPos(row + 1, col + 2);
//        nodes[7] = new ArrayPos(row + 2, col + 1);
//
//        for (int j = 0; j < nodes.length; j++) {
//            //add only valid squares that are on board and has not been visited
//            if (isSquareOnBoard(nodes[j]) && !instance.visitedNodes.contains(nodes[j])) {
//                possibleSquares.add(nodes[j]);
//            }
//        }
//        if (!instance.visitedNodes.isEmpty()) {
//            possibleSquares.removeAll(instance.visitedNodes);
//        }
//
//    }

}
