package org.usfirst.frc.team7153.robot.commands;

import org.usfirst.frc.team7153.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class Extend extends Command {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Extend() {
		
		requires(Robot.armsol);
	
	}
	
protected void initialize() {
		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*if (Robot.m_oi.whetherExtend()==false) {
    		Robot.armsol.SolenoidB();
    	}
    	else 
    	{
    		Robot.armsol.SolenoidF();
    	}
    	
    	}
    
*/
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

