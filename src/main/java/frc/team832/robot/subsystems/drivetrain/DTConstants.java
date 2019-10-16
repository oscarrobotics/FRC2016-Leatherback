package frc.team832.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.SlotConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

public class DTConstants {
    private DTConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated!");
    }

    public static final double ENCODER_COEFFICIENT = 1.0;
    public static final int PEAK_CURRENT_AMPS = 70;
    public static final int PEAK_CURRENT_DURATION_MS = 500;
    public static final int CONT_CURRENT_AMPS = 50;
    public static final double OPENLOOP_RAMP = 0.25;
    public static final double CLOSEDLOOP_RAMP = 0.25;

    public static final TalonSRXConfiguration leftDriveConfiguration = new TalonSRXConfiguration();
    public static final SlotConfiguration leftPID_Velocity = new SlotConfiguration();

    public static final TalonSRXConfiguration rightDriveConfiguration = new TalonSRXConfiguration();

    static {
        leftDriveConfiguration.slot0.kP = 0.3;
        leftDriveConfiguration.slot0.kF = 0.05;
        leftDriveConfiguration.slot0.allowableClosedloopError = 50;

        leftDriveConfiguration.openloopRamp = OPENLOOP_RAMP;
        leftDriveConfiguration.closedloopRamp = CLOSEDLOOP_RAMP;
        
        leftDriveConfiguration.primaryPID.selectedFeedbackCoefficient = ENCODER_COEFFICIENT; // gearbox ratio to wheel ratio
        leftDriveConfiguration.primaryPID.selectedFeedbackSensor = FeedbackDevice.QuadEncoder;


        leftDriveConfiguration.peakCurrentLimit = PEAK_CURRENT_AMPS;
        leftDriveConfiguration.peakCurrentDuration = PEAK_CURRENT_DURATION_MS;

        leftDriveConfiguration.continuousCurrentLimit = CONT_CURRENT_AMPS;

        rightDriveConfiguration.slot0.kP = 0.3;
        rightDriveConfiguration.slot0.kF = 0.05;
        rightDriveConfiguration.slot0.allowableClosedloopError = 50;

        rightDriveConfiguration.openloopRamp = OPENLOOP_RAMP;
        rightDriveConfiguration.closedloopRamp = CLOSEDLOOP_RAMP;
        
        rightDriveConfiguration.primaryPID.selectedFeedbackCoefficient = ENCODER_COEFFICIENT; // gearbox ratio to wheel ratio
        rightDriveConfiguration.primaryPID.selectedFeedbackSensor = FeedbackDevice.QuadEncoder;


        rightDriveConfiguration.peakCurrentLimit = PEAK_CURRENT_AMPS;
        rightDriveConfiguration.peakCurrentDuration = PEAK_CURRENT_DURATION_MS;

        rightDriveConfiguration.continuousCurrentLimit = CONT_CURRENT_AMPS;
    }
}