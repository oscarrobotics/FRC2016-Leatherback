package frc.team832.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team832.robot.subsystems.drivetrain.DTConstants;

// !!!!!!!!  IF SHIT GOES BONKERS, RE-ADD LIVE WINDOW STUFF !!!!!!!!!!

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static PowerDistributionPanel pdp;

	public static WPI_TalonSRX rhinoDriveLeft1;
    public static WPI_TalonSRX rhinoDriveRight1;
    public static WPI_TalonSRX rhinoDriveLeft2;
    public static WPI_TalonSRX rhinoDriveRight2;

	public static DifferentialDrive rhinoDriveTank;
	
    // public static TalonSRX armMotor;
    // public static TalonSRX bPADRightWheel;
    // public static TalonSRX bPADLeftWheel;
    // public static TalonSRX shooterTiltMotors;
    // public static Relay lightControl;
    // public static Relay ballControlMotor;
    // public static Relay ballControlLEDs;
    // public static DigitalInput ballControlSwitch;
    // public static SpeedController armRollerMotor;
    // public static AnalogGyro gyro;
    public static NetworkTable visionTable;

    public static void init() {
    	//DO NOT CHANGE VALUES BETWEEN THESE COMMENTS <
    	/*
        double fShooter = 0.013623046875; 		// Feed-forward gain
    	double pShooter = 0.284;				// P for Shooter PID
    	double iShooter = 0;					// I for Shooter PID
    	double dShooter = 0;					// D for Shooter PID
    	*/
    	// double rampRateShooter = 50;				// Ramp rate for Shooter PID
    	//DO NOT CHANGE VALUES BETWEEN THESE COMMENTS >
    	// double rampRate = 70;					// Ramp rate for DriveTrain
        
    	visionTable = NetworkTableInstance.getDefault().getTable("Vision"); //  set up visionTable
    	
        pdp = new PowerDistributionPanel(0);
        
        rhinoDriveLeft1 = new WPI_TalonSRX(5);
		rhinoDriveRight1 = new WPI_TalonSRX(6);
		
        rhinoDriveLeft2 = new WPI_TalonSRX(7);
		rhinoDriveRight2 = new WPI_TalonSRX(4);
		
    	rhinoDriveLeft1.setSensorPhase(false);
		rhinoDriveLeft1.configAllSettings(DTConstants.leftDriveConfiguration);

		rhinoDriveLeft2.follow(rhinoDriveLeft1);

		rhinoDriveRight1.setSensorPhase(true);
		rhinoDriveRight1.configAllSettings(DTConstants.rightDriveConfiguration);

		rhinoDriveRight2.follow(rhinoDriveRight1);
		
		rhinoDriveTank = new DifferentialDrive(rhinoDriveLeft1, rhinoDriveRight1);

        // bPADRightWheel = new TalonSRX(9);
        // bPADLeftWheel = new TalonSRX(8);
        // shooterTiltMotors = new TalonSRX(10);
        // armMotor = new TalonSRX(1);
        
        
        // rhinoDriveTank = new RobotDrive(rhinoDriveLeft1, rhinoDriveRight1);
        // rhinoDriveTank.setSafetyEnabled(false);
        // rhinoDriveTank.setExpiration(0.1);
        // rhinoDriveTank.setSensitivity(0.5);
        // rhinoDriveTank.setMaxOutput(1.0);
        
        // ballControlMotor = new Relay(0);
        // ballControlLEDs = new Relay(2);
        // ballControlSwitch = new DigitalInput(1);
        
        // armRollerMotor = new Talon(0);
        // lightControl = new Relay(1);
        
        // Shooter encoder and PID settings
    	// bPADLeftWheel.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    	// bPADLeftWheel.setSensorPhase(false);
    	// bPADLeftWheel.configNominalOutputVoltage(+0.0f, -0.0f);
    	// bPADLeftWheel.configPeakOutputVoltage(+12.0f, -12.0f);
    	// bPADLeftWheel.setP(pShooter);
    	// bPADLeftWheel.setF(fShooter);
    	// bPADLeftWheel.setCloseLoopRampRate(rampRateShooter);
    	// bPADRightWheel.setFeedbackDevice(FeedbackDevice.CTRE_MagEncoder_Relative);
    	// bPADRightWheel.reverseSensor(false);
    	// bPADRightWheel.configNominalOutputVoltage(+0.0f,  -0.0f);
    	// bPADLeftWheel.configPeakOutputVoltage(+12.0f, -12.0f);
    	// bPADRightWheel.setP(pShooter);
    	// bPADRightWheel.setF(fShooter);
    	// bPADLeftWheel.setCloseLoopRampRate(rampRateShooter);
    	
    	// Shooter Tilting PID settings
    	// shooterTiltMotors.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    	// if (!shooterTiltMotors.isRevLimitSwitchClosed()) shooterTiltMotors.setEncPosition(0);
    	// shooterTiltMotors.changeControlMode(ControlMode.Position);
    	// shooterTiltMotors.setSensorPhase(false);
    	// shooterTiltMotors.configAllowableClosedloopError(0, 30);
    	// shooterTiltMotors.configNominalOutputVoltage(+0.0f, -0.0f);
    	// shooterTiltMotors.configPeakOutputVoltage(+12.0f, -12.0f);
    	// //shooterTiltMotors.setSetpoint(0.0);
    	// shooterTiltMotors.setEncPosition(0);
    	
        // Arm PID settings
        // armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        // armMotor.setSensorPhase(false);
        // armMotor.configAllowableClosedloopError(0, 30);
    }
}
