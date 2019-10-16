// package frc.team832.robot.commands;

// import frc.team832.robot.Robot;

// import edu.wpi.first.wpilibj.command.CommandGroup;

// /**
//  * Coded by Banks T <btrout.dhrs@gmail.com>
//  */
// public class FullBallOut extends CommandGroup {
	
	
//     public  FullBallOut() {
//     	requires(Robot.bPAD);
//     	requires(Robot.armRoller);
//     	requires(Robot.ballControl);
//     	requires(Robot.shooterTilt);
//     	requires(Robot.lightControl); 
    	
//     	addSequential(new ShooterToPos(0.6));						// Move shooter to dialed position
//     	//addSequential(new Auto_Light(true)); 						// Set light to ON
//     	//if (Robot.bPAD.getMode())
//     	addSequential(new Auto_Wheels(3000));	// Set wheels spinning at OutputRPM (SHOULD BE 9000)
//     	//else if (!Robot.bPAD.getMode()) {
//     	//	Robot.bPAD.setWheelSpeed(1.0, 1.0);
//     	//}
//     }
// }
