package org.usfirst.frc.team3166.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeft extends CommandGroup {

    public AutoLeft() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new ResetEncoders());
    	addSequential(new DriveStraightPID(5000, 1, 0, 0));
    	addSequential(new ResetEncoders());
    	addSequential(new Turn(), 2);
    	addSequential(new ResetEncoders());
    	addSequential(new DriveStraightPID(2000, 1, 0, 0));
    }
}
