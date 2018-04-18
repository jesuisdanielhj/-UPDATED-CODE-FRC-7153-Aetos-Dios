package org.usfirst.frc.team7153.robot.commands;

import org.usfirst.frc.team7153.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithLowSpeed extends Command {

    public DriveWithLowSpeed() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double forward = Robot.m_oi.Forward()/1.6;
    	double backward = Robot.m_oi.Backward()/1.6;
    	double throttle;
    	double turn = Robot.m_oi.DriveLeftAndRight()/2;
    	if ((forward>0.05)&&(backward>0.05)) {
    		throttle = 0;
    		
    	}
    	else if (forward>0.05) {
    		throttle = forward;
    		
    	}
    	else if (backward>0.05) {
    		throttle = -backward;
    		turn = -turn;
    	}
    	else {
    		throttle = 0;
    		
    	}
    	
    	
    	Robot.drivetrain.arcadeDrive(throttle, turn);
    	
    
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
    	Robot.drivetrain.initDefaultCommand();
    }
}
