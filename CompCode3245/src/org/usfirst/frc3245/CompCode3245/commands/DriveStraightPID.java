package org.usfirst.frc3245.CompCode3245.commands;

import org.usfirst.frc3245.CompCode3245.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



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
    	SmartDashboard.putNumber("Setpoint", setpoint);
    	
    	Robot.kDriveTrain.resetEncoders();
    	
    	getPIDController().setOutputRange(MINIMUM_OUTPUT, MAXIMUM_OUTPUT);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    protected double returnPIDInput() {
    	if (count % 3 == 0) {
    		SmartDashboard.putNumber("Distance", Robot.kDriveTrain.getDistance());
    		Robot.kDriveTrain.reportEncoders();
    	}
    	count++;
    	
    	return Robot.kDriveTrain.getDistance();
    	
    	}
    protected void usePIDOutput(double output) {
    	Robot.kDriveTrain.drive(-output, output);
    	currentOutput = output;
    	SmartDashboard.putNumber("Output", currentOutput);
    	
    }
    
    protected boolean isFinished() {
    	if (getPIDController().onTarget()) {
    		System.out.println("Finished");
    		Robot.kDriveTrain.drive(0,0);
    		getPIDController().disable();
    		return true;
    	}
    	else {
    		return false;
    	}
    
    }
    
}

    

  