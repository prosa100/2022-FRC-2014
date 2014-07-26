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
public class flipper {
    private boolean last = false;
    public flipper(){
    }

    public boolean flip(boolean current){
        boolean r = current == true && last == false;
        last = current;
        return r;
    }
}
                                   