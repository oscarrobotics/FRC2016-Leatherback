package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc832.Leatherback.Robot;
import org.usfirst.frc832.Leatherback.RobotMap;

/**
 *
 */
public class Auto_Shooter extends Command {
	double pos;
	boolean isDone;
    public Auto_Shooter(double pos) {
        requires(Robot.shooterTilt);
        this.pos = pos;
    }

    protected void initialize() {
    	isDone = false;
    	RobotMap.shooterTiltMotors.setSetpoint(pos);
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
