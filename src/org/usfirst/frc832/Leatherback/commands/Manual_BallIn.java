package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc832.Leatherback.Robot;

/**
 * Coded  by Banks T <btrout.dhrs@gmail.com>
 */
public class Manual_BallIn extends Command {
    public Manual_BallIn() {
        requires(Robot.ballControl);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.ballControl.setRelay(2);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.ballControl.setRelay(0);
    }

    protected void interrupted() {
    	end();
    }
}
