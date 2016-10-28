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
    public JoystickButton flashlightRightTrig;
    public JoystickButton alignMe;
    
    
    public Joystick buttonPanel;
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
    public JoystickButton stopWheels;

    public OI() {

    	driverPad = new Joystick(0);
    	
        flashlightRightTrig = new JoystickButton(driverPad, 6);
        flashlightRightTrig.whileHeld(new LightToggle());
        alignMe = new JoystickButton(driverPad, 1); // IDK what button 1 is
    	alignMe.whileHeld(new AlignToTarget());
        
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
        rollerSuckIn = new JoystickButton(buttonPanel, 1);
        rollerSuckIn.whileHeld(new Manual_RollerIn());
        rollerSpitOut = new JoystickButton(buttonPanel, 13);
        rollerSpitOut.whileHeld(new Manual_RollerOut());
        stopWheels = new JoystickButton(buttonPanel, 3);
        stopWheels.whileHeld(new Stop_Wheels());
    }

    public Joystick getDriverPad() {
        return driverPad;
    }

    public Joystick getButtonPanel() {
        return buttonPanel;
    }
}