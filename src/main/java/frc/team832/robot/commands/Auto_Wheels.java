// package frc.team832.robot.commands;

// import edu.wpi.first.wpilibj.command.Command;
// import frc.team832.robot.Robot;

// /**
//  *
//  */
// public class Auto_Wheels extends Command {
// 	boolean isDone;
// 	int rippems;
	
//     public Auto_Wheels(int rippems) {
//         requires(Robot.bPAD);
//         this.rippems = rippems;
//     }

//     protected void initialize() {
//     	Robot.bPAD.setToSpeed();
//     	isDone = false;
    	
//     	/*if (rippems == 0) {
//     		Robot.bPAD.stopWheels();
//     		isDone = true;
//     	}*/

//     	Robot.bPAD.setWheelSpeed(rippems, rippems);
//     	isDone = true;
//     }

//     protected void execute() {
//     }
   
//     protected boolean isFinished() {
//         return isDone;
//     }

//     protected void end() {
//     }

//     protected void interrupted() {
//     	end();
//     }
// }
