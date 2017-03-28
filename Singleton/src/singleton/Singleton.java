/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author tsakalis
 */
public class Singleton {

   private Singleton(){}
   
   private static Singleton instance  = null;
   
   public void sayHello(){
       System.out.println("Hello from Singleton!");
   }
   
   public static Singleton getInstance(){
       
       if(instance == null){
           return instance = new Singleton();
       }
       return instance;
   }
}
