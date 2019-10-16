// package frc.team832.robot.commands;

// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.command.Command;

// import frc.team832.robot.Robot;
// import frc.team832.robot.RobotMap;

// /**
//  *
//  */
// public class DriveToDistance extends Command {
// 	boolean isDone;
// 	double power, runTime, startDelay, distanceDiffLeft, distanceDiffRight, distance;

	
//     public DriveToDistance(double power, double startDelay, double runTime) {
//     	requires(Robot.arm);
//     	this.power = power;
//     	this.runTime = runTime;
//     	this.startDelay = startDelay;
//     }

//     protected void initialize() {
//     	isDone = false;
//     	Timer.delay(startDelay);
//     	Robot.rhinoDrive.driveManual(power, power);
//     	Timer.delay(runTime);
//     	isDone = true;
//     }

//     protected void execute() {
//     	distanceDiffLeft = RobotMap.rhinoDriveLeft1.getEncPosition() - distance;
//     	distanceDiffRight = RobotMap.rhinoDriveRight1.getEncPosition() - distance;
//     	//Robot.rhinoDrive.driveManual(distanceDiffLeft, distanceDiffRight);
//     }

//     protected boolean isFinished() {
//         return isDone;
//     }

//     protected void end() {
//     	Robot.rhinoDrive.stop();
//     }

//     protected void interrupted() {
//     	end();
//     }
// }
