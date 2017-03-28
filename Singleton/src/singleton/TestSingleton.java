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
public class TestSingleton {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Singleton.getInstance().sayHello();
    
        //we can call a static inner class methods without instantiating the outer class
        StaticClass.StaticSample staticEx = new StaticClass.StaticSample();
        staticEx.SayHello("Makis");
        
        //we can call a static inner class methods without instantiating the outer class
        StaticClass staticEx2 = new StaticClass();
        staticEx2.sayHelloFromInner();

        
        //Initialiazation on demand holder (Thread safe singleton)
        InitOnDmndHolder.getInstance().sayHello();
    }
    
}
