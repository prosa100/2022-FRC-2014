/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.tr.frc2022.commands.ArmCommand;
import edu.tr.frc2022.custom.LimitSwitch;

/**
 *
 * @author krosa
 */
public class Arm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Arm(int motor, int topLS, int bottomLS/*, int gyroPort*/) {
        aimerArmMotor = new Jaguar(motor);
        topLimitSwitch = new LimitSwitch(topLS, "Arm Upper");
        bottomLimitSwitch = new LimitSwitch(bottomLS, "Arm Lower");
        //gyro = new GyroScope();
    }

    Jaguar aimerArmMotor;
    LimitSwitch topLimitSwitch;
    LimitSwitch bottomLimitSwitch;
    public final int angleBuffer = 5;
    public double moveSpeed = 0.25;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArmCommand());
    }
    
    /*public double getRotation(){
        return gyro.YAxis();
    }
    
    public void updateRotation(double rot){
        move(PID(rot - getRotation()) / 360);
    }
    
    public double PID(double x){
        return (Math.abs(x) <= angleBuffer) ? 0 : x;
    }*/

    public void stop() {
        showInput();
        move(0);
    }
    
    public void raise() {
        showInput();
        move(-moveSpeed);
    }
    
    public void lower() {
        showInput();
        move(moveSpeed);
    }

    //private boolean bls, tls;
    private void showInput() {
        //bls=bottomLimitSwitch.isTriggered();
        //tls=topLimitSwitch.isTriggered();
        //SmartDashboard.putBoolean("BLS", bls);
        //SmartDashboard.putBoolean("TLS", tls);
        SmartDashboard.putNumber("Get Update Time", System.currentTimeMillis());
        canMoveUp();
        canMoveDown();
    }

    public boolean canMoveUp() {
        return topLimitSwitch.isState(LimitSwitch.NotTriggered);
    }

    public boolean canMoveDown() {
        return bottomLimitSwitch.isState(LimitSwitch.NotTriggered);
    }

    public void move(double power) {
        SmartDashboard.putNumber("Arm Out", power);
        if ((power > 0 && canMoveDown()) || (power < 0 && canMoveUp())) {
            aimerArmMotor.set(power);
        } else {
            aimerArmMotor.set(0);
        }
        showInput();
    }
}