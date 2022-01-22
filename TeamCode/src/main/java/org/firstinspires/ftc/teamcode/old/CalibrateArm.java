package org.firstinspires.ftc.teamcode.old;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Calibrate Arm", group="Experimental")
public class CalibrateArm extends OpMode {

    private DcMotor arm_motor;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing...");
        telemetry.update();

        arm_motor = hardwareMap.get(DcMotor.class, "lift_r");

        arm_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        //arm_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        arm_motor.setPower(gamepad1.left_stick_y);
        telemetry.addData("Target Position", arm_motor.getTargetPosition());
    }
}
