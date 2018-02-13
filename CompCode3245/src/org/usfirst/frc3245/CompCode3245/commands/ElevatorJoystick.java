
package org.usfirst.frc3245.CompCode3245.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3245.CompCode3245.Robot;
import org.usfirst.frc3245.CompCode3245.RobotMap;

/**
 *
 */
public class ElevatorJoystick extends Command {
	
    public ElevatorJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	//setTimeout(0.09);
    	//Robot.elevator.up();    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.activate(Robot.oi.getOperator());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
