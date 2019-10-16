package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc832.Leatherback.Robot;
import org.usfirst.frc832.Leatherback.RobotMap;

/**
 *
 */
public class Manual_ShooterTiltUp extends Command {
    public Manual_ShooterTiltUp() {
        requires(Robot.shooterTilt);
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.shooterTiltMotors.set(0.4525);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
