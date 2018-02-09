package org.usfirst.frc3245.CompCode3245.subsystems;

import org.usfirst.frc3245.CompCode3245.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

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
    
    
    
    public void in() {
    	LeftCartWheel.set(-.5);
    	RightCartWheel.set(.5);
    }
    
    public void open() {
    	CartLeftArm.set(.5);
    	CartRightArm.set(-.5);
    }
    
    public void out() {
    	LeftCartWheel.set(.5);
    	RightCartWheel.set(-.5);
    }
    
    public void stop() {
    	LeftCartWheel.set(0);
    	RightCartWheel.set(0);
    }
}

