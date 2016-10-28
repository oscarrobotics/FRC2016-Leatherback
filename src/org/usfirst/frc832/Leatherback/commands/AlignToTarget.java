package org.usfirst.frc832.Leatherback.commands;

import org.usfirst.frc832.Leatherback.Robot;
import org.usfirst.frc832.Leatherback.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AlignToTarget extends Command {

	double[] idealValue = {319, 239};
	double centerX = RobotMap.visionTable.getNumber("centerX", -1.0);
	double offsetX = centerX - idealValue[0];
	int driveAdjustment = 500;
	boolean isDone;
    public AlignToTarget() {
        requires(Robot.rhinoDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (centerX == -1) end(); // If we don't have a target lock, quit
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	isDone = false;
    	if(centerX == -1) end(); // If we don't have a target lock, quit
    	/*
    	RobotMap.rhinoDriveLeft1.changeControlMode(CANTalon.TalonControlMode.Position);
    	RobotMap.rhinoDriveLeft2.changeControlMode(CANTalon.TalonControlMode.Position);
    	RobotMap.rhinoDriveRight1.changeControlMode(CANTalon.TalonControlMode.Position);
    	RobotMap.rhinoDriveRight2.changeControlMode(CANTalon.TalonControlMode.Position);
    	*/
    	double angle = RobotMap.gyro.getAngle();
    	
    	// For now I'm just using encoder position to adjust to target, but the best thing to do would be to calculate how many degrees 
    	// off we are from target using the gyro, turn to match that heading. And then if we are below 1 degree, try to fine-tune it
    	// with increasing or decreasing encoder position in very small increments
    	
  
    	
    	if (offsetX < -3) {
    		//RobotMap.rhinoDriveLeft1.setSetpoint(RobotMap.rhinoDriveLeft1.getPosition() + driveAdjustment); // Nudge the robot a little to the left
    		//RobotMap.rhinoDriveRight1.setSetpoint(RobotMap.rhinoDriveRight1.getPosition() + driveAdjustment);
    		RobotMap.rhinoDriveTank.tankDrive(0.7, -0.7);
    	}
    	
    	else if(offsetX > 3) { // if centerX is at or above 320 (target to right of center)
    		//RobotMap.rhinoDriveLeft1.setSetpoint(RobotMap.rhinoDriveLeft1.getPosition() - driveAdjustment); // Nudge the robot a little to the right
    		//RobotMap.rhinoDriveRight1.setSetpoint(RobotMap.rhinoDriveRight1.getPosition() - driveAdjustment);
    		RobotMap.rhinoDriveTank.tankDrive(-0.7, 0.7);
    	}
    	
    	else if (offsetX > - 2 && offsetX < 2) {
    		isDone = true; 
    	}
    	/*
    	// if centerY at or below 239 (target below center), nudge shooter up a bit
    	if(centerY <= 239) RobotMap.shooterTiltMotors.setSetpoint((RobotMap.shooterTiltMotors.getSetpoint() + 0.01) + shooterTiltOffset);
    	// if centerY at or above 240 (target above center), nudge shooter down a bit
    	else if(centerY >= 240) RobotMap.shooterTiltMotors.setSetpoint((RobotMap.shooterTiltMotors.getSetpoint() - 0.01) + shooterTiltOffset);
    	*/
    	//double newHeading = (angle);
    	//if (RobotMap.visionTable.get)
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.rhinoDriveLeft1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	RobotMap.rhinoDriveLeft2.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	RobotMap.rhinoDriveRight1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	RobotMap.rhinoDriveRight2.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	RobotMap.rhinoDriveTank.tankDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
