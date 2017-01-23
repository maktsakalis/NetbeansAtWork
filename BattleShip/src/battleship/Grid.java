/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author tsakalis
 */
public class Grid {

    ArrayList<Ship> targets = new ArrayList<Ship>();

    public void setAllocationCells(ArrayList<Ship> targets) {
        this.targets = targets;
    }

    public boolean checkGrid(String guess) {
        boolean guessResult = false;
        boolean gameResult = false;

        if (!targets.isEmpty()) {

            //use of iterator
            Iterator<Ship> i = targets.iterator();
            
            //for each ship on the grid
            while (i.hasNext()) {
                Ship sp = i.next();
                //if guess is one ship's coordinate
                if (sp.shipCoordinates.contains(guess)) {
                    System.out.println("hit");
                    guessResult = true;

                    System.out.println("You delivered a hit on " + sp.shipName);
                    sp.shipCoordinates.remove(sp.shipCoordinates.indexOf(guess));
                }
                if (sp.shipCoordinates.isEmpty()) {

                    System.out.println("Ouch! You sunk " + sp.shipName);
                    i.remove();
                }
            }
        }
        if (guessResult == false) {
            System.out.println("miss");
        }

        if (targets.isEmpty()) {
            gameResult = true;
        }

        return gameResult;
    }
}
