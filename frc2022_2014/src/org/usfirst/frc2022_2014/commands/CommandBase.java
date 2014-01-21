package org.usfirst.frc2022_2014.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2022_2014.OI;
import org.usfirst.frc2022_2014.RobotMap;
import org.usfirst.frc2022_2014.subsystems.ExampleSubsystem;
import org.usfirst.frc2022_2014.subsystems.PinballShooter;
import org.usfirst.frc2022_2014.subsystems.TankDrivebase;
import org.usfirst.frc2022_2014.subsystems.BallCollection;
import org.usfirst.frc2022_2014.subsystems.CompressorSubsystem;
import org.usfirst.frc2022_2014.subsystems.MecanumDrive;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static TankDrivebase tankDrivebase = new TankDrivebase(RobotMap.LeftMotorPort, RobotMap.RightMotorPort);
    public static PinballShooter shooter = new PinballShooter(RobotMap.ShooterPort);
    public static BallCollection collector = new BallCollection(RobotMap.CollectorPort,RobotMap.RetractorPort, RobotMap.BackLimitSwitchPort, RobotMap.FrontLimitSwitchPort);
    public static CompressorSubsystem compressor = new CompressorSubsystem(RobotMap.SolenoidPort1, RobotMap.SolenoidPort1, RobotMap.CompressSwitchChannel, RobotMap.CompressRelayChannel,RobotMap.LockRelayChannel, RobotMap.OutLimitSwitchChannel, RobotMap.InLimitSwitchChannel);
    public static MecanumDrive mecanumDrive = new MecanumDrive(RobotMap.FrontLeftMotorPort, RobotMap.FrontRightMotorPort, RobotMap.BackLeftMotorPort, RobotMap.BackRightMotorPort);
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        
        compressor.start();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
