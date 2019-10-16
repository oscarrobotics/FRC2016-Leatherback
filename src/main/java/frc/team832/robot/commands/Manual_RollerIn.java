// package frc.team832.robot.commands;

// import edu.wpi.first.wpilibj.command.Command;

// import frc.team832.robot.Robot;
// import frc.team832.robot.RobotMap;

// /**
//  *
//  */
// public class Manual_RollerIn extends Command {
//     public Manual_RollerIn() {
//         requires(Robot.shooterTilt);
//     }

//     protected void initialize() {
//     }

//     protected void execute() {
//     	RobotMap.armRollerMotor.set(-1.0);
//     }

//     protected boolean isFinished() {
//         return false;
//     }

//     protected void end() {
//     	RobotMap.armRollerMotor.set(0.0);
//     }

//     protected void interrupted() {
//     	end();
//     }
// }
