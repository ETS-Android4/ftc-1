package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="DeanaController", group="Production")
public class DeanaTeleOp extends OpMode {

    DeanaController controller;

    @Override
    public void init() {
        controller = new DeanaController(hardwareMap);
    }

    @Override
    public void loop() {
        controller.move_forward(gamepad1.left_stick_y);

        if (gamepad1.a) controller.extend_arm();
        if (gamepad1.b) controller.retract_arm();

        telemetry.addData("A Button", gamepad1.a);
        telemetry.addData("B Button", gamepad1.b);
        telemetry.addData("Left Arm Position", controller.arm_l.getPosition());
        telemetry.addData("Controller", gamepad1.left_stick_y);
    }
}
