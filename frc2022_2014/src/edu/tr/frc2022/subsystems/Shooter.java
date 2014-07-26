/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tr.frc2022.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.tr.frc2022.commands.ShooterCommand;

/**
 *
 * @author prosa
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public static final int Unknown = 0,
            Loaded = 1,
            Primed = 2,
            Priming = 3,
            Fireing = 4,
            Loading = 5,
            AtRest = 6;

    public static String getPistonState(int state) {
        switch (state) {
            case Loaded:
                return "Loaded";
            case Primed:
                return "Primed";
            case Priming:
                return "Priming";
            case Fireing:
                return "Fireing";
            case Loading:
                return "Loading";
            case AtRest:
                return "AtRest";
            case Unknown:
            default:
                return "Unknown";
        }
    }

    public Shooter(int relayPort, int solenoidForward, int solenoidReverse) {
        emRelay = new Relay(relayPort);
        doubleSolenoid = new DoubleSolenoid(solenoidForward, solenoidReverse);
    }

    public boolean notReady() {
        return System.currentTimeMillis() < nextFinishTime;
    }

    public int status = Unknown;

    public long nextFinishTime = Long.MIN_VALUE;

    public void doStatus() {
                SmartDashboard.putNumber("Shooter Update", System.currentTimeMillis());

        if (notReady()) {
            return;
        }
        switch (status) {
            case Priming:
                status = Primed;
                takes(NoTime);
                break;
            case Loading:
                status = Loaded;
                takes(NoTime);
                break;
            case Fireing:
                status = AtRest;
                takes(NoTime);
                break;
            case Unknown:
            default:
                break;
        }
        SmartDashboard.putString("Shooter Status", getPistonState(status));
    }

    public static final int Second = 1000;

    private void takes(int duration) {
        nextFinishTime = duration + System.currentTimeMillis();
    }

    public static final int LoadTime = Second,
            PrimeTime = Second,
            FireTime = Second / 2,
            NoTime = -1;

    public void load() {
        if (notReady()) {
            return;
        }
        pistonBack();
        status = Loading;
        takes(LoadTime);
    }

    public void prime() {
        if (notReady() /*|| status != Loaded*/) {
            return;
        }
        emOn();
        pistonForward();
        status = Priming;
        takes(PrimeTime);
    }

    public void fire() {
        if (notReady()) {
            return;
        }
        emOff();
        status = Fireing;
        takes(FireTime);
    }

    public void pistonBack() {
        doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void pistonForward() {
        doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    Relay emRelay;
    DoubleSolenoid doubleSolenoid;

    public void emOn() {
        SmartDashboard.putBoolean("EM", true);
        emRelay.set(Relay.Value.kForward);
    }

    public void emOff() {
        SmartDashboard.putBoolean("EM", false);
        emRelay.set(Relay.Value.kOff);
    }

    public void shutDown() {

    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ShooterCommand());
    }
}