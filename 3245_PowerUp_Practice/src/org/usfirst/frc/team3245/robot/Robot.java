<<<<<<< HEAD
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
	//String DriverStation;
	SendableChooser<String> chooser = new SendableChooser<>();
	double fastLeft = 1.0, fastRight = 1.0 , slowRight = 0.5, slowLeft = 0.5;
	//topSlowSpeed = ?; 
	private static final double kAngleSetpoint = 0.0; // The set angle of the gyro
	private static final double kP = 0.005; //proportional turning constant
	
	//We may need to adjust the calibration constant
	//A gyro value of 360 is equivalent to one full revolution
	private static final double kVoltsPerDegreePerSecond = 0.0128;
	
	//These are the ports for the gyro and and motors
	private static final int kLeftMotorPort = 1;
	private static final int kRightMotorPort = 3;
	private static final int kGyroPort = 3; // May need changing depending on which port we choose
	private static final int kJoystickPort = 1; //This is set to be in the operator's controller
	//need a new pmw cable for gyro 
	//This is where the gyro is being declared
	private AnalogGryro m_gyro = new AnalogGyro(kGyroPort);
	private Joystick m_joystick = new Joystick(kJoystickPort);
	


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
					if(timer.get() < 2.0) {
					leftDrive.set(fastLeft/2);
					rightDrive.set(fastRight/2);
					}
					Timer.delay(2);
					//turning right normal code
					//if(timer.get() < 0.5) {
					//leftDrive.set(fastLeft/2);
					//rightDrive.set(fastRight/6);
					double turningValue = (kAngleSetPoint - m_gyro.getAngle(-90)) * kP;
						//invert the direction of the turn if we're going backwards
					turningValue = Math.copySign(turningValue, m_joystick.getY());
					}
					Timer.delay(2);
					//if timer is this time....drive straight for a given amount of time until reaches switch
					if(timer.get() < 1.0) {
						leftDrive.set(fastLeft/2);
						rightDrive.set(fastRight/2);
					}
					//score on scale
				}
					//if our scale is on left
					else if(gameData.charAt(1) == 'L') {
						//driving forward
						if(timer.get() < 1.0) {
						leftDrive.set(fastLeft/2);
						rightDrive.set(fastRight/2);
						}
						if(timer.get() < 0.5) {
						//turn right for scale
						leftDrive.set(fastLeft/2);
						rightDrive.set(fastRight/6);
						}
						//raise elevator at some point
						//score on scale
						}
					
					
					
				
				//switch on right
				else {
					//driving forward
					leftDrive.set(fastLeft/2);
					rightDrive.set(fastRight/2);
					//turning right halfway between scale and switch
					leftDrive.set(fastLeft/2);
					rightDrive.set(fastRight/6);
					//drive forward to right side of scale
					leftDrive.set(fastLeft/2);
					rightDrive.set(fastRight/2);
					//turn left to scale
					leftDrive.set(fastLeft/6);
					rightDrive.set(fastRight/2);
					//drive to middle of scale
					leftDrive.set(fastLeft/2);
					rightDrive.set(fastRight/2);
					//turn left to scale
					leftDrive.set(fastLeft/6);
					rightDrive.set(fastRight/2);
					//timed drive forward 
					//need to find proper time
					if(timer.get()< 0.5) {
						leftDrive.set(fastLeft/2);
						rightDrive.set(fastRight/2);
					}
					
				}
			}
			//if we are on right of the field 
			if(fieldPosition == 'R') {
				//if our switch is on  the right
				if(gameData.charAt(0)== 'R') {
					//drive forward
					leftDrive.set(fastLeft/2);
					rightDrive.set(fastRight/2);
					//turning left to switch
					leftDrive.set(fastLeft/6);
					rightDrive.set(fastRight/2);
					if(timer.get() < 1) {
						leftDrive.set(fastLeft/2);
						rightDrive.set(fastRight/2);
					}
					//score on switch
					else if(gameData.charAt(1) == 'R') {
						//drive forward
						leftDrive.set(fastLeft/2);
						rightDrive.set(fastRight/2);
						//turning left to scale
						leftDrive.set(fastLeft/6);
						rightDrive.set(fastRight/2);
						//driving to scale
						//need to figure out exact time
						if(timer.get() < 0.5){
							leftDrive.set(fastLeft/2);
							rightDrive.set(fastRight/2);
						}
						//if our scale on left side
						else {
							//drive forward halfway between scale and switch
							leftDrive.set(fastLeft/2);
							rightDrive.set(fastRight/2);
						}
						
					}
				
					
					
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



