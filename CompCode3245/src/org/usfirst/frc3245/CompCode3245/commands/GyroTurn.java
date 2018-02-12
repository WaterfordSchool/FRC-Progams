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

public class GyroTurn extends Command {

	private PIDController rotatePID;

	private final double ROTATE_kP = 0.2, ROTATE_kI = 0, ROTATE_kD = 0;

	public GyroTurn(double angle) {
		rotatePID = new PIDController(ROTATE_kP, ROTATE_kI, ROTATE_kD, new PIDSource() {
			PIDSourceType m_sourceType = PIDSourceType.kDisplacement;

			public double pidGet() {
				return RobotMap.driveTrainGyro1.getAngle();
			}

			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				m_sourceType = pidSource;
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				return m_sourceType;
			}

		}, new PIDOutput() {
			public void pidWrite(double angle) {
				RobotMap.driveTrainTDrive.arcadeDrive(0, angle);
			}
		});

		rotatePID.setContinuous(false);
		rotatePID.setInputRange(0, 360);
		rotatePID.setOutputRange(-1, 1);

		rotatePID.setAbsoluteTolerance(1);
		rotatePID.setSetpoint(angle);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (RobotMap.driveTrainGyro1.getAngle() != 0) {
			RobotMap.driveTrainGyro1.reset();
		}
		rotatePID.reset();
		rotatePID.enable();
	}



	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putData("Angle Tune", rotatePID);
	}



	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		rotatePID.disable();
		RobotMap.driveTrainTDrive.arcadeDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}