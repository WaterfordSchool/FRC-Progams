package org.usfirst.frc3245.CompCode3245.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import com.ctre.phoenix.motorcontrol.can.*;

/**
 *
 */
public class ElevatorPID extends PIDSubsystem {

    // Initialize your subsystem here
	private static final double kP_elevator = 4, kI_elevator = 0.07;
	
    public ElevatorPID() {
    	super(kP_elevator, kI_elevator, 0);
    	setAbsoluteTolerance(0.005);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
