package org.usfirst.frc3245.CompCode3245.subsystems;

import org.usfirst.frc3245.CompCode3245.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CartArms extends Subsystem {
	
	private final WPI_TalonSRX cartLeftArm = RobotMap.LeftCartArm;
	private final WPI_TalonSRX cartRightArm = RobotMap.RightCartArm;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void rotateArm(double armSpeed) {
    	cartLeftArm.set(armSpeed);
    	cartRightArm.set(-armSpeed);
    }
    
    public void stop() {
    	cartLeftArm.set(0);
    	cartRightArm.set(0);
    }
}

