package org.usfirst.frc.team3245.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3245.robot.*;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private SpeedController motor = new Talon (6);
	private DigitalInput contact = new DigitalInput(6);
	
	public Intake() {
		
		super();
		
			//Shows everything on Live Window
		LiveWindow.addActuator("Intake", "Motor", (Talon) motor);
		LiveWindow.addActuator("Intake", "Limit Switch", contact);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	//LEAVE empty because we have no default command
    }
    
    public void log() {
	}

	/**
	 * Set the claw motor to move in the open direction.
	 */
	public void suck() {
		motor.set(-1);
	}

	/**
	 * Set the claw motor to move in the close direction.
	 */
	public void blow() {
		motor.set(1);
	}

	/**
	 * Stops the claw motor from moving.
	 */
	public void stop() {
		motor.set(0);
	}
	
	public boolean isGrabbing() {
		return contact.get();
	}
}

