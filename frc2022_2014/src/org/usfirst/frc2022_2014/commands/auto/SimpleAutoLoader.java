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
public class SimpleAutoLoader extends CommandBase {
    
    public SimpleAutoLoader() {
        requires(shooter);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //shooter.load();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        /*while(!shooter.isLoaded()){
            shooter.load();
        }*/
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
