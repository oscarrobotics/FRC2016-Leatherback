// package frc.team832.robot.commands;

// import edu.wpi.first.wpilibj.command.Command;
// import frc.team832.robot.Robot;
// import frc.team832.robot.RobotMap;

// /**
//  *
//  */
// public class ArmDown extends Command {
//     public ArmDown() {
//     	requires(Robot.arm);
//     }

//     protected void initialize() {
//     }

//     protected void execute() {
//     	RobotMap.armMotor.set(-0.8);
//     }

//     protected boolean isFinished() {
//         return false;
//     }

//     protected void end() {
//     	RobotMap.armMotor.set(0.0);
//     }

//     protected void interrupted() {
//     	end();
//     }
// }
