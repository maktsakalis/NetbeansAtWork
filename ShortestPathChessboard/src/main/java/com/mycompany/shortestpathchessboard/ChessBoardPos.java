package com.mycompany.shortestpathchessboard;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author makis
 */
public class ChessBoardPos {

    private char letter;
    private int number;

    public ChessBoardPos(char letter, int number) {
        this.letter = letter;
        this.number = number;
    }

    @Override
    public String toString()
    {
        String result = String.valueOf(letter).concat(String.valueOf(number));
        return result;
    }
        
    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }   
}
