package org.usfirst.frc832.Leatherback.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc832.Leatherback.Robot;
import org.usfirst.frc832.Leatherback.RobotMap;

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
    	RobotMap.ballControlMotor.setDirection(Relay.Direction.kForward);
		RobotMap.ballControlMotor.set(Relay.Value.kOn);	
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
