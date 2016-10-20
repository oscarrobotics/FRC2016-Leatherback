package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc832.Leatherback.Robot;

/**
 *
 */
public class BallOut extends Command {
    public BallOut() {
        requires(Robot.ballControl);
    }

    protected void initialize() {
    }

    protected void execute() {
    	//if (Robot.bPAD.getBothAverageRPM() > 1000){
    		//Timer.delay(3);
    		Robot.ballControl.setRelay(1);	
    	//}
    	
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
