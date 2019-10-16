package frc.team832.robot.subsystems;

import frc.team832.robot.RobotMap;
import frc.team832.robot.commands.driveWithJoysticks;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class RhinoDrive extends Subsystem {
    private final WPI_TalonSRX left1 = RobotMap.rhinoDriveLeft1;
    private final WPI_TalonSRX right1 = RobotMap.rhinoDriveRight1;
    private final WPI_TalonSRX left2 = RobotMap.rhinoDriveLeft2;
    private final WPI_TalonSRX right2 = RobotMap.rhinoDriveRight2;
    
    private final DifferentialDrive tank = RobotMap.rhinoDriveTank;

    public void initDefaultCommand() {
        setDefaultCommand(new driveWithJoysticks());
    }
    
    public void driveManual(double left, double right) {
    	tank.tankDrive(left, right);
    }
    
    public void takeJoystickInputs(double left, double right) {
    	tank.tankDrive(left, right);
    }

    public void stop() {
		tank.stopMotor();
	}
}

