package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.Base.*;
import frc.External.e_LimeLightVision;
import frc.External.e_Navx;
import frc.StateMachines.*;
import frc.Subsystems.*;
import frc.auto.i_Auto;
import frc.auto.m_Auto;

public class Robot extends TimedRobot {
    public static e_Navx e_navx;
    public static e_LimeLightVision e_limeLightVision;

    public static b_Drivetrain b_drivetrain;

    public static m_Drivetrain m_drivetrain;
    public static m_Auto m_auto;
    public static m_Arm m_arm;
    public static m_Climber m_climber;
    public static m_Vacuum m_vacuum;
    public static m_Wrist m_wrist;

    public static i_Drivetrain i_drivetrain;
    public static i_Auto i_auto;
    public static i_Arm i_arm;
    public static i_Climber i_climber;
    public static i_Vacuum i_vacuum;
    public static i_Wrist i_wrist;

    public void robotInit() {
        e_navx = new e_Navx();
        e_limeLightVision = new e_LimeLightVision();

        b_drivetrain = new b_Drivetrain();

        m_drivetrain = new m_Drivetrain();
        m_auto = new m_Auto();
        m_arm = new m_Arm();
        m_climber = new m_Climber();
        m_vacuum = new m_Vacuum();
        m_wrist = new m_Wrist();

        i_drivetrain = new i_Drivetrain();
        i_auto = new i_Auto();
        i_arm = new i_Arm();
        i_climber = new i_Climber();
        i_vacuum = new i_Vacuum();
        i_wrist = new i_Wrist();

        b_drivetrain.setDriveTrainType("Tank");
        m_drivetrain.resetEncoders();
        e_navx.resetGyro();
        Operator.update();
    }
    public void robotPeriodic() {
        Operator.update();
    }
    public void autonomousInit() {
        Robot.m_drivetrain.resetEncoders(); }
    public void autonomousPeriodic() {
        //i_auto.update();
        MotionCalculation.setSystem("Auto");
        if (!MotionCalculation.isFinished()) {
            System.out.println(MotionCalculation.getError() + "  " + Robot.m_drivetrain.getEncodervalues());
            Robot.m_drivetrain.TankLeft((MotionCalculation.normalize(10,1, Robot.m_drivetrain.getEncodervalues(), 1)));
            Robot.m_drivetrain.TankRight((MotionCalculation.normalize(8,1, Robot.m_drivetrain.getEncodervalues(), 1)));
        }
        else {
            Robot.m_drivetrain.TankLeft((MotionCalculation.normalize(90,5, Robot.e_navx.getYaw(), 1)));
            Robot.m_drivetrain.TankRight((MotionCalculation.normalize(90,5, Robot.e_navx.getYaw(), 1)));
        }
    }
    public void teleopInit() {
        e_navx.resetGyro();
    }
    public void teleopPeriodic() { }
}
