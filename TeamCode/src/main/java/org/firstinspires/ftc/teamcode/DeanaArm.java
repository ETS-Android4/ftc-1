package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class DeanaArm {

    private final int extend_length = 1000;
    private DcMotor motor;

    public DeanaArm(DcMotor m) {
        motor = m;

        motor.setTargetPosition(0);
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void run() {
        motor.setPower(0.5);
    }

    public int getPosition() {
        return motor.getCurrentPosition();
    }

    public void extend() {
        motor.setTargetPosition(extend_length);
    }

    public void retract() {
        motor.setTargetPosition(0);
    }

    public boolean asked() {
        return false;
    }
}
