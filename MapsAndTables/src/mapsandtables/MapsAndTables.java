/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapsandtables;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author tsakalis
 */
public class MapsAndTables {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        System.out.println("Hashtable Implementation!");
        Hashtable<String, Double> myHashtable = new Hashtable<String, Double>();
        Enumeration names;
        String str;
        double bal;

        myHashtable.put("Zara", new Double(3434.34));
        myHashtable.put("Mahnaz", new Double(123.22));
        myHashtable.put("Ayan", new Double(1378.00));
        myHashtable.put("Daisy", new Double(99.22));
        myHashtable.put("Qadir", new Double(-19.08));

        //Get HashTable key values
        names = myHashtable.keys();

        while (names.hasMoreElements()) {
            str = (String) names.nextElement();
            System.out.println(str + ": " + myHashtable.get(str));
        }
        System.out.println();

        // Deposit 1,000 into Zara's account
        bal = ((Double) myHashtable.get("Zara")).doubleValue();
        myHashtable.put("Zara", new Double(bal + 1000));
        System.out.println("Zara's new myHashtable: " + myHashtable.get("Zara"));
        System.out.println();
//------------------------------------END OF HASHTABLE CODE------------------------------------------------------------        


//------------------------------------START OF HASHMAP CODE------------------------------------------------------------        
        System.out.println("HashMap Implementation!");
        HashMap<String, Double> myHashMap = new HashMap<String, Double>();

        myHashMap.put("Zara", new Double(3434.34));
        myHashMap.put("Mahnaz", new Double(123.22));
        myHashMap.put("Ayan", new Double(1378.00));
        myHashMap.put("Daisy", new Double(99.22));
        //In HashMap null value as key is not permitted
        myHashMap.put(null, new Double(-19.08));
 
        //Get HashMap key values        
        Set set = myHashMap.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        while (i.hasNext()) {
            Map.Entry next = (Map.Entry) i.next();
            System.out.print(next.getKey() + ": ");
            System.out.println(next.getValue());
        }
        System.out.println();

        // Deposit 1,000 into Zara's account
        bal = ((Double) myHashMap.get("Zara")).doubleValue();
        myHashMap.put("Zara", new Double(bal + 1000));
        System.out.println("Zara's new myHashtable: " + myHashMap.get("Zara"));
        System.out.println();
    }

}
