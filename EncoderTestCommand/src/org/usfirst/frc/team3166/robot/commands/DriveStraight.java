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
	private int averagePos;
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
		//motorSpeed = 0.4;
		Robot.kDriveTrain.resetEncoders();
		while (averagePos < m_distance) {
			DriveTrain.tDrive.tankDrive(m_motorSpeed, m_motorSpeed);
			averagePos = (DriveTrain.RightMotor.getSelectedSensorPosition(0)+DriveTrain.LeftMotor.getSelectedSensorPosition(0)/2);
			SmartDashboard.putNumber("Average Encoder Position", Robot.kDriveTrain.getDistance());
			SmartDashboard.putNumber("Right Encoder Position", DriveTrain.RightMotor.getSelectedSensorPosition(0));
			SmartDashboard.putNumber("Left Encoder Position", DriveTrain.LeftMotor.getSelectedSensorPosition(0));
			SmartDashboard.putNumber("Left Motor Speed", DriveTrain.LeftMotor.get());
			SmartDashboard.putNumber("Right Motor Speed", DriveTrain.RightMotor.get());
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
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
