package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc832.Leatherback.Robot;
import org.usfirst.frc832.Leatherback.RobotMap;

/**
 *
 */
public class SpitOut extends Command {
	boolean pidEnabled;
    public SpitOut() {
        requires(Robot.bPAD);
    }

    protected void initialize() {       	
    }

    protected void execute() {
    	//Robot.bPAD.setToVBus();
    	Robot.bPAD.setToSpeed();
        double targetSpeed = -8200;
        Robot.bPAD.setWheelSpeed(targetSpeed, targetSpeed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	//Robot.bPAD.setToVBus();
    	Robot.bPAD.stopWheels();
    }

    protected void interrupted() {
    	end();
    }
}
