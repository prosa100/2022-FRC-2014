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
class MoveForward extends CommandBase {

    public final int MoveTime;
    public long startTime;
    public final double MoveSpeed;

    protected MoveForward(double moveTimeSeconds, double moveSpeed) {
        MoveTime = (int) (moveTimeSeconds * 1000);
        MoveSpeed = moveSpeed;
        requires(drive);
    }

    protected void initialize() {
        startTime = System.currentTimeMillis();
        drive.moveForward(MoveSpeed);
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
