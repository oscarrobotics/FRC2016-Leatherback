// package frc.team832.robot.commands;

// import frc.team832.robot.Robot;

// import edu.wpi.first.wpilibj.command.Command;

// /**
//  * Coded by Banks T ~btrout.dhrs@gmail.com~
//  */
// public class SuckIn extends Command {
//     public  SuckIn() {
//         requires(Robot.bPAD); 
//     }

//     protected void initialize() {	
//     }

//     protected void execute() {
//     	Robot.bPAD.setToSpeed();
//     	double targetSpeed = 6500;
//     	Robot.bPAD.setWheelSpeed(targetSpeed, targetSpeed);
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
