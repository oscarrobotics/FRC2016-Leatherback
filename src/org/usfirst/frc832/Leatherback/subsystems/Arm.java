package org.usfirst.frc832.Leatherback.subsystems;

import org.usfirst.frc832.Leatherback.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Arm extends Subsystem {
    private final CANTalon motor = RobotMap.armMotor;

    public void initDefaultCommand() {
    }
}

