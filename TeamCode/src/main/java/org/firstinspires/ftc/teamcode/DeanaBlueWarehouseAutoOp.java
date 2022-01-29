package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.DeanaController;


@Autonomous(name = "Deana Blue Warehouse", group = "Deana")
public class DeanaBlueWarehouseAutoOp extends LinearOpMode {

    DeanaController controller;
    int m = 1;

    @Override
    public void runOpMode() throws InterruptedException {

        controller = new DeanaController(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            controller.starting_position();
            run_arm(0.5);

            controller.move_forward(0.5 * m);
            sleep(800);
            controller.move_forward(0.0);
            standard_pause();

            controller.rotate(-0.5);
            sleep(800);
            controller.rotate(0.0);
            standard_pause();

            controller.move_forward(1.0);
            sleep(1000);
            controller.move_forward(0.0);
            standard_pause();
        }
    }

    private void standard_pause() {
        sleep(2000);
    }

    private void run_arm(double power) {
        while(controller.arm_moving) {
            controller.run_arm(power);
            telemetry.addData("Target", controller.arm_l.motor.getTargetPosition());
            telemetry.addData("Current", controller.arm_r.motor.getCurrentPosition());
            telemetry.update();
        }
    }
}