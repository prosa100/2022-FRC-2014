/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022_2014.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Vjedi729
 * Necessary lines in RobotMap and Command Base are commented out.
*/
public class MecanumDrive extends Subsystem {

    Jaguar frontRight;
    Jaguar frontLeft;
    Jaguar backRight;
    Jaguar backLeft;

    public MecanumDrive(int frontRightPort, int frontLeftPort, int backRightPort, int backLeftPort) {
        frontRight = new Jaguar(frontRightPort);
        frontLeft = new Jaguar(frontLeftPort);
        backLeft = new Jaguar(backLeftPort);
        backRight = new Jaguar(backRightPort);
    }

    public void stop() {
        set(0, 0, 0);
    }
    
    public void set(double speed, double angle, double spin) {
        frontLeft.set(speed*(Math.sin(angle+(Math.PI/4)))+spin);
        frontRight.set(speed*(Math.cos(angle+(Math.PI/4)))-spin);
        backRight.set(speed*(Math.sin(angle+(Math.PI/4)))-spin);
        backLeft.set(speed*(Math.cos(angle+(Math.PI/4)))+spin);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}