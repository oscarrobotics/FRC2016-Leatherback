package frc.team832.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import frc.team832.robot.subsystems.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {

	Command autonomousCommand;
    CameraServer cam1;   
    
    public static OI oi;
    public static RhinoDrive rhinoDrive;
    // public static BPAD bPAD;
    // public static ShooterTilt shooterTilt;
    // public static BallControl ballControl;
    // public static Arm arm;
    // public static ArmRoller armRoller;
    // public static LightControl lightControl;


    
    public void robotInit() {
    	
        RobotMap.init();
        rhinoDrive = new RhinoDrive();
        // bPAD = new BPAD();
        // shooterTilt = new ShooterTilt();
        // ballControl = new BallControl();
        // arm = new Arm();
        // armRoller = new ArmRoller();
        // lightControl = new LightControl();

        oi = new OI(); // DO NOT MOVE UNDER ANY CIRCUMSTANCES
        
        // autonomousCommand = new AutonomousCommand();
    }
    
    
 // Get data from SmartDashboard for tuning and testing. Comment out references to it during competitiion
    public void getData() { 
    }
    
    public void sendData() {
    	double area = RobotMap.visionTable.getEntry("area").getDouble(-1); // second parameter is -1 to signify no data.
    	double centerX = RobotMap.visionTable.getEntry("centerX").getDouble(-1.0);
    	double centerY = RobotMap.visionTable.getEntry("centerY").getDouble( -1.0);
    	double offsetX = centerX - 319;
    	SmartDashboard.putNumber("centerX", centerX);
    	SmartDashboard.putNumber("centerY", centerY);
    	SmartDashboard.putNumber("area", area);
    	SmartDashboard.putNumber("offsetX", offsetX);
    	// SmartDashboard.putNumber("GyroVal", RobotMap.gyro.getAngle());
    	// SmartDashboard.putNumber("Throttle", Robot.bPAD.getThrottle());
    	// SmartDashboard.putNumber("IntakeRPM", Robot.bPAD.getIntakeRPM());
    	// SmartDashboard.putNumber("OutputRPM", Robot.bPAD.getActualOutputRPM());
    	// SmartDashboard.putNumber("Shooter Tilt Angle", Robot.shooterTilt.getTiltAngle());
    	// SmartDashboard.putNumber("Left Shooter RPM", Robot.bPAD.getLeftRPM());
    	// SmartDashboard.putNumber("Right Shooter RPM", Robot.bPAD.getRightRPM());
    	// SmartDashboard.putNumber("Combined Shooter RPM", Robot.bPAD.getBothAverageRPM());
    	// SmartDashboard.putBoolean("BallSwitch", RobotMap.ballControlSwitch.get());
    }
    
    public void disabledInit() {
    	// Robot.ballControl.setLED(0);
    	// Robot.ballControl.setRelay(0);
    	// Robot.bPAD.stopWheels();
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        sendData();
    }

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
     // test LEDs
        // Robot.ballControl.setLED(1);
        Timer.delay(1);
        // Robot.ballControl.setLED(0);
        
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        sendData();
        // Zero Encoders if they hit the switches
        // if (!RobotMap.shooterTiltMotors.isRevLimitSwitchClosed()) RobotMap.shooterTiltMotors.setEncPosition(0);
    	// if (RobotMap.armMotor.isRevLimitSwitchClosed()) RobotMap.armMotor.setEncPosition(0);
    	// if (RobotMap.ballControlSwitch.get()) {
    		// Robot.ballControl.setRelay(0);
    		// Robot.ballControl.setLED(0);
    	// }
    	// else if (!RobotMap.ballControlSwitch.get()) {
    		// Robot.ballControl.setRelay(2);
    		// Robot.ballControl.setLED(1);
    	// }
    	// if (15 > Robot.bPAD.getRightAmps() || (15 > Robot.bPAD.getLeftAmps())) Robot.bPAD.stopWheels();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }
    
    public void teleopPeriodic() {
    	// if (!RobotMap.shooterTiltMotors.isRevLimitSwitchClosed()) RobotMap.shooterTiltMotors.setEncPosition(0);
    	// if (RobotMap.armMotor.isRevLimitSwitchClosed()) RobotMap.armMotor.setEncPosition(0);
    	// if (RobotMap.ballControlSwitch.get()) {
    		//Robot.ballControl.setRelay(0);
    		// RobotMap.ballControlMotor.set(Relay.Value.kOff);
    		// Robot.ballControl.setLED(1);
    	// }
    	// else if (!RobotMap.ballControlSwitch.get()) {
    		// Robot.ballControl.setRelay(2);
    		// Robot.ballControl.setLED(0);
    	// }
    	// if (15 > Robot.bPAD.getRightAmps() || (15 > Robot.bPAD.getLeftAmps())) Robot.bPAD.stopWheels();
    	Scheduler.getInstance().run();
        sendData();
        /*
        if (Robot.oi.driverPad.getRawButton(1) && centerX != -1) {
        	
        	RobotMap.rhinoDriveLeft1.changeControlMode(TalonSRX.TalonControlMode.Position);
        	RobotMap.rhinoDriveLeft2.changeControlMode(TalonSRX.TalonControlMode.Position);
        	RobotMap.rhinoDriveRight1.changeControlMode(TalonSRX.TalonControlMode.Position);
        	RobotMap.rhinoDriveRight2.changeControlMode(TalonSRX.TalonControlMode.Position);
        	
        	if (offsetX > -4 && offsetX < 4) {
        		Robot.rhinoDrive.stop(); // It's time to STOP
        	} // NO MORE
        	
        	else if (offsetX < -5) {
        		//RobotMap.rhinoDriveLeft1.setSetpoint(RobotMap.rhinoDriveLeft1.getPosition() + driveAdjustment); // Nudge the robot a little to the left
        		//RobotMap.rhinoDriveRight1.setSetpoint(RobotMap.rhinoDriveRight1.getPosition() + driveAdjustment);
        		RobotMap.rhinoDriveTank.tankDrive(0.7, -0.7);
        	}
        	
        	else if(offsetX > 5) { // if centerX is at or above 320 (target to right of center)
        		//RobotMap.rhinoDriveLeft1.setSetpoint(RobotMap.rhinoDriveLeft1.getPosition() - driveAdjustment); // Nudge the robot a little to the right
        		//RobotMap.rhinoDriveRight1.setSetpoint(RobotMap.rhinoDriveRight1.getPosition() - driveAdjustment);
        		RobotMap.rhinoDriveTank.tankDrive(-0.7, 0.7);
        	}
        }
        */
    }
}