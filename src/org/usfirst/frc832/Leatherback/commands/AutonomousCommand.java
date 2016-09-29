package org.usfirst.frc832.Leatherback.commands;

import org.usfirst.frc832.Leatherback.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Coded by Banks T <btrout.dhrs@gmail.com>
 */

public class AutonomousCommand extends CommandGroup {
    public AutonomousCommand() {
    	requires(Robot.arm);
    	requires(Robot.shooterTilt);
    	requires(Robot.rhinoDrive);
    	
    	addSequential(new ArmToPos(0.9, 0.0, .8));
    	//addSequential(new ArmToPos(0.9, 0.0, .3));  30DEG DOWN
    	//addSequential(new Auto_Shooter(0.4));
    	addSequential(new DriveToDistance(0.70, 0.65, 5.2));
    }
}
