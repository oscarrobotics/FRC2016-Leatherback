package org.usfirst.frc832.Leatherback;

import org.usfirst.frc832.Leatherback.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick driverPad;
    public JoystickButton wheelsOut;
    public JoystickButton wheelsIn;
    public JoystickButton dPadUp;
    public JoystickButton dPadDown;
    public JoystickButton retrieve;
    public JoystickButton fire;
    public JoystickButton armUpButton;
    public JoystickButton armDownButton;
    public JoystickButton rollerSuckIn;
    public JoystickButton rollerSpitOut;
    public JoystickButton flashlightToggle;
    
    public JoystickButton flashlightRightTrig;

    public Joystick buttonPanel;

    public OI() {

        buttonPanel = new Joystick(1);
        
        armDownButton = new JoystickButton(buttonPanel, 7);
        armDownButton.whileHeld(new ArmDown());
        armUpButton = new JoystickButton(buttonPanel, 2);
        armUpButton.whileHeld(new ArmUp());
        fire = new JoystickButton(buttonPanel, 5);
        fire.whileHeld(new BallOut());
        retrieve = new JoystickButton(buttonPanel, 4);
        retrieve.whileHeld(new Manual_BallIn());
        dPadDown = new JoystickButton(buttonPanel, 6);
        dPadDown.whileHeld(new Manual_ShooterTiltDown());
        dPadUp = new JoystickButton(buttonPanel, 9);
        dPadUp.whileHeld(new Manual_ShooterTiltUp());
        wheelsIn = new JoystickButton(buttonPanel, 8);
        wheelsIn.whileHeld(new FullBallIn());
        wheelsOut = new JoystickButton(buttonPanel, 12);
        wheelsOut.whileHeld(new SpitOut());
       // wheelsOut.whenReleased(new Stop_Wheels());
        driverPad = new Joystick(0);
        rollerSuckIn = new JoystickButton(buttonPanel, 1);
        rollerSuckIn.whileHeld(new Wheels_VBus());
        rollerSpitOut = new JoystickButton(buttonPanel, 13);
        rollerSpitOut.whileHeld(new Manual_RollerOut());
        flashlightToggle = new JoystickButton(buttonPanel, 3);
        flashlightToggle.whileHeld(new Stop_Wheels());
        
        flashlightRightTrig = new JoystickButton(driverPad, 6);
        flashlightRightTrig.whileHeld(new LightToggle());
        // SmartDashboard Buttons
    }

    public Joystick getDriverPad() {
        return driverPad;
    }

    public Joystick getButtonPanel() {
        return buttonPanel;
    }
}