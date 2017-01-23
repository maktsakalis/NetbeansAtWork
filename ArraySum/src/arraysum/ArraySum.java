/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysum;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tsakalis
 */
public class ArraySum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner cin = null;
        String input = null;
        String size = null;
        int counter = 0;
        int sum = 0;
        String[] list ;

        try 
        {
            cin = new Scanner(System.in);
            size = cin.nextLine();

            if (Integer.parseInt(size) > 0) 
            {
                //space-separated line
                input = cin.nextLine();
                list = input.split("\\s");
                
                while (counter < Integer.parseInt(size)) 
                {
                    sum = sum + Integer.parseInt(list[counter]);
                    counter++;
                }
                System.out.println("The total sum of the array is: " + sum);
            }
        }
        catch (Exception e) 
        {
            // print error
            e.printStackTrace();
        }
        finally 
        {
            // closes the stream and releases resources associated
            if (cin != null) {
                cin.close();
            }
        }
    }

}
