/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3166.robot;

import com.ctre.phoenix.*;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
    public static WPI_TalonSRX LeftMotor = new WPI_TalonSRX(45);
    public static WPI_TalonSRX RightMotor = new WPI_TalonSRX(32);
    public static DifferentialDrive TDrive = new DifferentialDrive(LeftMotor, RightMotor);
  //  public static Encoder LeftEncoder, RightEncoder;
    public static ADXRS450_Gyro driveTrainGyro1;

   public double motorSpeed;
    public int averagePos;

	@Override
	public void robotInit() {
		LeftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 4);
    	LeftMotor.setSensorPhase(false);
    	RightMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 4);
    	RightMotor.setSensorPhase(false);
	}
	
	
	@Override
	public void autonomousInit() {
		
		resetEncoders();
		motorSpeed = 0.4;
		averagePos = 0;
		while (averagePos < 2000) {
			TDrive.tankDrive(motorSpeed, motorSpeed);
			averagePos = (RightMotor.getSelectedSensorPosition(0)+LeftMotor.getSelectedSensorPosition(0)/2);
			SmartDashboard.putNumber("Average Encoder Position", averagePos);
			SmartDashboard.putNumber("Right Encoder Position", RightMotor.getSelectedSensorPosition(0));
			SmartDashboard.putNumber("Left Encoder Position", LeftMotor.getSelectedSensorPosition(0));
			SmartDashboard.putNumber("Left Motor Speed", LeftMotor.get());
			SmartDashboard.putNumber("Right Motor Speed", RightMotor.get());
		}
		
		LeftMotor.set(0);
		RightMotor.set(0);
	}

	@Override
	public void autonomousPeriodic() {
		
	}

	public void resetEncoders() {
		LeftMotor.setSelectedSensorPosition(0, 0, 4);
		RightMotor.setSelectedSensorPosition(0, 0, 4);
	}
	
	@Override
	public void teleopPeriodic() {
	}

	@Override
	public void testPeriodic() {
	}
}
