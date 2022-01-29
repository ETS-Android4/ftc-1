package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Deana Blue Carousel", group = "Deana")
public class DeanaAutoOp extends LinearOpMode {

    DeanaController controller;

    @Override
    public void runOpMode() throws InterruptedException {
        controller = new DeanaController(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while(opModeIsActive()) {
            controller.move_forward(1);
            sleep(475);
            controller.move_forward(0);
            sleep(1000);

            break;
        }
    }
}
