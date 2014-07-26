/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.commands.autonomous;

import edu.tr.frc2022.commands.CommandBase;

/**
 *
 * @author brosa
 */
public class MoveArmDown extends CommandBase {
    public final double MoveSpeed;
    
    public MoveArmDown(double moveSpeed) {
        MoveSpeed = moveSpeed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        arm.move(MoveSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !arm.canMoveDown();
    }

    // Called once after isFinished returns true
    protected void end() {
        arm.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
