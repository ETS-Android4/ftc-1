package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name="DeanaController", group="Production")
public class DeanaTeleOp extends OpMode {

    DeanaController controller;

    @Override
    public void init() {
        controller = new DeanaController(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.right_stick_x == 0 ) controller.move_forward(-gamepad1.left_stick_y);
        if (gamepad1.left_stick_y == 0) controller.rotate(-gamepad1.right_stick_x);

        if (gamepad1.a) controller.extend_arm();
        if (gamepad1.b) controller.retract_arm();
        if (gamepad1.y) controller.starting_position();

        if (controller.arm_moving) controller.run_arm();

        telemetry.addData("Controller A ", gamepad1.id < 0 ? "not connected" : "connected");
        telemetry.addData("Controller B ", gamepad2.id < 0 ? "not connected" : "connected");
    }
}
