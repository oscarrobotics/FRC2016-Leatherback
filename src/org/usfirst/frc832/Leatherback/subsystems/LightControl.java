package org.usfirst.frc832.Leatherback.subsystems;

import org.usfirst.frc832.Leatherback.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LightControl extends Subsystem {

	private final Relay lightControl = RobotMap.lightControl;
	
    public void initDefaultCommand() {
    }
    
    public void setRelay(int state) {
    	if (state == 0) {
    		lightControl.set(Relay.Value.kForward);
    		lightControl.set(Relay.Value.kOff);  		
    	}
    	else if (state == 1) {
    		lightControl.setDirection(Relay.Direction.kForward);
    		lightControl.set(Relay.Value.kOn);
    	}
    }
}

