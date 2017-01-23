/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import java.util.Scanner;


/**
 *
 * @author tsakalis
 */
public class Helper {

    public String getUserGuess() {
        String guess;
        System.out.print("Enter a guess ");
        Scanner sc = new Scanner(System.in);
        guess = sc.nextLine();

        return guess;
    }

}
