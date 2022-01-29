package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.DeanaController;

@Autonomous(name = "Deana Default", group = "Deana")
public class DeanaDefault extends LinearOpMode {
    DeanaController controller;


    @Override
    public void runOpMode() throws InterruptedException {
        controller = new DeanaController(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()) {
            controller.set_arm_position(1200);
            while (controller.arm_moving) controller.run_arm();
            controller.spin_cup(-1.0);
            sleep(300);
            controller.spin_cup(0.0);
            sleep(1000);
            break;
        }
    }
}
