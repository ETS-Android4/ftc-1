package org.firstinspires.ftc.teamcode.old;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Arm and Servo Testing", group="Experimental")
public class Testing extends OpMode {

    private DcMotor lift_left;
    private DcMotor lift_right;
    private final int target_position = 1000;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing...");
        telemetry.update();

        lift_left = hardwareMap.get(DcMotor.class, "lift_l");
        lift_right = hardwareMap.get(DcMotor.class, "lift_r");

        lift_left.setTargetPosition(0);
        lift_left.setDirection(DcMotorSimple.Direction.FORWARD);
        lift_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        lift_right.setTargetPosition(0);
        lift_right.setDirection(DcMotorSimple.Direction.FORWARD);
        lift_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        if (gamepad1.a && lift_left.getCurrentPosition() == lift_left.getTargetPosition() && lift_left.getTargetPosition() == 0) {
            lift_left.setTargetPosition(target_position);
        } else if (lift_left.getCurrentPosition() == lift_left.getTargetPosition() && lift_left.getCurrentPosition() == target_position) {
            lift_left.setTargetPosition(0);
        }

        telemetry.addData("Current", lift_left.getCurrentPosition());

        lift_left.setPower(0.5);
    }
}
