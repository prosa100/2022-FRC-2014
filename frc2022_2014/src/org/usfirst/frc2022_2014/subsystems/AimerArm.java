/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2022_2014.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc2022_2014.custom.LimitSwitch;

/**
 *
 * @author Vjedi729
 */
public class AimerArm extends Subsystem{

    Jaguar aimerArmMotor;
    Encoder tiltEncoder;
    LimitSwitch BottomLimitSwitch;
    LimitSwitch TopLimitSwitch;
    
    
    
    public AimerArm(int aimerArmMotorPort){
        aimerArmMotor = new Jaguar(aimerArmMotorPort);
    }
    
    protected void initDefaultCommand() {
        
    }
    public void moveArm(double speed){
        aimerArmMotor.set(speed);
    }    
    public boolean isDown(){
        return BottomLimitSwitch.isTriggered();
    }
    public boolean isUp(){
        return TopLimitSwitch.isTriggered();
    }
    public double getRawAngleOfElevation(){
        return tiltEncoder.getDistance();
    }
}
