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
public class JoystickMecanumDriveController extends CommandBase {
    
    public JoystickMecanumDriveController() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(mecanumDrive);
    }

    //process the input from Xbox controller's left and right thumbsticks for Mecanum
    private void doInput() {
        if (oi.getXbawks().GetTriggers()<-0.5){
        mecanumDrive.set(oi.getXbawks().GetLeftMagnitude()/4, oi.getXbawks().GetLeftAngle(true), oi.getXbawks().GetRightX()/4);
        } else if (oi.getXbawks().GetTriggers()>0.5){
        mecanumDrive.set(oi.getXbawks().GetLeftMagnitude(), oi.getXbawks().GetLeftAngle(true), oi.getXbawks().GetRightX());
        } else {
        mecanumDrive.set(oi.getXbawks().GetLeftMagnitude()/2, oi.getXbawks().GetLeftAngle(true), oi.getXbawks().GetRightX()/2);
        }
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
        mecanumDrive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        mecanumDrive.stop();
    }
}
