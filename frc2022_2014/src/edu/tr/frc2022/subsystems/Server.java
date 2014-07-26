/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.subsystems;

import com.sun.squawk.io.BufferedReader;
import edu.wpi.first.wpilibj.command.Subsystem;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.io.Connection;
import javax.microedition.io.Connector;
/**
 *
 * @author kevin
 */
 

public class Server extends Subsystem {
    
    public boolean fire(){
        try {
            DataInputStream is = Connector.openDataInputStream("http://80");
            return is.readBoolean();
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
