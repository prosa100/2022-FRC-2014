/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.commands.autonomous;

import edu.tr.frc2022.commands.CommandBase;

/**
 *
 * @author krosa
 * @author prosa
 */
class Dispense extends CommandBase {

    public final int MoveTime;
    public long startTime;

    protected Dispense(double moveTimeSeconds) {
        MoveTime = (int) (moveTimeSeconds * 1000);
        requires(littleArm);
    }

    protected void initialize() {
        startTime = System.currentTimeMillis();
        littleArm.spinOut();
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return System.currentTimeMillis() - startTime >= MoveTime;
    }
    

    protected void end() {
        drive.stop();
    }

    protected void interrupted() {
    }

}
