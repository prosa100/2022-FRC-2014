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
import org.usfirst.frc2022_2014.custom.LimitSwitch;

/**
 *
 * @author Michael
 */
public class CompressorSubsystem extends Subsystem {

    private Compressor compressor;
    private DoubleSolenoid dsol;
    private Relay spikerelay;
    private LimitSwitch lswitchout;
    private LimitSwitch lswitchin;

    
    public CompressorSubsystem(int sol1Port, int sol2Port, int compSwitchChannel, int compRelayChannel, int emlRelayChanel, int
            limitSwitch1Channel, int limitSwitch2Channel){
        compressor = new Compressor(compSwitchChannel, compRelayChannel);
        dsol = new DoubleSolenoid(sol1Port, sol2Port);
        spikerelay = new Relay(emlRelayChanel);
        lswitchout = new LimitSwitch(limitSwitch1Channel);
        lswitchin = new LimitSwitch(limitSwitch2Channel);
        
    }
    
    public void start(){
        compressor.start();
        dsol.set(DoubleSolenoid.Value.kOff);
    }
    
    public void stop(){
        dsol.set(DoubleSolenoid.Value.kOff);
        compressor.stop();
        spikerelay.set(Relay.Value.kOff);
    }
    
    public void relayOn(){
        spikerelay.set(Relay.Value.kOn);
    }
    
    public void relayOff(){
        spikerelay.set(Relay.Value.kOff);
    }
    
    public boolean pistonOut(){
        return lswitchout.isTriggered();
    }
    
    public boolean pistonIn(){
        return lswitchin.isTriggered();
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
