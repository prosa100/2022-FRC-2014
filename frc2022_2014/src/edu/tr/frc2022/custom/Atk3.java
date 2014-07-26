/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.tr.frc2022.custom;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author krosa
 */


public class Atk3 extends Joystick{
    public final double  Deadzone;
    
    public double clamp(double a){
        return (Math.abs(a) < Deadzone) ? 0 : a;
    }
    
    public Atk3(int port, double deadzone) {
        super(port);
        Deadzone = deadzone;
    }
    
    public double GetY(){
        return clamp(getY());
    }
    
    
}
