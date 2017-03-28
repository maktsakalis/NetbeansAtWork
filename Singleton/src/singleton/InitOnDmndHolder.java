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
public class InitOnDmndHolder {
    
    //private constructor
    private InitOnDmndHolder(){
        
    }
    
    
    public void sayHello(){
       System.out.println("Hello from Initialization on demand holder!");
    }
    
    public static InitOnDmndHolder getInstance(){
        
        return InitOnDmndHolderSampleHolder.INSTANCE;
    }
    
    //inner static class
    private static class InitOnDmndHolderSampleHolder{
    
    private final static InitOnDmndHolder INSTANCE = new InitOnDmndHolder();
}
}
