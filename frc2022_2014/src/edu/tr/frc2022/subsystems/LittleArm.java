/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.tr.frc2022.commands.LittleArmCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.tr.frc2022.custom.LimitSwitch;

/**
 *
 * @author krosa
 */
public class LittleArm extends Subsystem {

    Jaguar wheelMotor;
    DoubleSolenoid littleArmPiston;
    //LimitSwitch hasBall;
    
    public LittleArm(int wheelMotorPort, int pistonUpPort, int pistonDownPort, int hasBallLimitSwitch) {
        wheelMotor = new Jaguar(wheelMotorPort);
        littleArmPiston = new DoubleSolenoid(pistonUpPort, pistonDownPort);
        //hasBall = new LimitSwitch(hasBallLimitSwitch, "Ball in Possesion");
    }

    double spinSpeed = .8;
    
    /*public boolean ballIsPresent(){
        return hasBall.isState(LimitSwitch.Triggered);
    }*/
    
    public void spinIn() {
        wheelMotor.set(-spinSpeed);
    }
   
    
    public void lower(){
            littleArmPiston.set(DoubleSolenoid.Value.kReverse);
    }

    
    public void raise(){
        littleArmPiston.set(DoubleSolenoid.Value.kForward);
    }
    
    public void stopArm(){
        littleArmPiston.set(DoubleSolenoid.Value.kOff);
    }
    
    public void spinOut() {
        wheelMotor.set(spinSpeed);
    }

    public void spinStop() {
        wheelMotor.set(0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new LittleArmCommand());
    }
}
