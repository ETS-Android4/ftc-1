package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Deana Timed AutoOp", group = "Deana")
public class DeanaTimedAutoOp extends LinearOpMode {

    DeanaController controller;

    @Override
    public void runOpMode() throws InterruptedException {
        controller = new DeanaController(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        if (opModeIsActive()) {
            controller.starting_position();
            run_arm(0.5);
            telemetry.addData("Current", controller.arm_l.motor.getCurrentPosition());
            telemetry.addData("Target", controller.arm_l.motor.getTargetPosition());

            // Move out
            controller.move_forward(1);
            sleep(475);
            controller.move_forward(0);
            standard_pause();

            // Rotate towards fondue table
            controller.rotate(1);
            sleep(400);
            controller.rotate(0);
            standard_pause();

            // Move toward fondue table
            controller.move_forward(1);
            sleep(230);
            controller.move_forward(0);
            standard_pause();

            // Extend arm
            controller.extend_arm();
            run_arm(0.5);
            standard_pause();

            // Rotate cup
            controller.spin_cup(-1.0);
            sleep(300);
            controller.spin_cup(0.0);
            standard_pause();

            // Rotate intake
            controller.run_intake(-1.0);
            sleep(1000);
            controller.run_intake(0.0);
            standard_pause();

            // Rotate cup back
            controller.spin_cup(1.0);
            sleep(300);
            controller.spin_cup(0.0);
            standard_pause();

            // Retract arm
            controller.starting_position();
            run_arm(0.5);

            // Move to carousel
            controller.move_forward(-1.0);
            sleep(800);
            controller.move_forward(0.0);
            standard_pause();

            // Rotate carousel
            controller.run_carousel(1.0);
            sleep(2000);
            controller.run_carousel(0.0);
            standard_pause();

            sleep(1000);
        }
    }

    private void standard_pause() {
        sleep(100);
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
