package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

public class DeanaServo {

    Servo servo;

    private final double starting_position = 0;
    public double position;

    public DeanaServo(Servo s, boolean reverse) {
        servo = s;

        servo.setDirection(reverse ? Servo.Direction.REVERSE : Servo.Direction.FORWARD);
        servo.scaleRange(0.0, 1.0);
        servo.setPosition(starting_position);
    }

    public void spin(double amount) {
        position += amount;

        if (position > 1) position = 1;
        else if (position < -1) position = -1;

        servo.setPosition(position);
    }

    public void reset() {
        servo.setPosition(starting_position);
    }

}
