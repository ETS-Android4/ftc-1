package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Function;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name = "Deana Blue Carousel", group = "Deana")
public class DeanaBlueCarouselAutoOp extends LinearOpMode {

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
            run_arm(0.85);
            telemetry.addData("Current", controller.arm_l.motor.getCurrentPosition());
            telemetry.addData("Target", controller.arm_l.motor.getTargetPosition());

            // Move out
            controller.move_forward(0.5 * m);
            sleep(900);
            controller.move_forward(0);
            standard_pause();

            // Rotate towards fondue table
            controller.rotate(0.5 * m);
            sleep(700);
            controller.rotate(0);
            standard_pause();

            // Move toward fondue table
            controller.move_forward(0.5 * m);
            sleep(480);
            controller.move_forward(0);
            standard_pause();

            // Extend arm
            controller.extend_arm();
            run_arm(0.85);
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
            sleep(600);
            controller.spin_cup(0.0);
            standard_pause();

            // Retract arm
            controller.starting_position();
            run_arm(0.85);

            // Move to carousel
            controller.move_forward(-0.5 * m);
            sleep(1650);
            controller.move_forward(0.0);
            standard_pause();

            // Rotate carousel
            controller.run_carousel(1.0 * m);
            sleep(2000);
            controller.run_carousel(0.0);
            standard_pause();

            // Move back
            controller.move_forward(0.5 * m);
            sleep(200);
            controller.move_forward(0.0);
            standard_pause();

            // Rotate
            controller.rotate(0.5 * m);
            sleep(400);
            controller.rotate(0.0);
            standard_pause();

            // Strafe
            controller.strafe(-0.5 * m);
            sleep(1100);
            controller.strafe(0.0);
            standard_pause();

            // Forward adjustment
            controller.move_forward(-0.5 * m);
            sleep(300);
            controller.move_forward(0.0);
            standard_pause();

            sleep(1000);
            break;
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
