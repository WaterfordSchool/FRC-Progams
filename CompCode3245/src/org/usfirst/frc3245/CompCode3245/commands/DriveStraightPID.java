package org.usfirst.frc3245.CompCode3245.commands;

import org.usfirst.frc3245.CompCode3245.Robot;
import org.usfirst.frc3245.CompCode3245.RobotMap;
import org.usfirst.frc3245.CompCode3245.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class DriveStraightPID extends Command {
	public static DriveTrain driveTrain;
	public static PIDSource pidSource;
	public static PIDOutput pidOutput;
	
	private static final double TOLERANCE = 50;
	
	private PIDController m_pid;
	private double m_maxSpeed = 0.6;
	private double m_distance = 0.0;
	
	private double KP = 2.0;
	private double KI = 0.0;
	private double KD = 1.0;

    public DriveStraightPID(double distance, double maxSpeed, double kp, double ki, double kd) {
    	 requires(Robot.driveTrain);
        	KP = kp;
        	KI = ki;
        	KD = kd;
        	buildController();
    }
    
    public DriveStraightPID(double distance, double maxSpeed) {
    	 requires(Robot.driveTrain);
    	 m_maxSpeed = maxSpeed;
    	 m_distance = distance;
    	 buildController();
    }
    
    public DriveStraightPID (double distance) {
    	 requires(Robot.driveTrain);
    	 m_distance = distance;
    	 
    	 buildController();
    }
    
    private void buildController() {
    	m_pid = new PIDController(KP, KI, KD, pidSource, pidOutput);
    	m_pid.setAbsoluteTolerance(TOLERANCE);
    	m_pid.setOutputRange(-m_maxSpeed, m_maxSpeed);
    	m_pid.setSetpoint(m_distance);
    }
   
    
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain = new DriveTrain();
    	
    	driveTrain.resetEncoders();
    	
    	pidSource = new PIDSource () {
    		PIDSourceType m_sourceType = PIDSourceType.kDisplacement;
    		
    		public double pidGet () {
    			return driveTrain.getPosition();
    		}
    		
    		public void setPIDSourceType(PIDSourceType pidSource) {
    			m_sourceType = pidSource;
    		}
    		
    		public PIDSourceType getPIDSourceType() {
    			return m_sourceType;
    		}
    	};
    	
    	pidOutput = new PIDOutput() {
    		public void pidWrite(double d) {
    			driveTrain.drive(-d, -(RobotMap.driveTrainGyro1.getRate()/240));
    		}};
    	
    	
    	
    	m_pid.reset();
    	m_pid.enable();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double error = m_pid.getError();
        return (error >+ 0 && error <= TOLERANCE);
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Stop the PID and the Wheels
    		m_pid.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
