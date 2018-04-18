package org.usfirst.frc.team7153.robot.autocommands;

import org.usfirst.frc.team7153.robot.Robot;
import org.usfirst.frc.team7153.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrosslineFromCenter_90Right extends CommandGroup {

    public CrosslineFromCenter_90Right() {
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

    
    	/*addSequential(new AutoArcadeStraightDrive(250,0.6, 0.0089,3));
    	
   
    	//addParallel(new GetTheCUBE(1.5));
    	addSequential(new ArmLevel(1600,0.65,0.0089,1.5));
    	addSequential(new AutoArcadeStraightDrive(150,0.6,0.0089,1.5) );

    	addSequential(new DropCube(0.5));    
    	addSequential(new AutoArcadeStraightDrive(150,0.6, 0.0089,1));
    	*/
    	addSequential(new AutoArcadeStraightDrive(96*ticksPerInch,0.6, 1,5));
    	addSequential(new ArmLevel(1600,0.65,0.0089,1.5));
    	addSequential(new AutoArcadeStraightDrive(24*ticksPerInch,0.6, 1,1.5));
    	addSequential(new DropCube(0.5));    




    	
    }
}
