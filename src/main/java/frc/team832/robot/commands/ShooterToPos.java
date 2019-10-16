// package frc.team832.robot.commands;

// import edu.wpi.first.wpilibj.command.Command;

// import frc.team832.robot.Robot;
// import frc.team832.robot.RobotMap;

// /**
//  *
//  */
// public class ShooterToPos extends Command {
// 	double shooterPos;
// 	double actualPos = Robot.shooterTilt.getTiltAngle();
// 	boolean isDone;
	
// 	/** 	
// 	 * Class to control the Shooter tilt in a CommandGroup (i.e. during Autonomous).
//      *
//      * The position scale is wonky and doesn't seem to scale to real world units easily.
//      * Keep this in mind and just set positions relative to what the RoboRIO web interface shows.
//      * 
//      * @param pos ~ Tells mechanism Position PID to move to this position
//      * @author Banks T ~btrout.dhrs@gmail.com~
//      */
	
//     public ShooterToPos(double pos) {
//     	requires(Robot.shooterTilt);
//     	this.shooterPos = pos;
//     }

//     protected void initialize() {
//     	isDone = false;
//     	RobotMap.shooterTiltMotors.setSetpoint(shooterPos);
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
