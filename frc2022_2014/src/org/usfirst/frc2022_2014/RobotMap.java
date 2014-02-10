package org.usfirst.frc2022_2014;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // If the port isn't set yet, make it -1
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    public static final int LeftMotorPort = 3;
    public static final int RightMotorPort = 2;
    public static final int ShooterPort = -1;
    public static final int RetractorPort = -1;
    public static final int CollectorPort = -1;
    public static final int SolenoidPort1 = -1;
    public static final int SolenoidPort2 = -1;
    public static final int BackLimitSwitchPort = -1;
    public static final int FrontLimitSwitchPort = -1;
    
    public static final int CompressSwitchChannel = -1;
    public static final int CompressRelayChannel = -1;
    public static final int LockRelayChannel = -1;
    public static final int OutLimitSwitchChannel = -1;
    public static final int InLimitSwitchChannel = -1;
    
    /* For MecanumDrive */
    public static final int FrontRightMotorPort = 1;
    public static final int FrontLeftMotorPort = 4;
    public static final int BackLeftMotorPort = 3;
    public static final int BackRightMotorPort = 2;
    // 
}
