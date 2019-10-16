package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc832.Leatherback.Robot;
import org.usfirst.frc832.Leatherback.RobotMap;

/**
 *
 */
public class ArmToPos extends Command {
	boolean isDone;
	double power, startDelay, runTime;
	
    public ArmToPos(double power, double startDelay, double runTime) {
    	requires(Robot.arm);
    	this.power = power;
    	this.startDelay = startDelay;
    	this.runTime = runTime;
    }

    protected void initialize() {
    	isDone = false;
    	Timer.delay(startDelay);
       	RobotMap.armMotor.set(-power);
    	Timer.delay(runTime);
    	isDone = true; 	
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isDone;
    }

    protected void end() {
    	RobotMap.armMotor.set(0.0);
    }

    protected void interrupted() {
    	end();
    }
}
