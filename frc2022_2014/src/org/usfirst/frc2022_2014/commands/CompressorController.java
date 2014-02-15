package org.usfirst.frc2022_2014.commands;

/**
 * 
1) Turn back solenoid
2) Turn on electromagnet (relay)
3) Wait until fully back (limit switch)
4) Turn forward solenoid

The two subsystems for the pinball shooter and the compressor should be merged
 * 
 * @author Emma
 */
public class CompressorController extends CommandBase {
    
    public CompressorController(){
        //requires(compressor);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //compressor.relayOn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //compressor.backwardSolenoid();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        /*if(compressor.pistonOut()){
            compressor.forwardSolenoid();
            compressor.stop();
            }*/
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        //compressor.stop();
    }
}
