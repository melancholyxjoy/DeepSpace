package frc.StateMachines;

import frc.Base.Controls;
import frc.Base.Input;
import frc.robot.Robot;

public class i_Vacuum extends Input {

    public void update() {
        setFSMState("SUCTION OFF");
        Robot.m_vacuum.update();

        setFSMState(INUSE ? getFSMState() :
                Controls.getButton(Controls.suctionButton) ? "SUCTION ON" : "SUCTION OFF");
        }
    }