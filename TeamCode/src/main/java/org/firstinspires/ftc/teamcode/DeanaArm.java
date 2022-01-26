package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class DeanaArm {

    private final int extend_length = 8000;
    private DcMotor motor;
    private int offset;

    public boolean arm_moving;

    public DeanaArm(DcMotor m, boolean reverse) {
        this(m, reverse, 0);
    }

    public DeanaArm(DcMotor m, boolean reverse, int o) {
        motor = m;
        offset = o;

        if (reverse) motor.setDirection(DcMotor.Direction.REVERSE);
        else motor.setDirection(DcMotor.Direction.FORWARD);
        retract();
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void run() {
        if (motor.getTargetPosition() != motor.getCurrentPosition()) {
            if (motor.getCurrentPosition() < 2250) motor.setPower(0.3);
            else if (motor.getCurrentPosition() < 2300) motor.setPower(0.4);
            else if (motor.getCurrentPosition() < 2350) motor.setPower(0.5);
            else if (motor.getCurrentPosition() < 2400) motor.setPower(0.6);
            else if (motor.getCurrentPosition() < 2450) motor.setPower(0.7);
            else motor.setPower(0.8);
            arm_moving = true;
        } else arm_moving = false;
    }

    public void set_position(int position) {
        motor.setTargetPosition(position + offset);
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
