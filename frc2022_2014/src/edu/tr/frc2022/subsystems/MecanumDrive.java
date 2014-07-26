/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.tr.frc2022.commands.MecanumDriveController;

/**
 * @author krosa
 */
public class MecanumDrive extends Subsystem {

    public Jaguar frontRight;
    public Jaguar frontLeft;
    public Jaguar backRight;
    public Jaguar backLeft;

    double motorSpeedMultiplier = .5; //Range is +- .5

    public final double angleOffSet = Math.PI / 4;

    public MecanumDrive(int frontRightPort, int frontLeftPort, int backRightPort, int backLeftPort) {
        frontRight = new Jaguar(frontRightPort);
        frontLeft = new Jaguar(frontLeftPort);
        backLeft = new Jaguar(backLeftPort);
        backRight = new Jaguar(backRightPort);
    }

    public void stop() {
        set(0, 0, 0, 0);
    }

    public double getMotorSpeedMultiplier() {
        return motorSpeedMultiplier;
    }

    public void setMotorSpeedMultiplier(double value) {
        motorSpeedMultiplier = value;
    }

    public void moveForward(double speed) {
        set(speed, speed, speed, speed);
    }
    
    private double limit(double a) {
        if (a > 1) {
            return 1;
        } else if (a < -1) {
            return -1;
        } else {
            return a;
        }
    }
    
    public void set(double fl, double fr, double bl, double br) {
         /*
         SmartDashboard.putNumber("speed", speed);
         SmartDashboard.putNumber("angle", angle);
         SmartDashboard.putNumber("spin", spin);
         */
        /*double v1, v2, v3, v4;
        
         v1 = motorSpeedMultiplier * (speed * (Math.sin(angle + angleOffSet)) + spin);
         v2 = motorSpeedMultiplier * (speed * (Math.cos(angle + angleOffSet)) - spin);
         v3 = motorSpeedMultiplier * (speed * (Math.cos(angle + angleOffSet)) + spin);
         v4 = motorSpeedMultiplier * (speed * (Math.sin(angle + angleOffSet)) - spin);

         double fl, fr, bl, br;
         fl = v1;
         fr = v2;
         bl = v3;
         br = v4;*/

        frontLeft.set(limit(fl));
        frontRight.set(limit(-fr));
        backLeft.set(limit(bl));
        backRight.set(limit(-br));

        SmartDashboard.putNumber("FL", fl);
        SmartDashboard.putNumber("FR", fr);
        SmartDashboard.putNumber("BR", br);
        SmartDashboard.putNumber("BL", bl);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new MecanumDriveController());
    }
}
