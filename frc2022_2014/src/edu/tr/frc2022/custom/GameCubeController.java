/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.custom;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 *
 * @author kevin
 */
public class GameCubeController extends Xbawks {
    public static double deadZone = 0.1;
    
    public double limit(double a){
        return (Math.abs(a) < deadZone)? 0 : a;
    }
    public GameCubeController(int port) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super(port);
    }
           

    // Called just before this Command runs the first time
}
