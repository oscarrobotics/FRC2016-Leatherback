// package frc.team832.robot.subsystems;

// import frc.team832.robot.RobotMap;
// import frc.team832.robot.Robot;
// import edu.wpi.first.wpilibj.TalonSRX;
// import edu.wpi.first.wpilibj.command.Subsystem;

// public class BPAD extends Subsystem {
	
// 	double throttle, rightRippems, leftRippems, rightAmps, leftAmps, rightOutputV,leftOutputV, rightInputV, leftInputV, averageRPM; // Don't init these
// 	boolean isAcceptable;
// 	int outputRPM;
// 	int intakeRPM = 5400;
// 	int outputRPM_HighGoal = -3000;
// 	int outputRPM_LowGoal = -3000;
// 	boolean isVBus;
		
//     private final TalonSRX rightWheel = RobotMap.bPADRightWheel;
//     private final TalonSRX leftWheel = RobotMap.bPADLeftWheel;

//     public double getThrottle() {
//     	throttle = (Robot.oi.buttonPanel.getZ() + 1) / 2;
//     	return throttle;
//     }
//     public int getLeftRPM() {
//     	leftRippems = leftWheel.getSpeed();
//     	return (int) leftRippems;
//     }
//     public int getRightRPM() {
//     	rightRippems = rightWheel.getSpeed();
//     	return (int) rightRippems;
//     }
//     public int getIntakeRPM() {
//     	return intakeRPM;    	
//     }
//     public int getOutputRPM_LowGoal() {
//     	return outputRPM_LowGoal;
//     }
    
//     public int getOutputRPM_HighGoal() {
//     	return outputRPM_HighGoal;
//     }
    
//     public int getActualOutputRPM() {
//     	if (throttle > 0) outputRPM = outputRPM_LowGoal;
//     	else if (throttle < 0) outputRPM = outputRPM_HighGoal;
//     	return outputRPM;
//     }
    
//     public double getLeftAmps() {
//     	return RobotMap.bPADLeftWheel.getOutputCurrent();
//     }
    
//     public double getRightAmps() {
//     	return RobotMap.bPADRightWheel.getOutputCurrent();
//     }
    
//     public double getBothAvgAmps() {
//     	return ( ( getLeftAmps() + getRightAmps() ) / 2);
//     }
    
//     public double getBothAverageRPM() {
//     	double lr = leftRippems;
//     	double rr = rightRippems;
//     	double averageRPM = ((lr + rr) /2);
//     	this.averageRPM = averageRPM;
//     	return averageRPM;
//     }
    
//     public void setWheelSpeed(double left, double right) {
//     	rightWheel.setSetpoint(right);
//     	leftWheel.setSetpoint(-left);
//     }
    
//     public void initDefaultCommand() { 
//     }
    
//     /**
//      * @param mode ~ True = output, false = intake
//      * @return
//      */
//     public boolean getIsRpmAcceptable(boolean mode) {
//     	int desiredSpeed;
//     	if (mode) desiredSpeed = outputRPM;
//     	else desiredSpeed = intakeRPM;
//     	averageRPM = Robot.bPAD.getBothAverageRPM();
// 		if ((averageRPM - 100) < desiredSpeed && desiredSpeed < (averageRPM + 100)) isAcceptable = true;
// 		else isAcceptable = false;
//     	return isAcceptable;
//     }
    
//     /**
//      * Will stop wheels regardless of control mode.
//      */
//     public void stopWheels() {
//     	leftWheel.set(0);
//     	rightWheel.set(0);
//     }
    
//     public boolean getMode() {
//     	return isVBus;
//     }
    
// 	public void setToSpeed() {
// 		leftWheel.changeControlMode(TalonSRX.TalonControlMode.Speed);
// 		rightWheel.changeControlMode(TalonSRX.TalonControlMode.Speed);	
// 		isVBus = false;
// 	}
	
// 	public void setToVBus() {
// 		leftWheel.changeControlMode(TalonSRX.TalonControlMode.PercentVbus);
// 		rightWheel.changeControlMode(TalonSRX.TalonControlMode.PercentVbus);
// 		isVBus = true;
// 	}
// }
