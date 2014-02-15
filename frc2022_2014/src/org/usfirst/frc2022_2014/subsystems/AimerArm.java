/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2022_2014.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc2022_2014.RobotMap;
import org.usfirst.frc2022_2014.custom.LimitSwitch;

/**
 *
 * @author Vjedi729
 */
public class AimerArm extends PIDSubsystem{

    Jaguar aimerArmMotor;
    Encoder tiltEncoder;
    LimitSwitch BottomLimitSwitch;
    LimitSwitch TopLimitSwitch;
    //double targetAngle;
    double offset;
    
      /**
     * Set proportion for PID to ???
     */
    private static final double Kp = 0.318;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    public AimerArm(int aimerArmMotorPort){
        super("AimerArm", Kp, Ki, Kd);
        aimerArmMotor = new Jaguar(aimerArmMotorPort);
    }
    
    protected void initDefaultCommand() {
        
    }
    
    ///PID commands
    
     protected double returnPIDInput() {

        return tiltEncoder.getDistance()+offset;
    }
    
    
    protected void usePIDOutput(double output) {


        /**
         * If else statement to set inputs for Jaguar between 1 and -1 if if
         * under or over that range
         */
        if (output > 1) {
            output = 1;
        } else if (output < -1) {
            output = -1;

        }
        /**
         * sets output for the Jaguar movement
         */
        aimerArmMotor.set(output);

    }
    
        /**
     * Set state of PID Loop
     *
     * @param pid Whether to enable PID loop or not
     */
    public void usePID(boolean pid) {
        if (pid) {
            this.enable();
        } else {
            this.disable();
        }
    }
    

    /// Mechanical function: no PID Loop
    
    public void moveArmUp(){
        while(!TopLimitSwitch.isTriggered()){
            moveArm(.5);
        }
    }
    
    public void moveArmDown(){
        while(!TopLimitSwitch.isTriggered()){
            moveArm(-.5);
        }
    }
    
    public void moveArm(double speed){
        this.usePID(false);
        aimerArmMotor.set(speed);
}    
    public boolean isDown(){
        offset=0-tiltEncoder.getDistance();
        return BottomLimitSwitch.isTriggered();
    }
    public boolean isUp(){
        offset=RobotMap.TopEncoderAngle-tiltEncoder.getDistance();
        return TopLimitSwitch.isTriggered();
    }
    public double getRawAngleOfElevation(){
        return tiltEncoder.getDistance();
    }
}
