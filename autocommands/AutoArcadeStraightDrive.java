package org.usfirst.frc.team7153.robot.autocommands;

import org.usfirst.frc.team7153.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoArcadeStraightDrive extends Command {
	
	//double timeElapsed = 15 - DriverStation.getInstance().getMatchTime(); // The DriverStation gives an approximate time until the end of the period
	double turnValue;
	double tolerance = 0.5;
	double maxAngularSpeed = 0.5;
	double theshold = 0.003;
	double driveSpeed;
	double initSpeed;
	double encoder_kp;
	double desiredDist;
	double currentDist;
	double currentAngle;
	double encoder_error;
	double angle_error;
	double angle_kp=0.11;
	double turnOffset;
	double turning_speed;
    public AutoArcadeStraightDrive(double distance,double initialSpeed,double kp, double blah) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.encoder_kp = kp;
    	this.desiredDist = distance;
    	this.initSpeed = initialSpeed;
    	requires(Robot.drivetrain);
    	setTimeout(blah);
    	
    	    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gyro.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*double autoWaitTime = SmartDashboard.getNumber("Wait Timer", 0); // Gets how long to wait before moving forwards, drivers must type this in when setting up the match
		double autoDriveTime = 2;
		double timeElapsed = 15 - DriverStation.getInstance().getMatchTime(); // The DriverStation gives an approximate time until the end of the period
		if (timeElapsed >= autoWaitTime) {
			if (timeElapsed <= autoWaitTime + autoDriveTime) {
				 // Left and Right speeds, 20% power
				
				*/
    			turnValue = Robot.gyro.getTurningValue();
    			
    			currentDist = Robot.encoder.getDistance();
    			SmartDashboard.putString("CurrentDist", ""+currentDist);
    			encoder_error = desiredDist - currentDist;
    			SmartDashboard.putString("Error", ""+encoder_error);
    			if (encoder_kp*encoder_error>initSpeed) {
    				driveSpeed = initSpeed;
    			}
    			else {
    				driveSpeed=encoder_kp*encoder_error;
    			}
    			
    			
    			angle_error = 0 - Robot.gyro.getGyroAngle();
    	    	if (angle_kp*angle_error>=maxAngularSpeed) {
    	    		turning_speed=maxAngularSpeed;
    	    	}
    	    	else {
    	    		turning_speed = angle_kp*angle_error;
    	    	}
    	    	if (Robot.gyro.getGyroAngle() > 0)
    	        {
    	    		Robot.drivetrain.arcadeDrive(driveSpeed, -turning_speed);
    	    		//Robot.drivetrain.arcadeDrive(0, 0.6);
    	        }
    	        else
    	        {
    	        	Robot.drivetrain.arcadeDrive(driveSpeed, turning_speed);
    	        	//Robot.drivetrain.arcadeDrive(0, -0.6);
    	        }
				SmartDashboard.putNumber("turnOffset Value:", turnOffset);
				SmartDashboard.putNumber("turn speed:", turnValue);
				
				///
    			
				//Robot.drivetrain.arcadeDrive(driveSpeed, turnOffset);
				//Robot.drivetrain.arcadeDrive(0.6, turnOffset);
			}
    	
//    }	
 //   }
    	

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((Math.abs(encoder_error) <= tolerance)||isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.arcadeDrive(0, 0);
    	Robot.gyro.resetGyro();
    	Robot.encoder.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
