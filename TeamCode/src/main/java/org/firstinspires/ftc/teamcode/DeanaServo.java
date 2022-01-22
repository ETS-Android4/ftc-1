package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

public class DeanaServo {

    Servo servo;

    public DeanaServo(Servo s, boolean reverse) {
        servo = s;

        servo.setDirection(reverse ? Servo.Direction.REVERSE : Servo.Direction.FORWARD);
        servo.setPosition(0);
    }

    public void spin() {
        servo.setPosition(20);
    }

    public void reset() {
        servo.setPosition(0);
    }

}
