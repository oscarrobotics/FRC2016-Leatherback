package org.usfirst.frc832.Leatherback;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

// !!!!!!!!  IF SHIT GOES BONKERS, RE-ADD LIVE WINDOW STUFF !!!!!!!!!!

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static PowerDistributionPanel rhinoDrivePDP;
    public static CANTalon rhinoDriveLeft1;
    public static CANTalon rhinoDriveRight1;
    public static CANTalon armMotor;
    public static CANTalon rhinoDriveLeft2;
    public static CANTalon rhinoDriveRight2;
    public static CANTalon bPADRightWheel;
    public static CANTalon bPADLeftWheel;
    public static CANTalon shooterTiltMotors;
    public static RobotDrive rhinoDrivetank;
    public static Relay lightControl;
    public static Relay ballControlMotor;
    public static DigitalInput ballControlSwitch;
    public static Relay ballControlLEDs;
    public static SpeedController armRollerMotor;

    public static void init() {
    	//DO NOT CHANGE VALUES BETWEEN THESE COMMENTS <
    	/*
        double fShooter = 0.013623046875; 		// Feed-forward gain
    	double pShooter = 0.284;				// P for Shooter PID
    	double iShooter = 0;					// I for Shooter PID
    	double dShooter = 0;					// D for Shooter PID
    	*/
    	double rampRateShooter = 50;				// Ramp rate for Shooter PID
    	//DO NOT CHANGE VALUES BETWEEN THESE COMMENTS >
    	double rampRate = 70;					// Ramp rate for DriveTrain
    	
        rhinoDrivePDP = new PowerDistributionPanel(0);
        
        rhinoDriveLeft1 = new CANTalon(5);
        rhinoDriveRight1 = new CANTalon(6);
        rhinoDriveLeft2 = new CANTalon(7);
        rhinoDriveRight2 = new CANTalon(4);
        bPADRightWheel = new CANTalon(9);
        bPADLeftWheel = new CANTalon(8);
        shooterTiltMotors = new CANTalon(10);
        armMotor = new CANTalon(1);
        
        rhinoDrivetank = new RobotDrive(rhinoDriveLeft1, rhinoDriveRight1);
        rhinoDrivetank.setSafetyEnabled(false);
        rhinoDrivetank.setExpiration(0.1);
        rhinoDrivetank.setSensitivity(0.5);
        rhinoDrivetank.setMaxOutput(1.0);
        
        ballControlMotor = new Relay(0);
        ballControlLEDs = new Relay(2);
        ballControlSwitch = new DigitalInput(1);
        
        armRollerMotor = new Talon(0);
        lightControl = new Relay(1);
        
        // Shooter encoder and PID settings
    	bPADLeftWheel.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	bPADLeftWheel.reverseSensor(false);
    	bPADLeftWheel.configNominalOutputVoltage(+0.0f, -0.0f);
    	bPADLeftWheel.configPeakOutputVoltage(+12.0f, -12.0f);
    	//bPADLeftWheel.setP(pShooter);
    	//bPADLeftWheel.setF(fShooter);
    	bPADLeftWheel.setCloseLoopRampRate(rampRateShooter);
    	bPADRightWheel.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	bPADRightWheel.reverseSensor(false);
    	bPADRightWheel.configNominalOutputVoltage(+0.0f,  -0.0f);
    	bPADLeftWheel.configPeakOutputVoltage(+12.0f, -12.0f);
    	//bPADRightWheel.setP(pShooter);
    	//bPADRightWheel.setF(fShooter);
    	bPADLeftWheel.setCloseLoopRampRate(rampRateShooter);
    	
    	// Shooter Tilting PID settings
    	shooterTiltMotors.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	if (!shooterTiltMotors.isRevLimitSwitchClosed()) shooterTiltMotors.setEncPosition(0);
    	shooterTiltMotors.changeControlMode(CANTalon.TalonControlMode.Position);
    	shooterTiltMotors.reverseSensor(false);
    	shooterTiltMotors.setAllowableClosedLoopErr(30);
    	shooterTiltMotors.configNominalOutputVoltage(+0.0f, -0.0f);
    	shooterTiltMotors.configPeakOutputVoltage(+12.0f, -12.0f);
    	    	
    	rhinoDriveLeft1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	rhinoDriveLeft1.reverseSensor(false);
    	rhinoDriveLeft1.configNominalOutputVoltage(+0.0f, -0.0f);
    	rhinoDriveLeft1.configPeakOutputVoltage(+12.0f, -12.0f);
    	//rhinoDriveLeft1.setPID(p, i, d);
    	//rhinoDriveLeft1.setF(f);
    	//rhinoDriveLeft1.setCloseLoopRampRate(rampRate);
    	
        // Drive Follower code
        rhinoDriveRight2.changeControlMode(CANTalon.TalonControlMode.Follower);
        rhinoDriveRight2.set(rhinoDriveRight1.getDeviceID());
        rhinoDriveLeft2.changeControlMode(CANTalon.TalonControlMode.Follower);
        rhinoDriveLeft2.set(rhinoDriveLeft1.getDeviceID());
        
        // Arm PID settings
        armMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        armMotor.reverseSensor(false);
        armMotor.setAllowableClosedLoopErr(30);
        armMotor.configNominalOutputVoltage(+0.0f, -0.0f);
        armMotor.configPeakOutputVoltage(+12.0f, -12.0f);
        
        // ramp-ups
        rampRate = rampRate * rampRate * rampRate;
        rhinoDriveRight1.setVoltageRampRate(rampRate);
        rhinoDriveRight2.setVoltageRampRate(rampRate);
        rhinoDriveLeft1.setVoltageRampRate(rampRate);
        rhinoDriveLeft2.setVoltageRampRate(rampRate);
    }
}
