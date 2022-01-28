package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;

public class DeanaServo {

    CRServo servo;

    private final double starting_position = 0;
    public double position;

    public DeanaServo(CRServo s, boolean r) {
        servo = s;

        reverse(r);
        servo.setPower(0);
    }

    public void spin(double power) {
        servo.setPower(power);
    }

    public void reverse(boolean r) {
        servo.setDirection(r ? CRServo.Direction.REVERSE : CRServo.Direction.FORWARD);
    }

}
