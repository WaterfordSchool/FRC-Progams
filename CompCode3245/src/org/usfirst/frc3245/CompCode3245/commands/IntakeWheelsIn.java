package org.usfirst.frc3245.CompCode3245.commands;

import org.usfirst.frc3245.CompCode3245.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeWheelsIn extends Command {

    public IntakeWheelsIn() {
        requires(Robot.intakeWheels);
    }

    protected void execute() {
		setTimeout(0.9);
		Robot.intakeWheels.inSpinRight();
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.intakeWheels.stop();
    }

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
protected void interrupted() {
		end();
}
}
