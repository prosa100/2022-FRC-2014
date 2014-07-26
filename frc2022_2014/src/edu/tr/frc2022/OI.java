
package edu.tr.frc2022;

import edu.tr.frc2022.custom.GameCubeController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.tr.frc2022.custom.Atk3;
import edu.tr.frc2022.custom.Xbawks;
import edu.tr.frc2022.custom.flipper;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**1234yu
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    //Xbawks xbawks = new Xbawks(1);
    GameCubeController driveInput = new GameCubeController(1);
    Xbawks XBoXController = new Xbawks(4);
    
    boolean isGC = true;
    
    Atk3 ShooterJoystick = new Atk3(2, 0.1);
    Atk3 LittleArmJoystick = new Atk3(3, 0.9);
    
    public GameCubeController getdriveInput(){
        return driveInput;
    }
    
    public Atk3 getJoystick(){
        return ShooterJoystick;
    }
    
    public Atk3 getSecondJoystick(){
        return LittleArmJoystick;
    }
    
    public double getRotate(){
        double v = (isGC) ? (driveInput.GetRawAxis(5) + .78) / 1.6 - (driveInput.GetRawAxis(4) + .78) / 1.6 : XBoXController.GetRightX();
        SmartDashboard.putNumber("Rotation Amount:", v);
        
        return v;//return triggers(right adds)
    }
    
    public double getRightY(){
        return (isGC) ? driveInput.getZ() : XBoXController.GetRightY();
    }
    
    public double getStrafe(){
        return (isGC) ? driveInput.getRawAxis(1) : XBoXController.GetLeftX();//return left x
    }
    
    public double getMove(){
        return (isGC) ? -driveInput.getRawAxis(2) : XBoXController.GetLeftY();//retuurn left y
    }
    
    public boolean raiseArm(){ 
        return getJoystick().GetY() > 0;
    }

    public boolean lowerArm(){
        return getJoystick().GetY() < 0;
    }

    public boolean raiseLittleArm(){ 
        return getSecondJoystick().GetY() > 0;
    }

    public boolean lowerLittleArm() {
        return getSecondJoystick().GetY() < 0;
    }
    
    public double getControllerAdjust(){
        return (isGC) ? 1/.8 : 1;
    }

    public boolean spinWheelIn() {
        return getSecondJoystick().getRawButton(1);
    }

    public boolean spinWheelOut() {
        return getSecondJoystick().getRawButton(3);
    }
    
    public boolean primeShooter() {
        return getJoystick().getRawButton(3);
    }
    
    public boolean fireShooter() {
        return getJoystick().getTrigger();
    }
    
    flipper switchDrive = new flipper();
    public boolean switchDrive(){
        return (isGC) ? switchDrive.flip(driveInput.getRawButton(3)) : switchDrive.flip(XBoXController.GetXValue());
    }
    
    public boolean tankDrive(){
        return false;
    }
    
    public boolean mecanumDrive(){
        return false;//driveInput.getRawButton(2);
    }
    
    public boolean customDrive(){
        return false;//driveInput.getRawButton(1);
    }
    
    flipper flipDrive = new flipper();
    public boolean flipDrive() {
        return (isGC) ? flipDrive.flip(driveInput.getRawButton(8)) : flipDrive.flip(XBoXController.GetRightBumperValue());
    }
    
    public double getAdjust(){
        
        double j = 0;
        if(isGC){
            if(driveInput.getRawButton(1))j++;
            if(driveInput.getRawButton(2))j--;
        }
        else{
            if(XBoXController.GetYValue())j++;
            if(XBoXController.GetAValue())j--;
        }
        return j;
    }    
    
    public void updateInputMethod(){
        if(driveInput.getRawButton(10)) isGC = true;
        else if(XBoXController.GetStartValue()) isGC = false;   
    }
    
    
    //// CREATING BUTTONS
// One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}