package edu.tr.frc2022.commands;

import edu.tr.frc2022.subsystems.LittleArm;
import edu.tr.frc2022.subsystems.Arm;
import edu.tr.frc2022.subsystems.MecanumDrive;
import edu.tr.frc2022.subsystems.Shooter;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.tr.frc2022.OI;
import edu.tr.frc2022.RobotMap;
import edu.tr.frc2022.subsystems.HotOMeter;
import edu.tr.frc2022.subsystems.Server;
import edu.wpi.first.wpilibj.Compressor;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author brosa
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Arm arm = new Arm(RobotMap.Arm, RobotMap.ArmUpLimitSwitch, RobotMap.ArmDownLimitSwitch/*, RobotMap.ArmGyro*/);
    public static LittleArm littleArm = new LittleArm(RobotMap.LittleArmWheel, RobotMap.LittleArmPistonUp, RobotMap.LittleArmPistonDown, RobotMap.HasBallLimitSwitch);
    public static MecanumDrive drive = new MecanumDrive(RobotMap.FrontRightWheel, RobotMap.FrontLeftWheel, RobotMap.BackRightWheel, RobotMap.BackLeftWheel);
    public static Shooter shooter = new Shooter(RobotMap.ShooterRelay, RobotMap.ShooterSolenoidForward, RobotMap.ShooterSolenoidBackward);
    public static Compressor autoCompressor = new Compressor(RobotMap.CompressorGauge, RobotMap.CompressorRealy);
    //public static TestGC test = new TestGC();
    public static Server serv = new Server();
    public static HotOMeter hotOMeter = new HotOMeter();
    
    public static updateInput UI = new updateInput();
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
      //  test.start();
        UI.start();
        autoCompressor.start();
        // Show what command your subsystem is running on the SmartDashboard
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
