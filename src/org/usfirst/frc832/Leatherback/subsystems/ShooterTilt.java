package org.usfirst.frc832.Leatherback.subsystems;

import org.usfirst.frc832.Leatherback.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterTilt extends Subsystem {
	double tiltAngle;
	
    private final CANTalon motors = RobotMap.shooterTiltMotors;

    public double getTiltAngle() {
    	double tiltAngle = motors.getEncPosition();
    	return tiltAngle;
    }
    
    public void initDefaultCommand() {
    }
}

