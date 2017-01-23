/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.ArrayList;

/**
 *
 * @author tsakalis
 */
public class Ship {
    
    String shipName;
    ArrayList<String> shipCoordinates;
    
    
    public Ship(String shipName, ArrayList<String> shipCoordinates)
    {
        this.shipName = shipName;
        this.shipCoordinates = shipCoordinates;
    }
    
}
