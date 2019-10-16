package org.usfirst.frc832.Leatherback.commands;

import org.usfirst.frc832.Leatherback.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Coded by Banks T <btrout.dhrs@gmail.com>
 */
public class FullBallIn extends CommandGroup {
	
	
    public  FullBallIn() {
    	requires(Robot.bPAD);
    	requires(Robot.armRoller);
    	requires(Robot.ballControl);
    	requires(Robot.shooterTilt);
    	
    	addSequential(new ShooterToPos(-0.05));
    	Timer.delay(1.25);
    	addParallel(new Manual_RollerIn());
    	addSequential(new SuckIn());
    	//addSequential(new Auto_BallIn());
    }
}
