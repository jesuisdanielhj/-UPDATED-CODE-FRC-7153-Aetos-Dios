package org.usfirst.frc.team7153.robot.commands;

import org.usfirst.frc.team7153.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootTheCUBE extends Command {

    public ShootTheCUBE() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intakemotors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intakemotors.StopPUSHING();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intakemotors.HeyFetchThatCubeShallWeNot(0.6);
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intakemotors.StopPUSHING();
    }
}
