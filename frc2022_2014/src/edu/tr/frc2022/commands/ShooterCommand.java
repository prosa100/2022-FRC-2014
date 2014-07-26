
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.tr.frc2022.subsystems.Shooter;
import edu.tr.frc2022.RobotMap;

/**
 *
 * @author brosa
 */
public class ShooterCommand extends CommandBase {
    
    public ShooterCommand() {
        requires(shooter);
    }
    
    protected void initialize() {
        shooter.load();
    }
    
    protected void execute() {
                SmartDashboard.putNumber("do status", System.currentTimeMillis());

        shooter.doStatus();
        switch (shooter.status) {
            case Shooter.AtRest:
                //if (oi.getJoystick().getRawButton(RobotMap.LoadShooter))
                    shooter.load();
                break;
            case Shooter.Loaded:
                if (oi.primeShooter()) {
                    shooter.prime();
                }
                break;
            case Shooter.Primed:
                if (oi.fireShooter()) {
                    shooter.fire();
                }
                break;
            default:
                break;
        }

        /*if (oi.getXbawks().GetRightBumperValue()) {
         shooter.emOn();
         } else {
         shooter.emOff();
         }*/
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
        shooter.shutDown();
    }
    
    protected void interrupted() {
        shooter.shutDown();
    }
}