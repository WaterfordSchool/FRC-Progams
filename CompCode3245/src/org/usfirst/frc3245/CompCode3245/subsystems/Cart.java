package org.usfirst.frc3245.CompCode3245.subsystems;

import org.usfirst.frc3245.CompCode3245.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Cart extends Subsystem {

	
	
	private final WPI_TalonSRX LeftCartWheel = RobotMap.LeftCartWheel;
	private final WPI_TalonSRX RightCartWheel = RobotMap.RightCartWheel;
	private final WPI_TalonSRX CartLeftArm = RobotMap.LeftCartArm;
	private final WPI_TalonSRX CartRightArm = RobotMap.RightCartArm;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    
    public void rotateArm(double armSpeed) {
    		LeftCartWheel.set(armSpeed);
    		RightCartWheel.set(-armSpeed);
        	SmartDashboard.putNumber("Left Cart Wheel Speed", LeftCartWheel.get());

    }
    
    public void spinWheels(double wheelSpeed) {
    		CartLeftArm.set(wheelSpeed);
    		CartRightArm.set(-wheelSpeed);
        	SmartDashboard.putNumber("Left Cart Arm Speed", CartLeftArm.get());

    }
    
    public void stop() {
    		LeftCartWheel.set(0);
    		RightCartWheel.set(0);
    		CartLeftArm.set(0);
    		CartRightArm.set(0);
    }
}

