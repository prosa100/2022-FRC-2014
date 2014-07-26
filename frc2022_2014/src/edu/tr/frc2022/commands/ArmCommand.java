/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.tr.frc2022.custom.Atk3;

/**
 *
 * @author prosa
 */
public class ArmCommand extends CommandBase {

    public ArmCommand() {
        requires(arm);
        SmartDashboard.putNumber("ctor Arm", System.currentTimeMillis());
    }

    protected void initialize() {
        arm.stop();
        SmartDashboard.putNumber("Init Arm", System.currentTimeMillis());
    }

    public final double deadzone = .1;

    protected void execute() {
        //boolean a = oi.getXbawks().GetAValue();
        //boolean b = oi.getXbawks().GetBValue();
        //SmartDashboard.putBoolean("A", a);
        //SmartDashboard.putBoolean("B", b);

        double speed = oi.getJoystick().GetY();
        SmartDashboard.putNumber("Y", speed);
        arm.move(speed);
        
            
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        arm.stop();
    }

    protected void interrupted() {
        arm.stop();
    }

}
