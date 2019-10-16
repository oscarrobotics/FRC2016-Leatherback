package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc832.Leatherback.*;

/**
 *
 */
public class LightToggle extends Command {

	//boolean isDone = false;
	
    public LightToggle() {
        requires(Robot.lightControl);
        
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.lightControl.setRelay(1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.lightControl.setRelay(0);    	
    }

    protected void interrupted() {
    	end();
    }
}
