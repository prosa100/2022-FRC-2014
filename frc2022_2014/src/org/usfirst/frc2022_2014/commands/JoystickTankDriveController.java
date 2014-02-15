/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022_2014.commands;

/**
 *
 * @author Student
 */
public class JoystickTankDriveController extends CommandBase {
    
    public JoystickTankDriveController() {
        // Use requires() here to declare subsystem dependencies
        //requires(tankDrivebase);
    }

    private void doInput(){
        //tankDrivebase.set(oi.getXbawks().GetLeftY(), oi.getXbawks().GetRightY());
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
        doInput();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        doInput();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.err.println("Who called me?!? They Suck!");
        //tankDrivebase.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        //tankDrivebase.stop();
    }
}
