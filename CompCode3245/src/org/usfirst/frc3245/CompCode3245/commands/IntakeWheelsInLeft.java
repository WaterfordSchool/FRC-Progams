package org.usfirst.frc3245.CompCode3245.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

import org.usfirst.frc3245.CompCode3245.Robot;



/**
 *
 */
public class IntakeWheelsInLeft extends Command {

    public IntakeWheelsInLeft() {
        requires(Robot.intakeWheelsLeft);
    }

    protected void execute() {
		setTimeout(0.9);
		Robot.intakeWheels.inSpinLeft();
		
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

