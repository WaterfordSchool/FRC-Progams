// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3245.CompCode3245;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3245.CompCode3245.commands.*;
import org.usfirst.frc3245.CompCode3245.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {
  
	String startingPosition;
    Command autonomousCommand;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Intake intake;
    public static Wrist wrist;
    public static Elevator elevator;
    public static CartWheels cartWheels;
    public static CartArms cartArms;
   

    public SendableChooser<String> autoChooser;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        intake = new Intake();
        wrist = new Wrist();
        elevator = new Elevator();
        cartWheels = new CartWheels();
        cartArms = new CartArms();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autoChooser = new SendableChooser();
        autoChooser.addDefault("Autonomous Default (Drives Straight)", "Drive Straight"); //need to pass this a time
        autoChooser.addObject("Left Position", "Left");
        autoChooser.addObject("Right Position", "Right");
        autoChooser.addObject("Middle Position", "Middle");
        //autoChooser.addObject("Middle Position", new AutonomousCommand());
        SmartDashboard.putData("Auto mode", autoChooser);
        
        

        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){
    	
    
    }

    @Override   
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
              
    }

    @Override
    public void autonomousInit() {
    	startingPosition =  autoChooser.getSelected();
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
        if(gameData.length() > 0) {
        	if(gameData.charAt(0) == 'L' && startingPosition == "Left") {
        		autonomousCommand = new AutonomousCommand(90.0);
        	} 
        	else if(gameData.charAt(0) == 'R' && startingPosition == "Right") {
        		autonomousCommand = new AutonomousCommand(-90.0);
        	}
        	else if(gameData.charAt(1) == 'L' && startingPosition == "Left") {
        		autonomousCommand = new ScaleAutoCommand(90.0);
        	} 
        	else if(gameData.charAt(1) == 'R' && startingPosition == "Right") {
        		autonomousCommand = new ScaleAutoCommand(-90.0);
        	}
        	else if(gameData.charAt(1) == 'L' && startingPosition == "Right") {
        		autonomousCommand = new OppositeScale(-90.0);
        	}
        	else if(gameData.charAt(1) == 'R' && startingPosition == "Left") {
        		autonomousCommand = new OppositeScale(90.0);
        	}
        	else {
			// DriveStr8();
        	}
        }
    	
        // schedule the autonomous command (example)
        if (autonomousCommand != null) {
        	
        	autonomousCommand.start();
        }
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Gyro heading is :", RobotMap.driveTrainGyro1.getAngle() );//added by LW late on 2/1
    } 

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
