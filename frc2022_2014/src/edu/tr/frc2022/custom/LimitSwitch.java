package edu.tr.frc2022.custom;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author krosa
 */
public class LimitSwitch extends DigitalInput {
    private static final boolean enabled = false
            ;
    final int m_channel;
    private final String name;
    public static boolean Triggered = true, NotTriggered = false;

    public LimitSwitch(int channel, String name) {
        super(channel);
        m_channel = channel;
        this.name = name;
    }

    public boolean isState(boolean state) {
        boolean down = get();
        SmartDashboard.putBoolean("LS: " + name + "(port " + m_channel +")" , down);
        SmartDashboard.putBoolean("LimitSwitches Enabled", enabled);
        if (enabled)
            return down != state;
        else
            return true;
    }
}