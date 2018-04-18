package org.usfirst.frc.team7153.robot.commands;

import org.usfirst.frc.team7153.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Stretch extends Command {

    public Stretch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.armsol);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double POVvalue= Robot.m_oi.POVvalue();
    	if (((POVvalue<90)&(POVvalue>=0))||(POVvalue>270)) {
    		Robot.armsol.SolenoidB();
    	}
    	else if ((POVvalue>90)&((POVvalue<270))) {
    		Robot.armsol.SolenoidF();
    	}
    	else if ((POVvalue<0)) {
    		Robot.armsol.SolenoidDoNothing();
    	}
    	
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
    	
    }
}
