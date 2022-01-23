package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

public class DeanaServo {

    Servo servo;

    private final double starting_position = 1.2;

    public DeanaServo(Servo s, boolean reverse) {
        servo = s;

        servo.setDirection(reverse ? Servo.Direction.REVERSE : Servo.Direction.FORWARD);
        servo.setPosition(starting_position);
    }

    public void spin() {
        servo.setPosition(1);
    }

    public void reset() {
        servo.setPosition(starting_position);
    }

}
