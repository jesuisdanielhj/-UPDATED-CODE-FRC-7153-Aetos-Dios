package org.usfirst.frc.team7153.robot.autocommands;

import org.usfirst.frc.team7153.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class drive_straight_test extends CommandGroup {

    public drive_straight_test() {
    	double ticksPerInch = 100.0/40.0;

       	requires(Robot.drivetrain);
       /*	requires(Robot.gyro);
       	
       
       */
    	addSequential(new AutoArcadeStraightDrive(240*ticksPerInch,0.6, 1,15));
    }
}
