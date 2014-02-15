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
    LimitSwitch retractorLimitSwitchUp;
    LimitSwitch retractorLimitSwitchDown;
    LimitSwitch ballStopLimitSwitch;
    private boolean isDown = false;
    
    public BallCollection(int collectorPort, int retractorPort, int ballLimPort, int downLimPort, int upLimPort) 
    {
        collector = new Jaguar(collectorPort);
        retractor = new Jaguar(retractorPort);
        retractorLimitSwitchUp = new LimitSwitch(upLimPort);
        retractorLimitSwitchDown = new LimitSwitch(downLimPort);
        ballStopLimitSwitch = new LimitSwitch(ballLimPort);
    }
    
    public void moveCollectorUp()
    {
        while(!retractorLimitSwitchUp.isTriggered())
        {
            retractor.set(-RetractorSpeed);
        }
        stopCollector();
        isDown = false;
    }
    
    public void moveCollectorDown()
    {
        while (!retractorLimitSwitchDown.isTriggered())
        {
            retractor.set(RetractorSpeed);
        }
        stopCollector();
        isDown = true;
    }
    
    public void moveRetractor(float speed){
        retractor.set(speed);
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
        if(!ballStopLimitSwitch.isTriggered() && !retractorLimitSwitchUp.isTriggered()){
            collector.set(CollectorSpeed);
        }
    }
    
    public void dispense()
    {
        if(!retractorLimitSwitchUp.isTriggered()){
            collector.set(-CollectorSpeed);
        }
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