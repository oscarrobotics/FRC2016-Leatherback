package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc832.Leatherback.Robot;
import org.usfirst.frc832.Leatherback.RobotMap;

/**
 *
 */
public class Manual_ShooterTiltDown extends Command {
    public Manual_ShooterTiltDown() {
        requires(Robot.shooterTilt);
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.shooterTiltMotors.setSetpoint(-0.5);
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
