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
public class StaticClass {
    
    public static class StaticSample{
        
        public void SayHello(String name){
                System.out.println("Hello " + name + " from inner static class!");
        }
    
    }
    
    void sayHelloFromInner(){
        InnerSample inner = new InnerSample();
        inner.SayHello();
    }
    
    private class InnerSample{
        
        public void SayHello(){
                System.out.println("Hello from inner class!");
        }
    
    }
    
}
