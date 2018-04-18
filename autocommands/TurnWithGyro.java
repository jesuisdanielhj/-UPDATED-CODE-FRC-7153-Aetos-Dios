package org.usfirst.frc.team7153.robot.autocommands;

import org.usfirst.frc.team7153.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class TurnWithGyro extends Command {
	double turning_speed;
	double desiredAngle;
	double error;
	int integral = 0;
	double kp;
	double maxSpeed;
	double tolerance=0.1;
    public TurnWithGyro(double Angle, double max, double prop) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.desiredAngle = Angle;
    	this.kp = prop;
    	this.maxSpeed = max;
    	requires(Robot.drivetrain);
    	setTimeout(2);
    	
  
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gyro.resetGyro();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	error = Math.abs(desiredAngle - Robot.gyro.getGyroAngle());
    	if (Math.abs(kp*error)>=maxSpeed) {
    		turning_speed=maxSpeed;
    	}
    	else {
    		turning_speed = kp*error;
    	}
    	if (Robot.gyro.getGyroAngle() > desiredAngle)
        {
    		Robot.drivetrain.arcadeDrive(0, -turning_speed);
    	
        }
        else
        {
        	Robot.drivetrain.arcadeDrive(0, turning_speed);
        } 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return((Math.abs(error) <= tolerance) || isTimedOut());
    }


    protected void end() {
    	Robot.drivetrain.arcadeDrive(0, 0);
    	
    	Robot.encoder.reset();
    }


    protected void interrupted() {
    }
}