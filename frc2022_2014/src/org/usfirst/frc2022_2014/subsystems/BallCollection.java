package org.usfirst.frc2022_2014.subsystems;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2022_2014.commands.JoystickTankDriveController;
import org.usfirst.frc2022_2014.custom.LimitSwitch;

public class BallCollection extends Subsystem
{
    Jaguar collector, retractor;
    private final double RetractorSpeed = 0.5;
    private final double CollectorSpeed = 1;
    LimitSwitch backLimitSwitch;
    LimitSwitch frontLimitSwitch;
    private boolean isDown = false;
    
    public BallCollection(int collectorPort, int retractorPort, int backLimitSwitchPort, int frontLimitSwitchPort) 
    {
        collector = new Jaguar(collectorPort);
        retractor = new Jaguar(retractorPort);
        frontLimitSwitch = new LimitSwitch(frontLimitSwitchPort);
        backLimitSwitch = new LimitSwitch(backLimitSwitchPort);
    }
    
    public void moveCollectorUp()
    {
        while(!backLimitSwitch.isTriggered())
        {
            retractor.set(-RetractorSpeed);
        }
        stopCollector();
        isDown = false;
    }
    
    public void moveCollectorDown()
    {
        while (!backLimitSwitch.isTriggered())
        {
            retractor.set(RetractorSpeed);
        }
        stopCollector();
        isDown = true;
    }
    
    public void stopRetractor()
    {
        retractor.set(0);
    }
    
    public void stopCollector()
    {
        collector.set(0);
    } 
    
    public void collect()
    {
        collector.set(CollectorSpeed);
    }
    
    public void dispense()
    {
        collector.set(-CollectorSpeed);
    }

    public boolean isDown()
    {
        return isDown;
    }
    
    public void initDefaultCommand() 
    {
        //setDefaultCommand(new JoystickTankDriveController());
    }
}