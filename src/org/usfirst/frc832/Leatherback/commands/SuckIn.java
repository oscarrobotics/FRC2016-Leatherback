package org.usfirst.frc832.Leatherback.commands;

import org.usfirst.frc832.Leatherback.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Coded by Banks T ~btrout.dhrs@gmail.com~
 */
public class SuckIn extends Command {
    public  SuckIn() {
        requires(Robot.bPAD); 
    }

    protected void initialize() {	
    }

    protected void execute() {
    	Robot.bPAD.setToSpeed();
    	double targetSpeed = 7800;
    	Robot.bPAD.setWheelSpeed(targetSpeed, targetSpeed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.bPAD.setToVBus();
    	Robot.bPAD.stopWheels();
    }

    protected void interrupted() {
    	end();
    }
}
