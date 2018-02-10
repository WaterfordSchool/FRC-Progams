package org.usfirst.frc3245.CompCode3245.commands;

import org.usfirst.frc3245.CompCode3245.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CartWheels extends Command {

    public CartWheels(double wheelSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
		requires(Robot.cart);
    }

    // Called just before this Command runs the first time
    protected void initialize(double wheelSpeed) {
		setTimeout(0.9);
		Robot.cart.spinWheels(wheelSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.cart.stop();
    }

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
protected void interrupted() {
		end();
}
}
