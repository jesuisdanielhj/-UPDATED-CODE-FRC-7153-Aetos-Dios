package org.usfirst.frc.team7153.robot.autocommands;

import org.usfirst.frc.team7153.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrosslineDrop_Side_Right extends CommandGroup {

    public CrosslineDrop_Side_Right() {
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
    	requires(Robot.drivetrain);
        addSequential(new AutoArcadeStraightDrive(450,0.6, 0.0089,4.5));
    	addSequential(new TurnWithGyro(-90,0.6,0.08)); 
    	addParallel(new ArmLevel(1400,0.75,0.0089,1.5));
    	addSequential(new AutoArcadeStraightDrive(150,0.5,0.0089,1.5) );

    	addSequential(new DropCube(0.5));     
    	
    }
}
