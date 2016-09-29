package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc832.Leatherback.Robot;
import org.usfirst.frc832.Leatherback.RobotMap;

/**
 *
 */
public class ArmUp extends Command {
    public ArmUp() {
    	requires(Robot.arm);
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.armMotor.set(0.55);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	RobotMap.armMotor.set(0.0);
    }

    protected void interrupted() {
    	end();
    }
}
