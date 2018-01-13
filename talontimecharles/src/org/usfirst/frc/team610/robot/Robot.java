package org.usfirst.frc.team610.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	TalonSRX leftIntake, rightIntake, rightDrive, leftDrive;
	Joystick driver;
	boolean pressed;
	
	double leftIntakeSpeed = 0, rightIntakeSpeed = 0;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		driver       = new Joystick(0);
		leftIntake   = new TalonSRX(1);
		rightIntake  = new TalonSRX(2);
		rightDrive   = new TalonSRX(3);
		leftDrive    = new TalonSRX(4);
				
		leftDrive.set(ControlMode.PercentOutput, 0);
		rightDrive.set(ControlMode.PercentOutput, 0);
		leftIntake.set(ControlMode.PercentOutput, 0);
		rightIntake.set(ControlMode.PercentOutput, 0);
	}
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		double x = driver.getRawAxis(2);
		double y = driver.getRawAxis(1);
		if (driver.getRawButton(8)) {
			leftIntakeSpeed = driver.getRawAxis(1);
			rightIntakeSpeed = driver.getRawAxis(3);
			x = 0; y=0;
		}		
		
		double leftSpeed = -(x + y);
		double rightSpeed = -(x - y);
		leftIntake.set(ControlMode.PercentOutput, leftIntakeSpeed);
		rightIntake.set(ControlMode.PercentOutput, rightIntakeSpeed);
		
		leftDrive.set(ControlMode.PercentOutput, leftSpeed);
		rightDrive.set(ControlMode.PercentOutput, rightSpeed);

		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		leftDrive.set(ControlMode.PercentOutput, 1);
		rightDrive.set(ControlMode.PercentOutput, 1);
		leftIntake.set(ControlMode.PercentOutput, 1);
		rightIntake.set(ControlMode.PercentOutput, 1);
	}
	
	@Override
	public void disabledPeriodic(){
		leftDrive.set(ControlMode.PercentOutput, 1);
		rightDrive.set(ControlMode.PercentOutput, 1);
		leftIntake.set(ControlMode.PercentOutput, 1);
		rightIntake.set(ControlMode.PercentOutput, 1);
	}
}

