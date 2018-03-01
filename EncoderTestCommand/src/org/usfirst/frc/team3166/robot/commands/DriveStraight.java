package org.usfirst.frc.team3166.robot.commands;

import org.usfirst.frc.team3166.robot.Robot;
import org.usfirst.frc.team3166.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraight extends Command {
	private double m_motorSpeed;
	private double encoderPos;
	public int m_distance;
	
    public DriveStraight(int distance, double motorSpeed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.kDriveTrain);
        m_distance = distance;
        m_motorSpeed = motorSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		encoderPos = 0;
		SmartDashboard.putNumber("Average Encoder Position DS", encoderPos);
		Robot.kDriveTrain.reportEncoders();
		while (encoderPos < m_distance) {
			DriveTrain.tDrive.tankDrive(m_motorSpeed, m_motorSpeed);
			encoderPos = Robot.kDriveTrain.getDistance();
			Robot.kDriveTrain.reportEncoders();
			SmartDashboard.putNumber("Average Encoder Position DS", encoderPos);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kDriveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
