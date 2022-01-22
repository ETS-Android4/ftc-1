package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class DeanaArm {

    private final int extend_length = 8000;
    private DcMotor motor;

    public DeanaArm(DcMotor m, boolean reverse) {
        motor = m;

        motor.setTargetPosition(0);
        if (reverse) motor.setDirection(DcMotor.Direction.REVERSE);
        else motor.setDirection(DcMotor.Direction.FORWARD);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void run() {
        motor.setPower(0.75);
    }

    public void set_position(int position) {
        motor.setTargetPosition(position);
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
