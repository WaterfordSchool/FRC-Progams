package org.usfirst.frc3245.CompCode3245.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OppositeScale extends CommandGroup {

    public OppositeScale(double primaryTurn) {
    	addParallel(new CAClampIn());
    	addSequential(new DriveStr8(), 3.15);
    	addParallel(new CAClampIn());
    	addSequential(new GyroTurn(primaryTurn, .045, 0, 0), 1.8);
    	addParallel(new CAClampIn());
    	addSequential(new DriveStr8(), 3);
    	addParallel(new CAClampIn());
    	addSequential(new GyroTurn(-primaryTurn, .045, 0, 0), 1.3);
    	//addParallel(new CAClampIn());
    	//addSequential(new DriveStr8(), 0.04);
    	addParallel(new CAClampIn());
    	addSequential(new ElevatorUp(), 4);
    	addParallel(new CAClampIn());
    	addSequential(new DriveStr8(), 0.2);
    	//addSequential(new CubeScoringCommand());
    }
}
