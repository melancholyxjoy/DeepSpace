package frc.External;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Robot;

public class e_LimeLightVision {
    public NetworkTableEntry tx;
    public NetworkTableEntry ty;
    public NetworkTableEntry ta;
    public NetworkTableEntry tv;

    double x = 0;
    double y = 0;
    double area = 0;

    double targetHeight;
    double camHeight;
    
    public e_LimeLightVision() {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        tv = table.getEntry("tv");

        //post to smart dashboard periodically
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
    }
    public double getContourInfo(String variablename) {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry(variablename).getDouble(0);
    }
    public void setCameraControls(String variablename, double value) {
        NetworkTableInstance.getDefault().getTable("limelight").getEntry(variablename).setNumber(value);
    }
    public double getX() {
        return tx.getDouble(0);
    }
    public double getY() {
        return ty.getDouble(0);
    }
    public double getArea() {
        return ta.getDouble(0);
    }
    public double getTarget() {
        return tv.getDouble(0);
    }
    public double getDistance() { return Math.abs((targetHeight - camHeight) / getY());}
}
