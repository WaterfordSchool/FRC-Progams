package org.usfirst.frc.team3166.robot.commands;

import org.usfirst.frc.team3166.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.PIDCommand;


/**
 *
 */
public class DriveStraightPID extends PIDCommand {

	double distance;
	private int count = 0;
	double currentOutput = 0;

	double MINIMUM_OUTPUT = -0.55;
	double MAXIMUM_OUTPUT = 0.55; 

	

	public DriveStraightPID(int setpoint, double p, double i, double d) {

		super(p, i, d);
		setSetpoint(setpoint);
		getPIDController().setAbsoluteTolerance(1.5);
		distance = setpoint;
		SmartDashboard.putNumber("Setpoint",  setpoint);
		
		Robot.kDriveTrain.resetEncoders();

		//Robot.TANK_DRIVE_SUBSYSTEM.gyro.reset();
		//Robot.autoOn = true;
		getPIDController().setOutputRange(MINIMUM_OUTPUT, MAXIMUM_OUTPUT);
		//LiveWindow.addActuator(moduleType, channel, component);

	}

	@Override
	protected double returnPIDInput() {
		if (count % 3 == 0) {  
			//System.out.println("Current Angle: " + Robot.TANK_DRIVE_SUBSYSTEM.gyro.getAngle());
			SmartDashboard.putNumber("Distance", Robot.kDriveTrain.getDistance()); 
			Robot.kDriveTrain.reportEncoders();
		}
		count++;
		//Robot.autoOn = true;

		return Robot.kDriveTrain.getDistance();

	}



	@Override

	protected void usePIDOutput(double output) {
		Robot.kDriveTrain.drive(-output, output); 
		currentOutput = output;
		SmartDashboard.putNumber("Output", currentOutput); 

	}



	@Override

	protected boolean isFinished() {
		if  (getPIDController().onTarget()) {
			System.out.println("Finished");
			Robot.kDriveTrain.drive(0, 0);
			//Robot.TANK_DRIVE_SUBSYSTEM.gyro.reset();
			getPIDController().disable();
			//Robot.autoOn = false;
			return true;
		}

		else {
//			System.out.println("Current motor output: " + currentOutput);
//			System.out.println("is not finished");
			return false;

		}

	}
}



