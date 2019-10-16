// package frc.team832.robot.commands;

// import frc.team832.robot.Robot;

// import edu.wpi.first.wpilibj.command.Command;

// /**
//  *
//  */
// public class Wheels_VBus extends Command {

//     public Wheels_VBus() {
//     	requires(Robot.bPAD);
//     }

//     // Called just before this Command runs the first time
//     protected void initialize() {
//     }

//     // Called repeatedly when this Command is scheduled to run
//     protected void execute() {
//     	Robot.bPAD.setToVBus();
//     	Robot.bPAD.setWheelSpeed(1.0, 1.0);
//     }

//     // Make this return true when this Command no longer needs to run execute()
//     protected boolean isFinished() {
//         return false;
//     }

//     // Called once after isFinished returns true
//     protected void end() {
//     	Robot.bPAD.setToSpeed();
//     	Robot.bPAD.stopWheels();
//     }

//     // Called when another command which requires one or more of the same
//     // subsystems is scheduled to run
//     protected void interrupted() {
//     	end();
//     }
// }
