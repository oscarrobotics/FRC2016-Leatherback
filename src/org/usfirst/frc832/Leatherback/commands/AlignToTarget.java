package org.usfirst.frc832.Leatherback.commands;

import org.usfirst.frc832.Leatherback.Robot;
import org.usfirst.frc832.Leatherback.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AlignToTarget extends Command {

	int[] vidRes = {640, 480}; // This MUST be set to the same resolution as the USB Webcam plugged in to the Pi
	double centerX = RobotMap.visionTable.getNumber("centerX", -1);
	double centerY = RobotMap.visionTable.getNumber("centerY", -1);
	double offsetFromTargetY = (vidRes[0] - centerY); // Offset in pixels from being centered on target on the Y axis
	double offsetFromTargetX = (vidRes[1] - centerX); // Offset in pixels from being centered on target on the X axis
	double shooterTiltOffset = 0.4; // This needs tuning
	boolean isDebug = true; // make this false for competition runs
	
    public AlignToTarget() {
        requires(Robot.rhinoDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(centerX == -1) end(); // If we don't have a target lock, quit
    	Robot.rhinoDrive.setPositionMode();
    	if(isDebug) {    	
    		SmartDashboard.putNumber("XOffset", offsetFromTargetX);
    		SmartDashboard.putNumber("YOffset", offsetFromTargetY);
    	}
    	double angle = RobotMap.gyro.getAngle();
    	
    	// For now I'm just using encoder position to adjust to target, but the best thing to do would be to calculate how many degrees 
    	// off we are from target using the gyro, turn to match that heading. And then if we are below 1 degree, try to fine-tune it
    	// with increasing or decreasing encoder position in very small increments
    	
    	if(centerX <= 319) { // if centerX is at or below 319 (target to left of center)
    		RobotMap.rhinoDriveLeft1.set(RobotMap.rhinoDriveLeft1.getPosition() + 50); // Nudge the robot a little to the right
    		RobotMap.rhinoDriveRight1.set(RobotMap.rhinoDriveRight1.getPosition() + 50); 
    	}
    	else if(centerX >= 320) { // if centerX is at or above 320 (target to right of center)
    		RobotMap.rhinoDriveLeft1.set(RobotMap.rhinoDriveLeft1.getPosition() - 50); // Nudge the robot a little to the left
    		RobotMap.rhinoDriveRight1.set(RobotMap.rhinoDriveRight1.getPosition() - 50); 
    	}
    	
    	// if centerY at or below 239 (target below center), nudge shooter up a bit
    	if(centerY <= 239) RobotMap.shooterTiltMotors.setSetpoint((RobotMap.shooterTiltMotors.getSetpoint() + 0.01) + shooterTiltOffset);
    	// if centerY at or above 240 (target above center), nudge shooter down a bit
    	else if(centerY >= 240) RobotMap.shooterTiltMotors.setSetpoint((RobotMap.shooterTiltMotors.getSetpoint() - 0.01) + shooterTiltOffset);
    	
    	//double newHeading = (angle);
    	//if (RobotMap.visionTable.get)
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.rhinoDriveLeft1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	RobotMap.rhinoDriveRight1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
