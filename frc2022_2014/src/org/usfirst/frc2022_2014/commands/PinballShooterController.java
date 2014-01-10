/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022_2014.commands;

/**
 *
 * @author Imsa Student
 */
public class PinballShooterController extends CommandBase {
    
    private boolean isFired = false;
    
    public PinballShooterController() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooter.fire();
        isFired = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFired;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}