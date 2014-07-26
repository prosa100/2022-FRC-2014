package edu.tr.frc2022;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.tr.frc2022.custom.Atk3;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    public static final int 
            Arm = 8,
            ArmUpLimitSwitch = 14, //DIO
            ArmDownLimitSwitch = 3, //DIO
            
            //LittleArm = 6, //PWM
            LittleArmWheel = 7, //PWM
            LittleArmPistonUp = 1,//Solenoid
            LittleArmPistonDown = 2,//Solenoid
            HasBallLimitSwitch = 8,
            
            FrontRightWheel = 1, //PWM
            FrontLeftWheel = 4, //PWM
            BackRightWheel = 2,//PWM
            BackLeftWheel = 3,//PWM
            
            ShooterRelay = 3,
            ShooterSolenoidForward = 3, //Solenoid
            ShooterSolenoidBackward = 4, //Solenoid
            
            CompressorGauge = 5, //DIO
            CompressorRealy = 4;      

    public static final double AutoSpeed = .3,
            AutoTimeSecs = 5,
            AutoThrowTimeSecs = 2;
}
