
package org.usfirst.frc.team3166.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	//two controllers, one for driver, one for operator
	Joystick drivercontrol = new Joystick (0);
	Joystick operatorcontrol = new Joystick (1);
	//three motor controllers for driving and climbing
	//three motor controllers for driving and climbing
	Talon leftdrive = new Talon (1);
	Talon rightdrive = new Talon (3);
	Talon IntakeLeftMotor1 = new Talon (7);
	Talon IntakeRightMotor1 = new Talon(6);
	     Talon WristMotor1 = new Talon(0);
	//speeds for the motors: fast and slow speeds for left and right drive sides, a changeable slow speed value,
	//a climb motor speed, and a door motor speed
	double fastleft = 1, fastright = 1, slowleft = .5, slowright = .5, topslowspeed =.6, IntakeLeftMotor =.5, IntakeRightMotor =.5, WristMotor = 1;
	//variable to identify which auto routine is selected
	int dbValue = -1;
	
	PowerDistributionPanel PDP = new PowerDistributionPanel (0);
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro.
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
	//	topslowspeed = SmartDashboard.getNumber("DB/Slider 0",3.0); // Reads the top slider on the dashboard															
	//	if(topslowspeed <1) { topslowspeed = 1;}					// if the top slow speed returned was less than 1, make it 1
		//topslowspeed = topslowspeed/5;								// Normalizes the value to a percent
		
		fastleft = -drivercontrol.getRawAxis(1);					// read the left joystick on the driver control to get full speed
		slowleft = fastleft * topslowspeed;							// multiply full speed by percent of top slider to get slow speed
		fastright = -drivercontrol.getRawAxis(3);					// read the right joystick on the driver control to get full speed
		slowright = -fastright * topslowspeed;						// multiply full speed by percent of top slider to get slow speed
		
		//Control the wrist with a joystick (THIS DOESN'T WORK)
		WristMotor = operatorcontrol.getRawAxis(3);
		
		//SlowButton
		if (drivercontrol.getRawButton(6)) {						// if the driver is holding down the slow button send slow speed
			leftdrive.set(slowleft);								// to the motor controllers otherwise send full speed to motor
			rightdrive.set(slowright);								// controllers
		} else {
			leftdrive.set(fastleft);
			rightdrive.set(fastright);
		}
		
		//Wrist and wheels control w buttons (THIS WORKS)
		if (operatorcontrol.getRawButton(8)) {
			IntakeRightMotor1.set(1);
		} else if (operatorcontrol.getRawButton(6)) {
			IntakeRightMotor1.set(-1);
		} else {
			IntakeRightMotor1.set(0);
		}
		 if (operatorcontrol.getRawButton(7)) {
			IntakeLeftMotor1.set(-1);
		} else if(operatorcontrol.getRawButton(5)) {
			IntakeLeftMotor1.set(1);
		} else {
			IntakeLeftMotor1.set(0);
		} 
		 if(operatorcontrol.getRawButton(1)) {
			 WristMotor1.set(1);
		 } else if(operatorcontrol.getRawButton(3)){
			 WristMotor1.set(-.5);
		 } else {
			 WristMotor1.set(0);
		 }
	}
	/** Function practice calls autonomous periodically for 15 seconds
	 *  before switching to operator control for 2 minutes. That should
	 *  be changed to 2 & 1/2 minutes to fit 2017 gameplay description times.
	 */

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		/**This function is apparently for testing all of the controls and motors
		 * to see if they are ready. Good for rooting out flawed commands,
		 * disfunctional components, etc.
		 */
		
		fastleft = -drivercontrol.getRawAxis(1);					// read the left joystick on the driver control to get full speed						
		fastright = drivercontrol.getRawAxis(3);					// read the right joystick on the driver control to get full speed
				
		if (drivercontrol.getRawButton(6)) {						// see if the driver is holding down the slow button
			topslowspeed = SmartDashboard.getNumber("DB/Slider 0",3.0); 	// Reads the top slider on the dashboard															
			if(topslowspeed <1) {topslowspeed = 1;}					// if the top slow speed returned was less than 1, make it 1
			topslowspeed = topslowspeed/5;							// Normalizes the value to a percent
			slowleft = fastleft * topslowspeed;	 					// multiply full speed by percent of top slider to get slow speed
			slowright = fastright * topslowspeed;					// multiply full speed by percent of top slider to get slow speed
			leftdrive.set(slowleft);								// send slow speed to left & right drive
			rightdrive.set(slowright);								
		} else {													//if slow button not held down send fast speed to left & right drive
			leftdrive.set(fastleft);
			rightdrive.set(fastright);
		}
		
		SmartDashboard.putNumber("fastleft", fastleft);
		SmartDashboard.putNumber("fastright", fastright);
		SmartDashboard.putNumber("topslowspeed", topslowspeed);
		SmartDashboard.putNumber("PDP temp", PDP.getTemperature());
		//SmartDashboard.putNumber("Left Motor Current", PDP.getCurrent(1));
		//SmartDashboard.putNumber("Left Motor Current", PDP.getCurrent(2));
		//SmartDashboard.putNumber("Left Motor Current", PDP.getCurrent(3));
		//SmartDashboard.putNumber("Right Motor Current", PDP.getCurrent(12));
		//SmartDashboard.putNumber("Right Motor Current", PDP.getCurrent(13));
		//SmartDashboard.putNumber("Right Motor Current", PDP.getCurrent(14));
	}
}





