/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022_2014.commands.auto;

import org.usfirst.frc2022_2014.commands.CommandBase;

/**
 *
 * @author Michael
 */
public class SimpleAutoAimer extends CommandBase {
    
    public SimpleAutoAimer() {
        //requires(aimArm);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //aimArm.moveArm(Math.PI/4 - aimArm.getRawAngleOfElevation()); //Maybe add to subsystem?
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //aimArm.moveArm(Math.PI/4 - aimArm.getRawAngleOfElevation());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}