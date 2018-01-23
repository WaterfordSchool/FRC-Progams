package org.usfirst.frc.team3245.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	char fieldPosition;
	Talon leftDrive = new Talon (0);
	Talon rightDrive = new Talon (1);
	Timer timer = new Timer();
	String gameData;
	String autoSelected;
	String DriverStation;
	SendableChooser<String> chooser = new SendableChooser<>();
	double fastLeft = 1.0, fastRight = 1.0 , slowRight = 0.5, slowLeft = 0.5;
	//topSlowSpeed = ?; 

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);
		double tester = 4.0;
		https://github.com/WaterfordSchool/FRC-Progams.git
		
			//Code for gameData but only for Switch Auto
			
	
			/* We can test this autocode on our Driver Station Dashboard,
			 * Hit the settings icon and on the bottom left there should be
			 * a box labeled 'Game Data.'
			 * Enter a 3 letter combination of L's or R's (capitalized) and
			 * test it.
			 */
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		autoSelected = chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		timer.reset();
		timer.start();
		switch (autoSelected) {
		case customAuto:
			// Put custom auto code here
			String gameData;
			//gets driver station info
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			//if we are on the left spot
			if(fieldPosition=='L') {	
				//if our switch is on the left 
				if(gameData.charAt(0) == 'L') {
					//put left auto code here
					//driving forward
					leftDrive.set(fastLeft/2);
					rightDrive.set(fastRight/2);
					Timer.delay(2);
					//turning right
					leftDrive.set(fastLeft/2);
					rightDrive.set(fastRight/6);
					Timer.delay(1);
					//if timer is this time....drive straight for a given amount of time until reaches switch
					if(timer.get() < 1.0) {
						leftDrive.set(fastLeft/2);
						rightDrive.set(fastRight/2);
					}
					//if our scale is on left
					else if(gameData.charAt(1) == 'L') {
						//driving forward
						leftDrive.set(fastLeft/2);
						rightDrive.set(fastRight/2);
						//turn right for scale
						leftDrive.set(fastLeft/2);
						rightDrive.set(fastRight/6);
						
						
					}
					
					
					
				}
				else {
					//put drive right auto code here
				}
			}
				
			break;
		case defaultAuto:
		default:
			// Put default auto code here
			break;
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}

