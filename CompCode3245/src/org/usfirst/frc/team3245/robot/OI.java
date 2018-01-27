package org.usfirst.frc.team3245.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3245.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick drivercontrol = new Joystick(0);
	private Joystick operatorcontrol = new Joystick(1);

	public OI() {
		// Put Some buttons on the SmartDashboard
		SmartDashboard.putData("Elevator Bottom", new SetElevatorSetpoint(0));
		//do we need a platform -- Si, verdad
		//SmartDashboard.putData("Elevator Switch", new SetElevatorSetpoint(FIND THIS OUT));
		//SmartDashboard.putData("Elevator Low Scale", new SetElevatorSetpoint(FIND THIS OUT));
		//SmartDashboard.putData("Elevator High Scale", new SetElevatorSetpoint(FIND THIS OUT));
		SmartDashboard.putData("Elevator Top", new SetElevatorSetpoint(0.3));

		SmartDashboard.putData("Wrist Horizontal", new SetWristSetpoint(0));
		SmartDashboard.putData("Raise Wrist", new SetWristSetpoint(-45)); //we won't know the degrees until it is built--CHANGE?

		//SmartDashboard.putData("Open Claw", new OpenClaw());
		//SmartDashboard.putData("Close Claw", new CloseClaw());

		SmartDashboard.putData("Deliver Soda", new Autonomous());

		// Create some buttons
		JoystickButton d_up = new JoystickButton(drivercontrol, 5);
		JoystickButton d_right = new JoystickButton(drivercontrol, 6);
		JoystickButton d_down = new JoystickButton(drivercontrol, 7);
		JoystickButton d_left = new JoystickButton(drivercontrol, 8);
		JoystickButton l2 = new JoystickButton(drivercontrol, 9);
		JoystickButton r2 = new JoystickButton(drivercontrol, 10);
		JoystickButton l1 = new JoystickButton(drivercontrol, 11);
		JoystickButton r1 = new JoystickButton(drivercontrol, 12);

		// Connect the buttons to commands
		d_up.whenPressed(new SetElevatorSetpoint(0.2));
		d_down.whenPressed(new SetElevatorSetpoint(-0.2));
		//d_right.whenPressed(new CloseClaw());
		//d_left.whenPressed(new OpenClaw());

		r1.whenPressed(new PrepareToPickup());
		r2.whenPressed(new Pickup());
		l1.whenPressed(new Place());
		l2.whenPressed(new Autonomous());
	}

	public Joystick getJoystick() {
		return drivercontrol;
	}
}
