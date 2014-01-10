/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022_2014.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Student
 */
public class PinballShooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Jaguar motor;
    
    double distanceToPull;
    double speed;
    double timeNecessary = distanceToPull/speed;
    
    public PinballShooter(int portnumber) {
        motor = new Jaguar(portnumber);
    }
    
    public void fire() {
        //let go of spring and reset. 
        reset();
    }
    
    public void reset() {
        motor.set(speed);
        //MAKE IT WAIT FOR A CERTAIN TIME.
        motor.set(0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        
        
        
    }
}