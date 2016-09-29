package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc832.Leatherback.*;

/**
 *
 */
public class Auto_Light_On extends Command {

	boolean isDone = false;
	boolean isOn;
	
    public Auto_Light_On() {
        requires(Robot.lightControl);
    }

    protected void initialize() {
    	isDone = false;
    	Robot.lightControl.setRelay(1);
    	isDone = true;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isDone;
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
