package org.usfirst.frc.team3166.robot.commands;

import org.usfirst.frc.team3166.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimerDelay extends Command {

	public Timer timer = new Timer();
	public double m_timeDelay;
	
    public TimerDelay(double timeDelay) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.kDriveTrain);
    	m_timeDelay = timeDelay;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	timer.reset();
    	if (timer.get() < m_timeDelay) {
    		Robot.kDriveTrain.drive(0, 0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
