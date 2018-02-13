package org.usfirst.frc3245.CompCode3245.commands;

import org.usfirst.frc3245.CompCode3245.Robot;
import org.usfirst.frc3245.CompCode3245.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;


/**

 *

 */

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class GyroTurn extends PIDCommand {

	double angle;
	private int count = 0;
	double currentOutput = 0;

	double MINIMUM_OUTPUT = -0.55;
	double MAXIMUM_OUTPUT = 0.55; 

	

	public GyroTurn(double setpoint, double p, double i, double d) {

		super(p, i, d);
		setSetpoint(setpoint);
		getPIDController().setAbsoluteTolerance(1.5);
		angle = setpoint;

		//Robot.TANK_DRIVE_SUBSYSTEM.gyro.reset();
		//Robot.autoOn = true;
		getPIDController().setOutputRange(MINIMUM_OUTPUT, MAXIMUM_OUTPUT);
		//LiveWindow.addActuator(moduleType, channel, component);

	}

	@Override
	protected double returnPIDInput() {
		if (count % 3 == 0) {  
			//System.out.println("Current Angle: " + Robot.TANK_DRIVE_SUBSYSTEM.gyro.getAngle());
			SmartDashboard.putNumber("Angle", Robot.driveTrain.gyro1.getAngle()); 
		}
		count++;
		//Robot.autoOn = true;

		return Robot.driveTrain.gyro1.getAngle();

	}



	@Override

	protected void usePIDOutput(double output) {
		Robot.driveTrain.drive(-output, output); 
		currentOutput = output;
	}



	@Override

	protected boolean isFinished() {
		if  (getPIDController().onTarget()) {
			System.out.println("Finished");
			Robot.driveTrain.drive(0, 0);
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