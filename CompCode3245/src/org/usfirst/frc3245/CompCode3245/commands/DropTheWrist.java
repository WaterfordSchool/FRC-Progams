package org.usfirst.frc3245.CompCode3245.commands;

import org.usfirst.frc3245.CompCode3245.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DropTheWrist extends Command {

    public DropTheWrist() {
        requires(Robot.wrist);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(0.9);
    	Robot.wrist.DropWrist();
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
    	Robot.wrist.DontMove();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
