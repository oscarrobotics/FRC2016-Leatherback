package org.usfirst.frc832.Leatherback.subsystems;

import org.usfirst.frc832.Leatherback.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Relay;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallControl extends Subsystem {
	double actualSpeed;
	double desiredSpeed;

	private final Relay motor = RobotMap.ballControlMotor;
	private final DigitalInput ballSwitch = RobotMap.ballControlSwitch;
	// private final DigitalOutput ballLEDs = RobotMap.ballControlLEDs;

	public void initDefaultCommand() {
	}

	public void setRelay(int state) {
		switch (state) {
		case 0:
			RobotMap.ballControlMotor.set(Relay.Value.kOff);
		case 1:
			RobotMap.ballControlMotor.setDirection(Relay.Direction.kForward);
			RobotMap.ballControlMotor.set(Relay.Value.kOn);
		case 2:
			RobotMap.ballControlMotor.setDirection(Relay.Direction.kReverse);
			RobotMap.ballControlMotor.set(Relay.Value.kOn);
		}
	}

	public void setLED(int state) {
		switch (state) {
		case 0:
			RobotMap.ballControlLEDs.set(Relay.Value.kOff);
		case 1:
			RobotMap.ballControlLEDs.setDirection(Relay.Direction.kForward);
			RobotMap.ballControlLEDs.set(Relay.Value.kOn);
		}
	}
}
