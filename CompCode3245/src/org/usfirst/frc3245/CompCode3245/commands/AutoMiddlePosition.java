package org.usfirst.frc3245.CompCode3245.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddlePosition extends CommandGroup {


    public AutoMiddlePosition(double primaryTurn) {	
    		addParallel(new CAClampIn());
    		addSequential(new DriveStr8(), 0.5);
    	    addParallel(new CAClampIn());
    	    addSequential(new GyroTurn(primaryTurn, .045, 0, 0), 1.8);
    	    addParallel(new CAClampIn());
    	    addSequential(new DriveStr8(), 1.0);
    	    addParallel(new CAClampIn());
    	    addSequential(new GyroTurn(-primaryTurn, .045, 0, 0), 1.8);
    	    addParallel(new CAClampIn());
    	    addSequential(new DriveStr8(), 0.08);
    	    addParallel(new CAClampIn());
    	    addSequential(new ElevatorUp(), 2);
    	    addSequential(new CubeScoringCommand());
    	    }
    }

