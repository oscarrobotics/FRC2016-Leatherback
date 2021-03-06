package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc832.Leatherback.Robot;

/**
 *
 */
public class driveWithJoysticks extends Command {
    public driveWithJoysticks() {
        requires(Robot.rhinoDrive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.rhinoDrive.takeJoystickInputs(-Robot.oi.driverPad.getRawAxis(1), -Robot.oi.driverPad.getRawAxis(5)); 	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.rhinoDrive.stop();
    }

    protected void interrupted() {
    	end();
    }
}
