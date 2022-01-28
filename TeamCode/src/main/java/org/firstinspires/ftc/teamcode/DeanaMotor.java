package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class DeanaMotor {

    private DcMotor motor;

    public DeanaMotor(DcMotor m, boolean reverse) {
        motor = m;

        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        if (reverse) motor.setDirection(DcMotor.Direction.REVERSE);
        else motor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void run(double power) {
        motor.setPower(power);
    }
}
