/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shortestpathchessboard;

import java.util.LinkedList;

/**
 *
 * @author tsakalis
 */
public class NodesList extends LinkedList<ArrayPos>{
    
    private boolean isListVisited= false;
    
    public NodesList()
    {
        this.isListVisited = false;        
    }

    public boolean isIsListVisited() {
        return isListVisited;
    }

    public void setIsListVisited(boolean isListVisited) {
        this.isListVisited = isListVisited;
    }
    
    
    
}
