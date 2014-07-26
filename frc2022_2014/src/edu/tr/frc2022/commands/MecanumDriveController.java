package edu.tr.frc2022.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author krosa
 */
public class MecanumDriveController extends CommandBase {

    private final double deadZone = 0.1,
            normal = 0.5,
            mag = 2;

    public MecanumDriveController() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
    }

    public double clamp(double entity) {
        return (Math.abs(entity) < deadZone) ? 0 : entity;
    }

    boolean done = false;
    boolean flip = false;

    //process the input from Xbox controller's left and right thumbsticks for Mecanum
    private double limit(double a) {
        if (a > 1) {
            return 1;
        } else if (a < -1) {
            return -1;
        } else {
            return a;
        }
    }

    private void doInput() {
        //double speed = clamp(oi.getXbawks().GetLeftMagnitude());
        //double spin = clamp(oi.getXbawks().GetRightX());
        if (oi.flipDrive()) {
            flip ^= true;
        }

        if(oi.switchDrive()){
            mode = ++mode % 2;
        }
        
        /*if (oi.mecanumDrive()) {
            mode = 1;//mecanum
        } else if (oi.customDrive()) {
            mode = 2;//kDrive//custom hybird
        } else if (oi.tankDrive()) {
            mode = 3;//tankdrive 
        }*/
        double xly = oi.getMove();//oi.getLeftY();
        double xlx = oi.getStrafe();//oi.getLeftX();
        double xt = oi.getRotate();
        double xry = oi.getRightY();

//double xrx = -1;//oi.getRightX();
        //double xry = -1;//oi.getRightY();
//double xlm = oi.getXbawks().GetLeftMagnitude();
        //double xrm = oi.getXbawks().GetRightMagnitude();
        
        //double xra = oi.getXbawks().GetRightAngle(false);
        
        double fl = 0, fr = 0, br = 0, bl = 0;
        double GCComp = oi.getControllerAdjust();//deal
        //mode=2;+
        final double aaR = 0.75;//ie 75%%
        
        SmartDashboard.putNumber("Mode", mode);
        SmartDashboard.putBoolean("flip", flip);
        double adjust = limit(normal * pow(mag, oi.getAdjust()));
        //final double scalar = 1;//pow(2, .5);
        switch (mode) {
            case 0:
                double rot = (1 - aaR) * xt;
                /*fl = aaR * ((xly + xlx) / scalar) + rot;
                fr = aaR * ((xly - xlx) / scalar) - rot;
                bl = aaR * ((xly - xlx) / scalar) + rot;
                br = aaR * ((xly + xlx) / scalar) - rot;*/
                fl = GCComp * (aaR * ((xly + xlx)) + rot);
                fr = GCComp * (aaR * ((xly - xlx)) - rot);
                bl = GCComp * (aaR * ((xly - xlx)) + rot);
                br = GCComp * (aaR * ((xly + xlx)) - rot);
                
                break;
        
            case 1:

           // case 2:
               // double s = (xlx + xrx) / 2;
                //fl = (xly + s) / 2;
               // fr = (xry - s) / 2;
               // bl = (xly - s) / 2;
               // br = (xry + s) / 2;
           //     break;
            /*case 4:
                double v1,
                 v2,
                 v3,
                 v4;
                
                double motorSpeedMultiplier = .5;
                double angleOffSet = Math.PI / 4;
                double angle = xra;
                double speed = xrm;
                double spin = xlx;
                v1 = motorSpeedMultiplier * (speed * (Math.sin(angle + angleOffSet)) + spin);
                v2 = motorSpeedMultiplier * (speed * (Math.cos(angle + angleOffSet)) - spin);
                v3 = motorSpeedMultiplier * (speed * (Math.cos(angle + angleOffSet)) + spin);
                v4 = motorSpeedMultiplier * (speed * (Math.sin(angle + angleOffSet)) - spin);

                fl = v1;
                fr = v2;
                bl = v3;
                br = v4;*/
           // case 3:
        
                bl = fl = xly;
                br = fr = xry;
                break;
    }
               
        

        //if(oi.getXbawks().isYTapped())
        //mecanum ^= true;
        
        SmartDashboard.putNumber("adjust", adjust);
        
        drive.set(adjust * (flip ? -br : fl), adjust * (flip ? -bl : fr), adjust * (flip ? -fr : bl), adjust * (flip? -fl : br));
    }
    public int mode = 0;

    public double pow(final double a, final double b) {
        final int x = (int) (Double.doubleToLongBits(a) >> 32);
        final int y = (int) (b * (x - 1072632447) + 1072632447);
        return Double.longBitsToDouble(((long) y) << 32);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        doInput();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        doInput();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        drive.stop();
    }
}