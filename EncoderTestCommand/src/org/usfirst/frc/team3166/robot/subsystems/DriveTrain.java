package org.usfirst.frc.team3166.robot.subsystems;

import org.usfirst.frc.team3166.robot.Robot;
import org.usfirst.frc.team3166.robot.commands.*;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    public static WPI_TalonSRX LeftMotor = new WPI_TalonSRX(45);
    public static WPI_TalonSRX RightMotor = new WPI_TalonSRX(32);
    public static DifferentialDrive tDrive = new DifferentialDrive(LeftMotor, RightMotor);

    public double motorSpeed;
    public int averagePos;
    
	public void initDriveTrain() {
		LeftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 4);
		LeftMotor.setSensorPhase(false);
		RightMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 4);
		RightMotor.setSensorPhase(false);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
    }
    
    public void drive(double left, double right) {
    	tDrive.tankDrive(right, left);
    }
    public void drive(Joystick joy) {
    	drive(joy.getY(), joy.getAxis(AxisType.kThrottle));
		SmartDashboard.putNumber("Left Motor Speed", LeftMotor.get());
		SmartDashboard.putNumber("Right Motor Speed", RightMotor.get());
    }
    
    public void resetEncoders() {
		LeftMotor.setSelectedSensorPosition(0, 0, 0);
		RightMotor.setSelectedSensorPosition(0, 0, 0);
		averagePos = 0;
    }
    
    public void reportEncoders() {
		SmartDashboard.putNumber("Right Encoder Position", DriveTrain.RightMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Left Encoder Position", DriveTrain.LeftMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Left Motor Speed", DriveTrain.LeftMotor.get());
		SmartDashboard.putNumber("Right Motor Speed", DriveTrain.RightMotor.get());
		SmartDashboard.putNumber("Average Encoder Position", averagePos);
    }
    
    public double getDistance() {
		averagePos = (RightMotor.getSelectedSensorPosition(0)+LeftMotor.getSelectedSensorPosition(0))/2;
		return averagePos;
    }
    
    public void stop() {
    	drive(0,0);
    }
}

