package org.usfirst.frc.team7153.robot.autocommands;

import org.usfirst.frc.team7153.robot.Robot;
import org.usfirst.frc.team7153.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrosslineScaleLeft extends CommandGroup {

    public CrosslineScaleLeft() {
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
    	double ticksPerInch = RobotMap.ticksPerInch;

    	requires(Robot.drivetrain);
    	addSequential(new AutoArcadeStraightDrive(300*ticksPerInch,0.7, 0.08,10));
    	addSequential(new TurnWithGyro(45,0.6,0.08)); 
   
    	addParallel(new ArmLevel(1700,0.75,0.08,1.5));

    	addSequential(new DropCube(0.5));    
    }
}
