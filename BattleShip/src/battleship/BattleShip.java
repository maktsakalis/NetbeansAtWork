/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author tsakalis
 */
public class BattleShip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String guess;
        Helper helper = new Helper();
        Grid grid = new Grid();
        ArrayList<Ship> ships = new ArrayList<Ship>();

        Ship a = new Ship("Titanic", new ArrayList<String>(Arrays.asList("B0", "C0", "D0")));
        ships.add(a);
        Ship b = new Ship("Averof", new ArrayList<String>(Arrays.asList("D2", "D3", "D4")));
        ships.add(b);
        Ship c = new Ship("Britannik", new ArrayList<String>(Arrays.asList("G3", "G4", "G5")));
        ships.add(c);

        grid.setAllocationCells(ships);
        
        do {
            guess = helper.getUserGuess();
        } while (!grid.checkGrid(guess));

    }

}
