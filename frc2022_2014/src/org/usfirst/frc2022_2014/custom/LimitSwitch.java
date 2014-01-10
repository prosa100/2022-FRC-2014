/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2022_2014.custom;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author Vjedi729
 */
public class LimitSwitch extends DigitalInput{

    public LimitSwitch(int channel) {
        super(channel);
    }
    public boolean isTriggered(){
        return get();
        }
    }
