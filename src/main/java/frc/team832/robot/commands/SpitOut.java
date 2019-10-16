// package frc.team832.robot.commands;

// import edu.wpi.first.wpilibj.command.Command;
// import frc.team832.robot.Robot;

// /**
//  *
//  */
// public class SpitOut extends Command {
// 	boolean pidEnabled;
//     public SpitOut() {
//         requires(Robot.bPAD);
//     }

//     protected void initialize() {       	
//     }

//     protected void execute() {
//     	//Robot.bPAD.setToVBus();
//     	Robot.bPAD.setToSpeed();
//         double targetSpeed = -8500;
//         Robot.bPAD.setWheelSpeed(targetSpeed, targetSpeed);
//     }

//     protected boolean isFinished() {
//         return false;
//     }

//     protected void end() {
//     	Robot.bPAD.setToVBus();
//     	Robot.bPAD.stopWheels();
//     }

//     protected void interrupted() {
//     	end();
//     }
// }
