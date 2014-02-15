/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022_2014.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2022_2014.commands.PinballShooterController;
import org.usfirst.frc2022_2014.custom.Spike;

/**
 *
 * @author Student
 */
public class PinballShooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Relay emLock;
    
    double distanceToPull;
    double speed;
    double timeNecessary = distanceToPull/speed;
    
    public PinballShooter(int portnumber) {
        emLock = new Relay(portnumber);
    }
    
    public void emOn(){
        emLock.set(Relay.Value.kOn);
    }
    
    public void emOff(){
        emLock.set(Relay.Value.kOff);
    }
    
    public void fire() {
        //let go of spring and reset. 
        reset();
    }
    
    public void reset() {
        emLock.set(Relay.Value.kOff);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new PinballShooterController());
    }
}