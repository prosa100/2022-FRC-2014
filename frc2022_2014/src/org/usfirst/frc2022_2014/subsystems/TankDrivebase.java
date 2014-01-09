/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022_2014.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author All of us!
 */
public class TankDrivebase extends Subsystem {

    Jaguar leftMotor, rightMotor;

    public TankDrivebase(int leftMotorPort, int rightMotorPort) {
        leftMotor = new Jaguar(leftMotorPort);
        rightMotor = new Jaguar(rightMotorPort);
    }

    public void set(double leftSpeed, double rightSpeed) {
        if (!isFrontFlipped) {
            leftMotor.set(leftSpeed);
            rightMotor.set(rightSpeed);
        } else {
            leftMotor.set(-rightSpeed);
            rightMotor.set(-leftSpeed);
        }
    }

    public void stop() {
        set(0, 0);
    }

    boolean isFrontFlipped = false;

    public boolean flipFront() {
        //Good code!
        return isFrontFlipped = !isFrontFlipped;
        //no no code
        //return frontFlipped^=true;
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
