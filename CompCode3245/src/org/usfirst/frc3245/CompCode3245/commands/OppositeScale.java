package org.usfirst.frc3245.CompCode3245.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OppositeScale extends CommandGroup {

    public OppositeScale(double primaryTurn) {
    	addParallel(new CAClampIn());
    	addSequential(new DriveStr8(), 3.5);
    	addParallel(new CAClampIn());
    	addSequential(new GyroTurn(primaryTurn, .045, 0, 0), 3);
    	addParallel(new CAClampIn());
    	addSequential(new DriveStr8(), 2.3);
    	addParallel(new CAClampIn());
    	addSequential(new GyroTurn(-primaryTurn, .045, 0, 0), 3);
    	addParallel(new CAClampIn());
    	addSequential(new DriveStr8(), 0.02);
    	addParallel(new CAClampIn());
    	addSequential(new ElevatorUp(), 4);
    	addSequential(new CubeScoringCommand());
    }
}
