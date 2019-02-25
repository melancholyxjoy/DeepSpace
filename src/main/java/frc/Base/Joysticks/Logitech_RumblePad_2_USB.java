package frc.Base.Joysticks;

import frc.Base.Controls;

public class Logitech_RumblePad_2_USB extends Controls {
    public static void DriveJOY() {
        xAxis = 2;
        yAxis = 1;
        zAxis = 1;
        axisDirection = -1;

        ThrottleType = "Button Based";

        increaseThrottleButton = 7;
        decreaseThrottleButton = 8;
    }
    public static void SystemJOY() {
        levelUpButton = 2;
        levelDownButton = 3;
        suctionButton = 5;
        climbButton = 6;
        autonomousButton = 7;
        solonoidButton = 8;
    }
    public static void OmniJOY() {xAxis = 1;
        yAxis = 4;
        zAxis = 1;
        axisDirection = -1;

        ThrottleType = "Button Based";

        increaseThrottleButton = 1;
        decreaseThrottleButton = 2;
        increaseThrottleAxis = 1;
        decreaseThrottleAxis = 2;
        oneAxisThrottleAxis = 3;

        levelUpButton = 2;
        levelDownButton = 3;
        suctionButton = 5;
        climbButton = 6;
        autonomousButton = 7;
        solonoidButton = 8;
    }
}
