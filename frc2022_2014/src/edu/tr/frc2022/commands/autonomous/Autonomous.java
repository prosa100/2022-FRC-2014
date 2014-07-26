/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.commands.autonomous;

import edu.tr.frc2022.RobotMap;
import edu.tr.frc2022.commands.CommandBase;
import edu.tr.frc2022.custom.cyclicArray;
import edu.tr.frc2022.subsystems.HotOMeter;
import edu.tr.frc2022.subsystems.Shooter;
//import edu.tr.frc2022.subsystems.Server;
import edu.wpi.first.wpilibj.command.CommandGroup;
//import edu.tr.frc2022.subsystems.MecanumDrive;
//import edu.tr.frc2022.subsystems.Shooter;

class FireShooter extends CommandBase {

    protected FireShooter() {
        requires(shooter);
    }

    protected void initialize() {
        shooter.fire();
    }

    protected void execute() {
        shooter.doStatus();
    }

    protected boolean isFinished() {
        return shooter.status == Shooter.AtRest || shooter.status == Shooter.Loading || shooter.status == Shooter.Loaded;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
/*
 class LoadShooter extends CommandBase{
    
 }
 */

class LoadShooter extends CommandBase {

    protected LoadShooter() {
        requires(shooter);
    }

    protected void initialize() {
        shooter.load();
    }

    protected void execute() {
        shooter.doStatus();
    }

    protected boolean isFinished() {
        return shooter.status == Shooter.Loaded;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

class RetractLittleArm extends CommandBase{
    protected RetractLittleArm() {
        requires(littleArm);
    }

    protected void initialize() {
        littleArm.raise();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false; //OR: shooter.status == Shooter.AtRest;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}





class LowerLittleArm extends CommandBase{
    protected LowerLittleArm() {
        requires(littleArm);
    }

    protected void initialize() {
        littleArm.lower();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true; //OR: shooter.status == Shooter.AtRest;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

class PrimeShooter extends CommandBase {

    protected PrimeShooter() {
        requires(shooter);
    }

    protected void initialize() {
        shooter.prime();
    }

    protected void execute() {
        shooter.doStatus();
    }

    protected boolean isFinished() {
        return shooter.status == Shooter.Primed;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

/*
 class RetractRetracter extends CommandBase{
 protected RetractRetracter(){
 requires(derpyArm);
 }
 protected void initialize() {
 derpyArm.moveUp();
 }

 protected void execute() {
        
 }

 protected boolean isFinished() {
 return derpyArm;
 }

 protected void end() {
 }

 protected void interrupted() {
 }
 }
 */

/*
public double multDist = 1;

class HotMeter extends CommandBase{
    public WaitUntilHot() {
        requires(hotOMeter);
    }

    protected void initialize() {
        hotOMeter.do = true;
    }

    protected void execute() {
        hotOMeter.doIp();
        speed = hotOMeter.getDistance();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        //hotOMeter.do=false;
    }

    protected void interrupted() {
        
    }
}*/

class WaitUntilHot extends CommandBase {
    private final long duration = 5000;
    private long start;

    public WaitUntilHot() {
        requires(serv);
    }

    protected void initialize() {
        //hotOMeter.do=true;
        start = System.currentTimeMillis();
    }

    protected void execute() {
        //Server.update();
      
    }

    protected boolean isFinished() {
        return serv.fire() || (duration <= System.currentTimeMillis() - start);
    }

    protected void end() {
        //hotOMeter.do=false;
    }

    protected void interrupted() {
        
    }
}

/**
 *
 * @author kevin
 */
public class Autonomous extends CommandGroup {
    public final int autonomousMode = 2;
    public Autonomous() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        //addSequential(new retractRetracter());

      //addParallel(new MoveArmDown(0.2));
      //addParallel(new HotMeter());
        switch (autonomousMode){
            case 1: //no idea.
                addSequential(new WaitUntilHot());
                addParallel(new LoadShooter());
                addSequential(new MoveForward(RobotMap.AutoTimeSecs, RobotMap.AutoSpeed));
                addParallel(new Dispense(3000));
                break;
            case 2://fire into high goal!?!
                
                addParallel(new LowerLittleArm());
                addParallel(new LoadShooter());
                //addSequential(new WaitUntilHot());
                addSequential(new MoveForward(3.5, RobotMap.AutoSpeed));
                addSequential(new WaitUntilHot());
                addParallel(new RetractLittleArm());//needs testing!
                addSequential(new PrimeShooter());
                addSequential(new FireShooter());
                break;
            case 3: //drop ball into lower goal
                addParallel(new LowerLittleArm());
           
                addSequential(new MoveForward(RobotMap.AutoTimeSecs, RobotMap.AutoSpeed));
                addParallel(new Dispense(3000));
        }
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}