package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc832.Leatherback.Robot;
import org.usfirst.frc832.Leatherback.RobotMap;

/**
 *
 */
public class Manual_RollerOut extends Command {
    public Manual_RollerOut() {
        requires(Robot.shooterTilt);
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.armRollerMotor.set(1.0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	RobotMap.armRollerMotor.set(0.0);
    }

    protected void interrupted() {
    	end();
    }
}
