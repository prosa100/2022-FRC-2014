/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.custom;

/**
 *
 * @author kevin
 */
public class cyclicArray {
    private double[] history;
    private int position = 0;
    public cyclicArray(int buffer) {
        history = new double[buffer]; 
    }
    
    public void add(double x){
        history[position] = x;
        position++;
        position %= history.length;
    }
    
    public double get(){
        double sum = 0;
        for(int i = 0; i < history.length; i++){
            sum += history[i];
        }
        return sum / history.length;
    }


}
