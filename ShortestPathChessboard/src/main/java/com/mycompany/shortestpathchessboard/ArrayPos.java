/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author makis
 */
public class ArrayPos {

    int x;
    int y;

    ArrayPos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if ((o instanceof ArrayPos) && (((ArrayPos) o).x == this.x) && (((ArrayPos) o).y == this.y))
        {
            return true;
        } else
        {
            return false;
        }
    }

    @Override
    //in order to be two objects equals in a hashmap, appart from their values, their hashcodes must be equals as well.
    public int hashCode() {
        int result = 0;
        result = x + y;
        return result;
    }

}
