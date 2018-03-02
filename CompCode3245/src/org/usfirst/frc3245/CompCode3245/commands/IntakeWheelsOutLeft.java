package org.usfirst.frc3245.CompCode3245.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */


import org.usfirst.frc3245.CompCode3245.Robot;



/**
 *
 */
public class IntakeWheelsOutLeft extends Command {

    public IntakeWheelsOutLeft() {
        requires(Robot.intakeWheelsLeft);
    }

    protected void execute() {
		setTimeout(0.9);
		Robot.intakeWheelsLeft.outSpinLeft();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.intakeWheelsLeft.stop();
    }

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
protected void interrupted() {
		end();
}
}
