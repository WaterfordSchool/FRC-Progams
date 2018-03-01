/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3166.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3166.robot.commands.*;
import org.usfirst.frc.team3166.robot.subsystems.*;


public class Robot extends TimedRobot {
	public static DriveTrain kDriveTrain;
	public static OI m_oi;
	
	public double motorSpeed;
	public int averagePos;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		kDriveTrain = new DriveTrain();
		m_chooser.addDefault("Default Auto", new DriveStraight(2000, 0.5));
		m_chooser.addObject("Auto for Right Position", new AutoRight());
		m_chooser.addObject("Auto for Left Position", new AutoLeft());
		SmartDashboard.putData("Auto mode", m_chooser);
		kDriveTrain.initDriveTrain();
		kDriveTrain.resetEncoders();
		SmartDashboard.putNumber("Average Encoder Position", kDriveTrain.averagePos);
		SmartDashboard.putNumber("Right Encoder Position", DriveTrain.RightMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Left Encoder Position", DriveTrain.LeftMotor.getSelectedSensorPosition(0));
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		Robot.kDriveTrain.resetEncoders();
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}


	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void testPeriodic() {
	}
}
