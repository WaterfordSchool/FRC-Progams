// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3245.CompCode3245;

import org.usfirst.frc3245.CompCode3245.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc3245.CompCode3245.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick driver;
    public Joystick operator;
    public JoystickButton opLeftTrigger, opRightTrigger;
    public JoystickButton greenButton;
    public JoystickButton opRightBumper, opLeftBumper;
    public JoystickButton drLeftTrigger, drRightTrigger;
    public JoystickButton opRedButton, opBlueButton;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	
    	driver = new Joystick(0);
        operator = new Joystick(1);
        
        opLeftTrigger = new JoystickButton(operator, 7);
        opLeftTrigger.whileHeld(new IntakeCube());
        opRightTrigger = new JoystickButton(operator, 8);
       
        
        greenButton = new JoystickButton(driver, 2);
        greenButton.whileHeld(new DriveStr8());
        
        opRightBumper = new JoystickButton (operator, 5);
        opRightBumper.whileHeld(new ElevatorUp());
        
        opLeftBumper = new JoystickButton (operator, 6);
        opLeftBumper.whileHeld(new ElevatorDown());
        
        drLeftTrigger = new JoystickButton(driver, 5);
        drLeftTrigger.whileHeld(new CartWheels(-0.3));
        drRightTrigger = new JoystickButton (driver, 6);
        drRightTrigger.whileHeld(new CartWheels(0.3));
        
        opRedButton = new JoystickButton(operator, 3);
        opRedButton.whileHeld(new CartArms(-0.3));
        opBlueButton = new JoystickButton(operator, 1);
        opBlueButton.whileHeld(new CartArms(.3));
        
        
        
    

        // SmartDashboard Buttons
        //SmartDashboard.putData("Autonomous Command", new AutonomousCommand()); Do we need this?
        SmartDashboard.putData("Intake Cube", new IntakeCube());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }


	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriver() {
        return driver;
    }

    public Joystick getOperator() {
        return operator;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

