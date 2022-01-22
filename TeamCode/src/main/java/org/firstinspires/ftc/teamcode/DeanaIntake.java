package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;

public class DeanaIntake {

    CRServo servo;

    public DeanaIntake(CRServo s) {
        servo = s;
        s.setDirection(CRServo.Direction.FORWARD);
    }

    public void run(double power) {
        servo.setPower(power);
    }

}
