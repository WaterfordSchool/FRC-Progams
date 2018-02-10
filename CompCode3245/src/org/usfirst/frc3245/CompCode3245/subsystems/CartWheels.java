package org.usfirst.frc3245.CompCode3245.subsystems;

import org.usfirst.frc3245.CompCode3245.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CartWheels extends Subsystem {
	
	
	public final WPI_TalonSRX leftCartWheel = RobotMap.LeftCartWheel;
	public final WPI_TalonSRX rightCartWheel = RobotMap.RightCartWheel;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void spinWheels(double wheelSpeed) {
    	leftCartWheel.set(wheelSpeed);
    	rightCartWheel.set(-wheelSpeed);
    }
    
    public void stop() {
    	leftCartWheel.set(0);
    	rightCartWheel.set(0);
    }
}

