/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

/**
 *
 * @author tsakalis
 */
public class Operators {

    
     public static String toBinaryString(byte n) {
        StringBuilder sb = new StringBuilder("00000000");
        for (int bit = 0; bit < 8; bit++) {
            if (((n >> bit) & 1) != 0) {
                sb.setCharAt(7 - bit, '1');
            }
        }
        return sb.toString();
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        byte FIRST_BIT = 0X01;
        byte SECOND_BIT = 0X02;
        byte THIRD_BIT = 0X04;
        byte FOURTH_BIT = 0X08;
        byte FIFTH_BIT = 0X10;
        byte SIXTH_BIT = 0X20;
        byte SEVENTH_BIT = 0X40;

        byte TEST_BIT = 0X02;

        // Scanner sc = new Scanner(System.in);
        //System.out.println("Please enter an int: " + sc.nextInt());
        System.out.println("Bitwise AND: " + (THIRD_BIT & TEST_BIT));
        System.out.println("Bitwise AND: " + (THIRD_BIT >> TEST_BIT));
        
        System.out.println("Bitwise SHIFT: " + toBinaryString((byte)(THIRD_BIT >> TEST_BIT)));                
   
}

}
