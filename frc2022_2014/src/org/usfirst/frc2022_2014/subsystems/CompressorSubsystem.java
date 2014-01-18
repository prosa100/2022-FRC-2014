/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022_2014.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Michael
 */
public class CompressorSubsystem extends Subsystem {

    private Compressor compressor;
    private DoubleSolenoid dsol;
    
    public CompressorSubsystem(int sol1Port, int sol2Port, int compSwitchChannel, int compRelayChannel){
        compressor = new Compressor(compSwitchChannel, compRelayChannel);
        dsol = new DoubleSolenoid(sol1Port, sol2Port);
    }
    
    public void start(){
        compressor.start();
        dsol.set(DoubleSolenoid.Value.kOff);
    }
    
    public void stop(){
        dsol.set(DoubleSolenoid.Value.kOff);
        compressor.stop();
    }
    
    public void closeSolenoid(){
        dsol.set(DoubleSolenoid.Value.kOff);
    }
    
    public void forwardSolenoid(){
        dsol.set(DoubleSolenoid.Value.kForward);
    }
    
    public void backwardSolenoid(){
        dsol.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void initDefaultCommand() {
        
    }
}
