// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc253.joman4Motors;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController movementLeftFront;
    public static SpeedController movementLeftRear;
    public static SpeedController movementRightFront;
    public static SpeedController movementRightRear;
    public static RobotDrive movementMotors;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        movementLeftFront = new Talon(0);
        LiveWindow.addActuator("Movement", "LeftFront", (Talon) movementLeftFront);
        
        movementLeftRear = new Talon(1);
        LiveWindow.addActuator("Movement", "LeftRear", (Talon) movementLeftRear);
        
        movementRightFront = new Talon(2);
        LiveWindow.addActuator("Movement", "RightFront", (Talon) movementRightFront);
        
        movementRightRear = new Talon(3);
        LiveWindow.addActuator("Movement", "RightRear", (Talon) movementRightRear);
        
        movementMotors = new RobotDrive(movementLeftFront, movementLeftRear,
              movementRightFront, movementRightRear);
        
        movementMotors.setSafetyEnabled(true);
        movementMotors.setExpiration(0.1);
        movementMotors.setSensitivity(0.5);
        movementMotors.setMaxOutput(1.0);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
