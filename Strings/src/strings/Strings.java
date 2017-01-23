/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tsakalis
 */
public class Strings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        int k = input.nextInt();
        String token;
        int i,j;
        int length = in.length()-k;
        ArrayList<String> list = new ArrayList();
        int lex;
        int max=0;
        int min=0;
        String maxToken = null;
        String minToken = null;        
        
        if(in.length() < 1000){    
            for(i=0; i<=length;i++){
                token = in.substring(i,i+k);
                System.out.println(token);
                list.add(token);
            
            
            for(j=0; j<list.size();j++){
                
                lex = list.get(i).compareTo(list.get(j));
                
                System.out.println(" list.get("+ (i) +")= "+ list.get(i) + " list.get("+ j +")= "+ list.get(j) + ". lex= " + lex);
                
                
                if (lex >= max){
                    maxToken = list.get(i);
                    max=lex;
                }
                if(lex<min){
                    min=lex;
                    minToken = list.get(i);
                }
               }
            }
            System.out.println("max= "+max+" maxToken= "+ maxToken);
            System.out.println("min= "+max+" minToken= "+ minToken);
        }
        
    }
    
}
