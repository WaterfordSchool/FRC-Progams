package org.usfirst.frc3245.CompCode3245.commands;

import org.usfirst.frc3245.CompCode3245.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CartWheelsSpinIn extends Command {

    public CartWheelsSpinIn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
		requires(Robot.cartWheels);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		setTimeout(0.9);
		Robot.cartWheels.spinWheels(-1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.cartWheels.stop();
    }

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
protected void interrupted() {
		end();
}
}
