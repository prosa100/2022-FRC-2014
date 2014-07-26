/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.tr.frc2022.RobotMap;
import edu.tr.frc2022.subsystems.LittleArm;
import edu.tr.frc2022.OI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author krosa
 */
public class LittleArmCommand extends CommandBase {

    public LittleArmCommand() {
        requires(littleArm);
    }

    protected void initialize() {
    }

    protected void execute() {   
        if(oi.spinWheelOut()){
            littleArm.spinOut();
        }
        else if(oi.spinWheelIn()){
            littleArm.spinIn();
        }
        else{
            littleArm.spinStop();
        }
        
        if(oi.raiseLittleArm()){
            littleArm.raise();
        }
        else if(oi.lowerLittleArm()){
            littleArm.lower();
        }
        
        /*
        else{
            littleArm.stopArm();
        }
        */        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
