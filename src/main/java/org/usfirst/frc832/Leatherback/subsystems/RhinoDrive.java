package org.usfirst.frc832.Leatherback.subsystems;

import org.usfirst.frc832.Leatherback.RobotMap;
import org.usfirst.frc832.Leatherback.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class RhinoDrive extends Subsystem {
    private final PowerDistributionPanel pDP = RobotMap.rhinoDrivePDP;
    private final CANTalon left1 = RobotMap.rhinoDriveLeft1;
    private final CANTalon right1 = RobotMap.rhinoDriveRight1;
    private final RobotDrive tank = RobotMap.rhinoDriveTank;
    private final CANTalon left2 = RobotMap.rhinoDriveLeft2;
    private final CANTalon right2 = RobotMap.rhinoDriveRight2;

    public void initDefaultCommand() {
        setDefaultCommand(new driveWithJoysticks());
    }
    
    public void driveManual(double left, double right) {
    	tank.tankDrive(left, right);
    }
    
    public void takeJoystickInputs(double left, double right) {
    	tank.tankDrive(left, right);
    }
    
    public void setSetpoint(double left, double right) {
    	left1.setSetpoint(left);
    	right1.setSetpoint(-right);
    }
    
    public void setPositionMode() {
    	left1.changeControlMode(CANTalon.TalonControlMode.Position);
    	right1.changeControlMode(CANTalon.TalonControlMode.Position);
    }
    
    public void setVbusMode() {
    	left1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	right1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    }
    
    public void stop() {
		tank.drive(0,0);
	}
}

