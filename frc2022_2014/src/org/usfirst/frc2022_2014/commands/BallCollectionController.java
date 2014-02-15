/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022_2014.commands;

import org.usfirst.frc2022_2014.custom.Attack3;

/**
 *
 * @author IMSA
 */
public class BallCollectionController extends CommandBase {
    Attack3 attack = oi.getAttack(); ;
    private boolean isCollecting;
    public BallCollectionController(boolean isCollecting) {
        requires(collector);
        this.isCollecting = isCollecting;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        while(attack.GetY()>0) {collector.moveRetractor((float)0.5);}
        while(attack.GetY()<0) {collector.moveRetractor((float)-0.5);}
        //if(isCollecting) collector.collect();
        //else collector.dispense(); 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        //collector.stopCollector();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        //collector.stopCollector();
    }
}
